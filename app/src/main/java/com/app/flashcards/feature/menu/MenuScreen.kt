package com.app.flashcards.feature.menu


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.flashcards.R


@Composable
fun MenuScreen(
    onAction: (MenuAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.menu_screen_title),
            modifier = Modifier
                .padding(bottom = 10.dp),
            fontSize = 34.sp,
            textAlign = TextAlign.Center
        )
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Black
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(colorResource(R.color.rectangular_color)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            MenuButton(
                onClick = {
                    onAction(MenuAction.MAIN_PAGE)
                },
                buttonText = R.string.main_page,
                contentDescription = R.string.main_page
            )
            MenuButton(
                onClick = { onAction(MenuAction.NEW_WORDS) },
                buttonText = R.string.new_words_title,
                contentDescription = R.string.new_words_title
            )
            MenuButton(
                onClick = { onAction(MenuAction.IRREGULAR_WORDS) },
                buttonText = R.string.irregular_words_text,
                contentDescription = R.string.irregular_words_text
            )
            MenuButton(
                onClick = { onAction(MenuAction.MY_WORDS) },
                buttonText = R.string.my_words_text,
                contentDescription = R.string.my_words_text
            )
            MenuButton(
                onClick = { onAction(MenuAction.ABOUT_PROGRAM) },
                buttonText = R.string.about_program_text,
                contentDescription = R.string.about_program_text
            )
        }
    }
}

@Composable
fun MenuButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    contentDescription: Int,
    buttonText: Int
) {
    Spacer(modifier = Modifier.height(30.dp))
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(200.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painterResource(R.drawable.ic_frame),
            contentDescription = stringResource(contentDescription),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.width(200.dp)
        )
        Text(
            text = stringResource(buttonText),
            fontSize = 20.sp,

            )
    }
}


@PreviewLightDark
@Composable
private fun Preview() {
    MenuScreen(
        onAction = {}
    )
}