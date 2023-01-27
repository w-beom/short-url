package com.woo.shorturl.service;

import com.woo.shorturl.dao.ShortUrlDAO;
import com.woo.shorturl.domain.ShortUrl;
import com.woo.shorturl.dto.ShortUrlRequestDTO;
import com.woo.shorturl.dto.ShortUrlResponseDTO;
import com.woo.shorturl.util.Base62;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class ShortUrlService {
    private final ShortUrlDAO shortUrlDAO;

    public ShortUrlService(ShortUrlDAO shortUrlDAO) {
        this.shortUrlDAO = shortUrlDAO;
    }

    public String convertUrl(ShortUrlRequestDTO shortUrlRequestDTO) {
        ShortUrl shortUrl = shortUrlRequestDTO.toShortUrl();

        ShortUrl findShortUrl = shortUrlDAO.findById(shortUrl.getId());

        if (ObjectUtils.isEmpty(findShortUrl)) {
            shortUrl.convertShortUrl();
            shortUrlDAO.insert(shortUrl);
            return shortUrl.getShortUrl();
        }

        return findShortUrl.getShortUrl();
    }

    public String getOriginalUrl(String shortUrl) {
        long id = Base62.decode(shortUrl);
        ShortUrl originalUrl = shortUrlDAO.findById(id);
        return originalUrl.getUrl();
    }
}
