package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.service.CategoryService;
import pl.coderslab.entity.Category;



public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    private CategoryService categoryService;



    @Override
    public Category convert(String source) {
        return categoryService.findById(Integer.parseInt(source));
    }
}