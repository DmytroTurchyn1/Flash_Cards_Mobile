package com.app.flashcards.feature.main

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.app.flashcards.R
import com.app.flashcards.databinding.ActivityMainBinding
import com.app.flashcards.util.Launcher
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.android.play.core.ktx.isFlexibleUpdateAllowed
import com.google.android.play.core.ktx.isImmediateUpdateAllowed
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presenter: MainPresenter
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdView: AdView
    private lateinit var appUpdateManager: AppUpdateManager
    private  val updateType = AppUpdateType.FLEXIBLE

    override fun onCreate(savedInstanceState: Bundle?) {
        val startSplashScreen = installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        startSplashScreen.setKeepOnScreenCondition(){true}
        binding.ivLogo.setImageResource(R.drawable.app_logo)
        presenter = MainPresenter(this)
        binding.btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        get_token()
        initAdmob()
        askNotificationPermission()
        appUpdateManager = AppUpdateManagerFactory.create(applicationContext)
        if (updateType == AppUpdateType.FLEXIBLE){
            appUpdateManager.registerListener(installStateUpdatedListener)
        }
        checkForUpdates()

    }
    private  val installStateUpdatedListener = InstallStateUpdatedListener{ state->
        if (state.installStatus() == InstallStatus.DOWNLOADED){
            Toast.makeText(this,"Downloaded, Restarting in 5 seconds...", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch {
                delay(5.seconds)
                appUpdateManager.completeUpdate()
            }
        }

    }
    private fun checkForUpdates() {
        appUpdateManager.appUpdateInfo.addOnSuccessListener {info ->
            val isUpdateAvailable = info.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
            val isUpdateAllowed  = when(updateType){
                AppUpdateType.FLEXIBLE -> info.isFlexibleUpdateAllowed
                AppUpdateType.IMMEDIATE -> info.isImmediateUpdateAllowed
                else -> false
            }
            if(isUpdateAvailable && isUpdateAllowed) {
                appUpdateManager.startUpdateFlowForResult(info,updateType,this,123)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 123){
            if (resultCode != RESULT_OK) Toast.makeText(this, "Something went wrong...", Toast.LENGTH_SHORT).show()
        }
    }
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission granted, handle accordingly
            // FCM SDK (and your app) can post notifications.
        } else {
            // Permission denied, handle accordingly
            Toast.makeText(this,"Notifications were disabled.", Toast.LENGTH_LONG).show()
        }
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onResume() {
        super.onResume()
        binding.adView.resume()
        if (updateType == AppUpdateType.IMMEDIATE){
        appUpdateManager.appUpdateInfo.addOnSuccessListener(){ info ->
            if (info.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS)
            appUpdateManager.startUpdateFlowForResult(info,updateType,this,123)
        }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.adView.destroy()
        if (updateType == AppUpdateType.FLEXIBLE) appUpdateManager.unregisterListener(installStateUpdatedListener)
    }

    override fun onPause() {
        super.onPause()
        binding.adView.pause()
    }

    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun initAdmob() {
        MobileAds.initialize(this)
        mAdView = binding.adView
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }

    override fun get_token() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener() { task ->
            if(!task.isSuccessful){
                return@addOnCompleteListener
            }
            val token = task.result
            println("token ${token}")
        }
    }
    override fun askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
                PackageManager.PERMISSION_GRANTED
            ) {
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                // TODO: display an educational UI explaining to the user the features that will be enabled
                //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
                //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
                //       If the user selects "No thanks," allow the user to continue without notifications.
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }
}
