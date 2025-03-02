package practice.board.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.board.article.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
