package com.woo.shorturl.domain;

public class ShortUrl {
    private String url;
    private String shortUrl;

    public ShortUrl(String url) {
        validation(url);
        this.url = url;
    }

    private void validation(String url) {

    }
}
