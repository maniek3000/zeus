package com.maciejopolski.module.post;

import com.maciejopolski.module.blog.menu.MenuDto;
import com.maciejopolski.module.blog.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class PostWebController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private PostService postService;

    @GetMapping({
            "/blog/{id}",
            "/blog/{id}.html",
            "/blog/{id}.php"
    })
    public String getBlogPost(@PathVariable("id") String id,
                              Model model) {

        Optional<PostDto> post = postService.getPost(id);
        List<MenuDto> menuItems = menuService.getMenu();

        model.addAttribute("post", getPost(post.get()));
        model.addAttribute("menuItems", menuItems);

        return "blog/post.html";
    }

    private PostDto getPost(PostDto post) {
        return post.setContent(post.getContent().repeat(50));
    }

}