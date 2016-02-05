package com.jahra.model.test.blog;

import com.jahra.model.Blog;
import com.jahra.model.test.DBUnit;
import com.jahra.repository.BlogRepository;
import com.jahra.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Артём on 31.01.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dbunit/hibernate-test-config.xml"})
public class BlogRepositoryTest extends DBUnit {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void blogTest() {
        Blog blog = blogRepository.findOne(1L);
        Assert.assertNotNull(blog);
        Assert.assertNotNull(blog.getOwner());
    }

    @Test
    public void deleteUserTest() {
        userRepository.delete(1L);
        Assert.assertEquals(2, blogRepository.findAll().size());
    }

    @Test
    public void deleteBlogTest(){
        blogRepository.delete(3L);
        Assert.assertNotEquals(3, blogRepository.findAll().size());
        Assert.assertEquals(2, userRepository.findAll().size());
    }
}
