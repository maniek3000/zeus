package com.maciejopolski.module.dashboard;
import com.maciejopolski.module.dashboard.dto.ArticleDto;
import com.maciejopolski.module.dashboard.dto.CommentDto;
import com.maciejopolski.module.dashboard.dto.MenuDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("menu", getMenu());
        model.addAttribute("articles", getArticle());
        return "dashboard.html";
    }
    private List<MenuDto> getMenu() {
        return List.of(
                new MenuDto("AWS", "http://michalszalkowski.com/aws/"),
                new MenuDto("Security", "http://michalszalkowski.com/security/"),
                new MenuDto("Java", "http://michalszalkowski.com/java/")
        );
    }
    private ArticleDto getArticle() {
        return new ArticleDto()
                .setTitle("Lorem ipsum dolor sit amet")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nisl tortor, blandit in vehicula et, egestas tempor massa. Vestibulum id placerat felis. In hac habitasse platea dictumst. Nam auctor nibh sit amet est molestie suscipit. Phasellus molestie elementum lobortis. Curabitur nisl justo, egestas sed massa sit amet, vestibulum fermentum est. In condimentum dui turpis, vel egestas lacus malesuada ut. Maecenas et feugiat orci. Integer consequat ante et tellus iaculis, a eleifend nisi congue. Donec at euismod odio. Phasellus sed enim ac orci convallis venenatis sed at mauris. In hac habitasse platea dictumst. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec lacinia viverra leo, at consectetur turpis ornare id. Sed elementum sem ac est lobortis scelerisque.")
                .setComments(
                        List.of(
                                new CommentDto("Michał", "test 1"),
                                new CommentDto("Ala", "test 2"),
                                new CommentDto("Marta", "test 3")
                        )
                );
    }
}