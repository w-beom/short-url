package com.woo.shorturl.util;

public class Base56 {
    private static final char[] BASE62 = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghjkmnpqrstuvwxyz23456789".toCharArray();

    public static String encode(long value) {
        final StringBuilder sb = new StringBuilder();
        do {
            int i = (int)(value % 56);
            sb.append(BASE62[i]);
            value /= 56;
        } while (value > 0);
        return sb.toString();
    }

    public static long decode(String value) {
        long result=0;
        long power=1;
        for (int i = 0; i < value.length(); i++) {
            int digit = new String(BASE62).indexOf(value.charAt(i));
            result += digit * power;
            power *= 56;
        }
        return result;
    }
}
