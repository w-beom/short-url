package com.woo.shorturl.dto;

import com.woo.shorturl.domain.ShortUrl;

public class ShortUrlRequestDTO {
    private String url;

    public ShortUrl toShortUrl() {
        return new ShortUrl(url);
    }
}
