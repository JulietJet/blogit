package com.jahra.service.impl;

import com.jahra.model.Article;
import com.jahra.model.Blog;
import com.jahra.model.User;
import com.jahra.repository.BlogRepository;
import com.jahra.repository.UserRepository;
import com.jahra.service.BlogService;
import com.jahra.service.dto.BlogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author a.vorushenko
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BlogRepository blogRepository;

    @Override
    @Transactional
    public void saveBlog(String username, BlogDTO blogDTO) {
        Blog blog = blogRepository.findByOwnerUsername(username);
        if (blog != null) {
            blog.setName(blogDTO.getName());
            blog.setLastUpdateDate(new Date());
            blogRepository.save(blog);
        } else {
            Blog newBlog = BlogDTO.toEntity(blogDTO);
            User user = userRepository.findByUsername(username);
            newBlog.setOwner(user);
            blogRepository.save(newBlog);
        }
    }

    @Override
    public Blog getCurrentUserBlog() {
        return blogRepository.findByOwnerUsername(getUser().getUsername());
    }

    @Override
    @Transactional
    public List<Article> getCurrentUserArticles() {
        Blog blog = blogRepository.findByOwnerUsername(getUser().getUsername());
        return null == blog ? Collections.emptyList() : blog.getArticles();
    }

    private org.springframework.security.core.userdetails.User getUser() {
        return (org.springframework.security.core.userdetails.User)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


}
