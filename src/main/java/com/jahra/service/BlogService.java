package com.jahra.service;

import com.jahra.service.dto.BlogDTO;

/**
 * @author a.vorushenko
 */
public interface BlogService {
    void saveBlog(String username, BlogDTO blogDTO);
}
