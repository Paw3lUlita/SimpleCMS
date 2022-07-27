package pl.coderslab.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Article;
import pl.coderslab.repository.ArticleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArticleService {


    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void save(Article article){
        articleRepository.save(article);
    }

    public Article findById(long id){

        return articleRepository.findById(id).get();
    }

    public List<Article> findAll(){
        return articleRepository.findAll();

    }

    public List<Article> getLast5Articles(){

        return articleRepository.findTop5OrderByCreatedDesc();
    }

    public void update(Article article) {

        articleRepository.save(article);
    }

    public void deleteById(long id){
       articleRepository.deleteById(id);
    }
}
