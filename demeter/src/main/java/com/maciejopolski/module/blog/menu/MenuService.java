package com.maciejopolski.module.blog.menu;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    public List<MenuDto> getMenu() {
        return List.of(
                new MenuDto("World"),
                new MenuDto("Technology"),
                new MenuDto("Design"),
                new MenuDto("Culture"),
                new MenuDto("Business"),
                new MenuDto("Politics"),
                new MenuDto("Opinion"),
                new MenuDto("Science"),
                new MenuDto("Health"),
                new MenuDto("Style"),
                new MenuDto("Travel")
        );
    }

    public List<MenuDto> getSubMenu() {
        return List.of(
                new MenuDto("Sub 1"),
                new MenuDto("Sub 2"),
                new MenuDto("Sub 3"),
                new MenuDto("Sub 4"),
                new MenuDto("Sub 5"),
                new MenuDto("Sub 6"),
                new MenuDto("Sub 7")
        );
    }

}