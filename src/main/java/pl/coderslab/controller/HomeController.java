package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.entity.Category;
import pl.coderslab.service.ArticleService;
import pl.coderslab.entity.Article;
import pl.coderslab.service.CategoryService;

import java.util.List;

@Controller
public class HomeController {

    private final ArticleService articleService;
    private final CategoryService categoryService;

    public HomeController(ArticleService articleService, CategoryService categoryService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String home(){

        return "home";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return categoryService.findAll();
    }

    @ModelAttribute("last5articles")
    public List<Article> getLast5Articles(){
        return articleService.getLast5Articles();
    }
}
