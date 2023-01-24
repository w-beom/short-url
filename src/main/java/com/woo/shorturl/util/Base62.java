package com.woo.shorturl.util;

public class Base62 {
    private static final char[] BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    public static String encode(String value) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            int j = value.charAt(i) % 62;
            sb.append(BASE62[j]);
        }
        return sb.toString();
    }
}
