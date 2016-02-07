package com.jahra.service.impl;

import com.jahra.model.Blog;
import com.jahra.model.User;
import com.jahra.repository.BlogRepository;
import com.jahra.repository.UserRepository;
import com.jahra.service.BlogService;
import com.jahra.service.dto.BlogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

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
}
