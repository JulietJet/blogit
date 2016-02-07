package com.jahra.model.test.user;

import com.jahra.model.User;
import com.jahra.model.test.DBUnit;
import com.jahra.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

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
        Assert.assertNotNull(user.getBlog());
        Assert.assertEquals("TestBlog1", user.getBlog().getName());
    }

    @Test
    public void changeStatusTest() {
        userRepository.changeUserStatus(1L, false);
        User user = userRepository.findOne(1L);
        Assert.assertEquals(false, user.isUserEnabled());
    }

    @Test
    public void checkIsAlreadyExists() {
        boolean isExist = userRepository.isUserAlreadyExists("test1", "test@test.com");
        Assert.assertTrue(isExist);
    }

    @Test
    public void findByUserNameTest() {
        Assert.assertNotNull(userRepository.findByUsername("test2"));
    }

}
