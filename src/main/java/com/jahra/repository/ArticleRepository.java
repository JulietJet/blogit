package com.jahra.repository;

import com.jahra.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Артём on 31.01.2016.
 */

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
