package com.woo.shorturl.dao;

import com.woo.shorturl.domain.ShortUrl;

import java.util.Optional;

public interface ShortUrlDAO {
    public void insert(ShortUrl shortUrl);

    public ShortUrl findById(long id);
}
