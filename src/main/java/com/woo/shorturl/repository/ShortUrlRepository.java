package com.woo.shorturl.repository;

import com.woo.shorturl.domain.ShortUrl;

public interface ShortUrlRepository {
    void insert(ShortUrl shortUrl);

    ShortUrl findById(String id);
}
