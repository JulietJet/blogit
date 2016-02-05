package com.jahra.model.test.user;

import com.jahra.model.Blog;
import com.jahra.model.User;
import com.jahra.model.test.DBUnit;
import com.jahra.repository.UserRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

/**
 * Created by Артём on 29.01.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dbunit/hibernate-test-config.xml"})
public class UserRepositoryTest extends DBUnit {


    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void getUserTest() {
        User user = userRepository.findOne(1L);
        Assert.assertEquals("test1", user.getUsername());
        Assert.assertEquals(1, user.getBlogs().size());
        Assert.assertThat(user.getBlogs(), hasItem(Matchers.<Blog>hasProperty("name", is("TestBlog1"))));
    }

    @Test
    public void changeStatusTest() {
        userRepository.changeUserStatus(1L, false);
        User user = userRepository.findOne(1L);
        Assert.assertEquals(false, user.isUserEnabled());
    }

}
