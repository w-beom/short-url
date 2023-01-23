package com.woo.shorturl.dao;

import com.woo.shorturl.domain.ShortUrl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShortUrlListDAO implements ShortUrlDAO {
    private List<ShortUrl> urls = new ArrayList<>();

    @Override
    public void insert(ShortUrl shortUrl) {
        urls.add(shortUrl);
    }

    @Override
    public ShortUrl find(ShortUrl shortUrl) {
        return urls.stream()
                .filter(url -> url.getUrl().equals(shortUrl.getUrl()))
                .findFirst()
                .orElse(shortUrl);
    }
}
