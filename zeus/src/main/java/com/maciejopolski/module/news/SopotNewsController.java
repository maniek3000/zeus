package com.maciejopolski.module.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SopotNewsController {

    @Autowired
    @Qualifier("sopotNewsService")
    private NewsService newsService;

    @GetMapping("/news/sopot")
    public String getNews(Model model) {
        model.addAttribute("news", newsService.getLastNews());
        return "news";
    }

}
