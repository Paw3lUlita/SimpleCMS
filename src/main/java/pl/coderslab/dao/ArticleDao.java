package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Article article){
        entityManager.persist(article);
    }

    public Article findById(long id){
        return entityManager.find(Article.class, id);
    }

    public List<Article> findAll(){
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        return query.getResultList();

    }

    public List<Article> getLast5Articles(){
        Query query = entityManager.createQuery("SELECT a FROM Article a ORDER BY a.id DESC ");
        query.setMaxResults(5);
        return query.getResultList();
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void deleteById(long id){
        Article article = findById(id);
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }
}
