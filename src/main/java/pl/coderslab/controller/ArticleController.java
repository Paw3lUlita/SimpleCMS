package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {


    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;


    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {

        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping
    public String showList(){
        return "article/ArticleList";
    }

    @ModelAttribute("articles")
    public List<Article> getAllArticles(){
        return articleDao.findAll();
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

        articleDao.save(article);
        return "redirect:/articles";
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors(){
        return authorDao.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return categoryDao.findAll();
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestParam long articleId){
        Article article = articleDao.findById(articleId);
        model.addAttribute("article", article);
        return "/article/edit";
    }

    @PostMapping("/edit")
    public String updateAuthor(Article article) {
        articleDao.update(article);
        return "redirect:/articles";
    }
    @GetMapping("/delete")
    public String showDeleteAlert(@RequestParam long articleId, Model model){
        Article article = articleDao.findById(articleId);
        model.addAttribute(article);
        return "/article/deleteWarning";
    }

    @GetMapping("/delete/{articleId}")
    public String deleteArticle(@PathVariable long articleId){
        articleDao.deleteById(articleId);
        return "redirect:/articles";
    }
}


