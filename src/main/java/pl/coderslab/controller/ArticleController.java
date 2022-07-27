package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.service.ArticleService;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.CategoryService;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {


    private final ArticleService articleService;
    private final AuthorService authorService;
    private final CategoryService categoryService;


    public ArticleController(ArticleService articleService, AuthorService authorService, CategoryService categoryService) {

        this.articleService = articleService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showList(){
        return "article/ArticleList";
    }

    @ModelAttribute("articles")
    public List<Article> getAllArticles(){
        return articleService.findAll();
    }

    @GetMapping("/add")
    public String showAddForm( Model model ){
        Article article = new Article();
        model.addAttribute("article", article);
        return "/article/add";
    }

    @PostMapping("/add")
    public String saveArticle(@Valid Article article, BindingResult result){

        if(result.hasErrors()){
            return "/article/add";
        }

        articleService.save(article);
        return "redirect:/articles";
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors(){
        return authorService.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestParam long articleId){
        Article article = articleService.findById(articleId);
        model.addAttribute("article", article);
        return "/article/edit";
    }

    @PostMapping("/edit")
    public String updateAuthor(Article article) {
        articleService.update(article);
        return "redirect:/articles";
    }
    @GetMapping("/delete")
    public String showDeleteAlert(@RequestParam long articleId, Model model){
        Article article = articleService.findById(articleId);
        model.addAttribute(article);
        return "/article/deleteWarning";
    }

    @GetMapping("/delete/{articleId}")
    public String deleteArticle(@PathVariable long articleId){
        articleService.deleteById(articleId);
        return "redirect:/articles";
    }
}


