package com.woo.shorturl.repository;

import com.woo.shorturl.domain.ShortUrl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShortUrlMapRepository implements ShortUrlRepository {
    Map<String, ShortUrl> db = new ConcurrentHashMap<>();

    @Override
    public void insert(ShortUrl shortUrl) {
        db.put(shortUrl.getShortUrl(), shortUrl);
    }

    @Override
    public ShortUrl findById(String id) {
        return db.get(id);
    }
}
