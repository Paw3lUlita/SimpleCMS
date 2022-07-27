package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {


        @Query(value = "SELECT * FROM Article ORDER BY created DESC ", nativeQuery = true)
        List<Article> findTop5OrderByCreatedDesc();

}
