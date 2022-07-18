package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;

import java.awt.print.Book;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping
    public String showList(){
        return "category/categoryList";
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories(){
        return categoryDao.findAll();
    }

    @GetMapping("/add")
    public String showAddForm(Category category, Model model ){
         category = new Category();
         model.addAttribute("category", category);
        return "/category/add";
    }

    @PostMapping("/add")
    public String saveCategory(Category category){
        categoryDao.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit")
    public String showEditForm(Category category, Model model, @RequestParam long categoryId){
        category = categoryDao.findById(categoryId);
        model.addAttribute("category", category);
        return "/category/edit";
    }

    @PostMapping("/edit")
    public String updateCategory(Category category){
        categoryDao.update(category);
        return "redirect:/categories";
    }
}
