package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;


@Repository
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Category category){
        entityManager.persist(category);
    }

    public Category findById(long id){
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAll(){
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        return query.getResultList();

    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void deleteById(long id){
        Category category = findById(id);
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }
}
