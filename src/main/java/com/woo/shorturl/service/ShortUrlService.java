package com.woo.shorturl.service;

import com.woo.shorturl.dao.ShortUrlDAO;
import com.woo.shorturl.domain.ShortUrl;
import com.woo.shorturl.dto.ShortUrlRequestDTO;
import com.woo.shorturl.dto.ShortUrlResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlService {
    private final ShortUrlDAO shortUrlDAO;

    public ShortUrlService(ShortUrlDAO shortUrlDAO) {
        this.shortUrlDAO = shortUrlDAO;
    }

    public ShortUrlResponseDTO convertUrl(ShortUrlRequestDTO shortUrlRequestDTO) {
        ShortUrl shortUrl = shortUrlRequestDTO.toShortUrl();

        ShortUrl findShortUrl = shortUrlDAO.find(shortUrl);

        if (findShortUrl.existShortUrl()) {
            return new ShortUrlResponseDTO(findShortUrl);
        }

        shortUrl.convertShortUrl();
        return new ShortUrlResponseDTO(shortUrl);
    }
}
