package com.woo.shorturl.presentation;

public class ShortUrlResponseDTO {

    public ShortUrlResponseDTO(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    private String shortUrl;

    public String getShortUrl() {
        return shortUrl;
    }

}
