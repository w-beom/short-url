package com.woo.shorturl.domain;

public class ShortUrl {
    private String url;
    private String shortUrl;
    private int catchCount;

    public ShortUrl(String url, String shortUrl) {
        this.url = url;
        this.shortUrl = shortUrl;
        this.catchCount = 0;
    }

    public void increaseCatchCount() {
        this.catchCount += 1;
    }

    public String getUrl() {
        return url;
    }

    public String getShortUrl() {
        return shortUrl;
    }
}
