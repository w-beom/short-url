package com.woo.shorturl.service;

import com.woo.shorturl.domain.ShortUrl;
import com.woo.shorturl.dto.ShortUrlRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlService {
    public void convertUrl(ShortUrlRequestDTO shortUrlRequestDTO) {
        ShortUrl shortUrl = shortUrlRequestDTO.toShortUrl();
    }
}
