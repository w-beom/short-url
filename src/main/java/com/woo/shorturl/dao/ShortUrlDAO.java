package com.woo.shorturl.dao;

import com.woo.shorturl.domain.ShortUrl;

public interface ShortUrlDAO {
    public void insert(ShortUrl shortUrl);

    public ShortUrl find(ShortUrl shortUrl);
}
