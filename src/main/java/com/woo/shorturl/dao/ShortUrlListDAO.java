package com.woo.shorturl.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShortUrlListDAO implements ShortUrlDAO {
    private List<String> urls = new ArrayList<>();

    @Override
    public void insert() {

    }
}
