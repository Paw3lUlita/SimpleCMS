package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.service.ArticleService;
import pl.coderslab.entity.Article;

import java.util.List;

@Controller
public class HomeController {

    private ArticleService articleService;

    public HomeController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String home(){

        return "home";
    }

    @ModelAttribute("last5articles")
    public List<Article> getLast5Articles(){
        return articleService.getLast5Articles();
    }
}
