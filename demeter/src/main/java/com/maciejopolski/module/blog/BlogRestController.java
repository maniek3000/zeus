package com.maciejopolski.module.blog;

import com.maciejopolski.module.blog.menu.MenuDto;
import com.maciejopolski.module.blog.menu.MenuService;
import com.maciejopolski.module.post.PostDto;
import com.maciejopolski.module.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private PostService postService;

    @GetMapping("/api/blog/menu")
    public List<MenuDto> getMenu(){
        return menuService.getMenu();
    }
    @GetMapping("/api/blog/post")
    public List<PostDto> getPost(){
        return postService.getPosts();
    }
}
