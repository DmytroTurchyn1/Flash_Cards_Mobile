package com.example.flashcards.util;

import java.util.UUID;

public class RandomIdGenerator {
    public String getId() {
        return UUID.randomUUID().toString();
    }
}
