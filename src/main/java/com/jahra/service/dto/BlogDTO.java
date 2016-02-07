package com.jahra.service.dto;

import com.jahra.model.Blog;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Артём on 01.02.2016.
 */
public class BlogDTO {
    private Long id;
    @Size(min = 3, max = 21)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Blog toEntity(BlogDTO blogDTO) {
        Blog blog = new Blog();
        blog.setId(blogDTO.getId());
        blog.setName(blogDTO.getName());
        blog.setLastUpdateDate(new Date());
        return blog;
    }
}
