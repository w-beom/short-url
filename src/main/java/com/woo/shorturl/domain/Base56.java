package com.woo.shorturl.domain;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Base56 implements KeyGenerator {
    private static final char[] BASE56 = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghjkmnpqrstuvwxyz23456789".toCharArray();

    @Override
    public String create() {
        Random random = new Random();
        StringBuilder shortenUrlKey = new StringBuilder();

        for (int count = 0; count < 8; count++) {
            int base56CharactersIndex = random.nextInt(0, BASE56.length);
            char base56Character = BASE56[base56CharactersIndex];

            shortenUrlKey.append(base56Character);
        }

        return shortenUrlKey.toString();
    }
}
