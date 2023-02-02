package com.woo.shorturl.service;

import com.woo.shorturl.repository.ShortUrlRepository;
import com.woo.shorturl.domain.KeyGenerator;
import com.woo.shorturl.domain.ShortUrl;
import com.woo.shorturl.presentation.ShortUrlRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlService {
    private final KeyGenerator keyGenerator;
    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlService(KeyGenerator keyGenerator, ShortUrlRepository shortUrlRepository) {
        this.keyGenerator = keyGenerator;
        this.shortUrlRepository = shortUrlRepository;
    }

    public String convertUrl(ShortUrlRequestDTO shortUrlRequestDTO) {
        String url = shortUrlRequestDTO.getUrl();
        String shortUrl = createUniqueKey();

        ShortUrl shortenUrl = new ShortUrl(url, shortUrl);
        shortUrlRepository.insert(shortenUrl);
        shortenUrl.increaseCatchCount();

        return shortenUrl.getShortUrl();
    }

    private String createUniqueKey() {
        final int MAX_RETRY_COUNT = 5;
        int count = 0;

        while (count++ < MAX_RETRY_COUNT) {
            String shortenUrlKey = keyGenerator.create();
            ShortUrl shortenUrl = shortUrlRepository.findById(shortenUrlKey);

            if (null == shortenUrl) {
                return shortenUrlKey;
            }
        }
        return "";
    }

    public String findOriginalUrl(String shortUrl) {
        ShortUrl findShortenUrl = shortUrlRepository.findById(shortUrl);
        return findShortenUrl.getUrl();
    }
}
