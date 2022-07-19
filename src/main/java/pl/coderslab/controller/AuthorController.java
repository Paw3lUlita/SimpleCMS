package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping
    public String showList(){
        return "author/authorList";
    }

    @ModelAttribute("authors")
    public List<Author> getAllAuthors(){
        return authorDao.findAll();
    }

    @GetMapping("/add")
    public String showAddForm( Model model ){
        Author author = new Author();
        model.addAttribute("author", author);
        return "/author/add";
    }

    @PostMapping("/add")
    public String saveAuthor(Author author){
        authorDao.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestParam long authorId){
        Author author = authorDao.findById(authorId);
        model.addAttribute("author", author);
        return "/author/edit";
    }

    @PostMapping("/edit")
    public String updateAuthor(Author author) {
        authorDao.update(author);
        return "redirect:/authors";
    }
        @GetMapping("/delete")
        public String showDeleteAlert(@RequestParam long authorId, Model model){
            Author author = authorDao.findById(authorId);
            model.addAttribute(author);
            return "/author/deleteWarning";
        }

        @GetMapping("/delete/{authorId}")
        public String deleteAuthor(@PathVariable long authorId){
            authorDao.deleteById(authorId);
            return "redirect:/authors";
        }


}
