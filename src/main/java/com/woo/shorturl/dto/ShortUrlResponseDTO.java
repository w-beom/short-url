package com.woo.shorturl.dto;

import com.woo.shorturl.domain.ShortUrl;

public class ShortUrlResponseDTO {

    public ShortUrlResponseDTO(ShortUrl shortUrl) {
        this.shortUrl = shortUrl;
    }

    private ShortUrl shortUrl;

    public ShortUrl getShortUrl() {
        return shortUrl;
    }

}
