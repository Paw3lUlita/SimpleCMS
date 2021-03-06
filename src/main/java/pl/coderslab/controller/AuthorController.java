package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.service.AuthorService;
import pl.coderslab.entity.Author;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String showList(){
        return "author/authorList";
    }

    @ModelAttribute("authors")
    public List<Author> getAllAuthors(){
        return authorService.findAll();
    }

    @GetMapping("/add")
    public String showAddForm( Model model ){
        Author author = new Author();
        model.addAttribute("author", author);
        return "/author/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAuthor(@Valid Author author, BindingResult result){

        if(result.hasErrors()){
            return "/author/add";
        }
        authorService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestParam long authorId){
        Author author = authorService.findById(authorId);
        model.addAttribute("author", author);
        return "/author/edit";
    }

    @PostMapping("/edit")
    public String updateAuthor(Author author) {
        authorService.update(author);
        return "redirect:/authors";
    }
        @GetMapping("/delete")
        public String showDeleteAlert(@RequestParam long authorId, Model model){
            Author author = authorService.findById(authorId);
            model.addAttribute(author);
            return "/author/deleteWarning";
        }

        @GetMapping("/delete/{authorId}")
        public String deleteAuthor(@PathVariable long authorId){
            authorService.deleteById(authorId);
            return "redirect:/authors";
        }


}
