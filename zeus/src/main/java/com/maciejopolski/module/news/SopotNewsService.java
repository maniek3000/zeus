package com.maciejopolski.module.news;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SopotNewsService implements NewsService{

    @Override
    public List<String> getLastNews() {
        return List.of(
                "News 1 for Sopot",
                "News 2 for Sopot",
                "News 3 for Sopot"
        );
    }
}
