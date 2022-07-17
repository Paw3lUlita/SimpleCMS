package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;

import java.util.List;

@Controller
public class HomeController {

    private ArticleDao articleDao;

    public HomeController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("/")
    public String home(){

        return "home";
    }

    @ModelAttribute("last5articles")
    public List<Article> getLast5Articles(){
        return articleDao.getLast5Articles();
    }
}
