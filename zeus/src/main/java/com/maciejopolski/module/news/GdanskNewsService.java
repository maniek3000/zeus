package com.maciejopolski.module.news;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GdanskNewsService implements NewsService{

    @Override
    public List<String> getLastNews() {
        return List.of(
                "News 1 for Gdansk",
                "News 2 for Gdansk",
                "News 3 for Gdansk"
        );
    }
}
