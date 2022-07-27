package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.service.AuthorService;
import pl.coderslab.entity.Author;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private final AuthorService authorService;

    public AuthorConverter(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public Author convert(String s) {
        return authorService.findById(Long.parseLong(s));
    }
}
