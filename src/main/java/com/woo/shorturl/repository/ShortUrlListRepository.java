package com.woo.shorturl.repository;

import com.woo.shorturl.domain.ShortUrl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShortUrlListRepository implements ShortUrlRepository {
    private List<ShortUrl> urls = new ArrayList<>();

    @Override
    public void insert(ShortUrl shortUrl) {
        urls.add(shortUrl);
    }

    @Override
    public ShortUrl findById(String id) {
        return urls.stream()
                .filter(url -> url.getShortUrl().equals(id))
                .findFirst()
                .orElse(null);
    }
}
