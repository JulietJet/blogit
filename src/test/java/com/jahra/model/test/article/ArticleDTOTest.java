package com.jahra.model.test.article;

import com.jahra.model.Article;
import com.jahra.model.Blog;
import com.jahra.service.dto.ArticleDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author a.vorushenko
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dbunit/hibernate-test-config.xml"})
public class ArticleDTOTest {

    @Test
    public void testFromEntity() {
        Article article = new Article();
        article.setTitle("Это тестовая статья");
        article.setContent("test");
        article.setId(111L);
        Blog blog = new Blog();
        blog.setId(111L);
        blog.setName("тестовый блог");
        Date date =  new Date();
        blog.setLastUpdateDate(date);
        article.setBlog(blog);
        article.setCreationDate(date);
        ArticleDTO dto = ArticleDTO.fromEntity(article);
        Assert.assertNotNull(dto);
    }
}
