package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.CategoryRepository;

import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.List;


@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public void save(Category category){
        categoryRepository.save(category);
    }

    public Category findById(long id){
        return categoryRepository.findById(id).get();
    }

    public List<Category> findAll(){

        return categoryRepository.findAll();

    }

    public void update(Category category) {
        categoryRepository.save(category);
    }

    public void deleteById(long id){
       categoryRepository.deleteById(id);
    }
}
