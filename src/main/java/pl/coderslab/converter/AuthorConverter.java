package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private final AuthorDao authorDao;

    public AuthorConverter(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author convert(String s) {
        return authorDao.findById(Long.parseLong(s));
    }
}
