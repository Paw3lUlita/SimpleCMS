package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.service.CategoryService;
import pl.coderslab.entity.Category;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

     private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showList(){
        return "category/categoryList";
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/add")
    public String showAddForm( Model model ){
         Category category = new Category();
         model.addAttribute("category", category);
        return "/category/add";
    }

    @PostMapping("/add")
    public String saveCategory(@Valid Category category, BindingResult result){

        if(result.hasErrors()){
            return "/category/add";
        }
        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestParam long categoryId){
        Category category = categoryService.findById(categoryId);
        model.addAttribute("category", category);
        return "/category/edit";
    }

    @PostMapping("/edit")
    public String updateCategory(Category category){
        categoryService.update(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete")
    public String showDeleteAlert(@RequestParam long categoryId, Model model){
        Category category = categoryService.findById(categoryId);
        model.addAttribute(category);
        return "/category/deleteWarning";
    }

    @GetMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable long categoryId){
        categoryService.deleteById(categoryId);
        return "redirect:/categories";
    }
}
