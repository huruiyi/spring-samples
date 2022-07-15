package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.service.FooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = {"classpath:applicationContext-basic.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
public class SampleBasicTest {

    //MapperImpl
    @Autowired
    private FooService fooService;

    public void setFooService(FooService fooService) {
        this.fooService = fooService;
    }

    @Test
    public void testFooService() {
        User user = this.fooService.doSomeBusinessStuff("u1");
        assertNotNull(user);
        assertEquals("Pocoyo", user.getName());
        System.err.println("**************************************");
        System.err.println(user);
        System.err.println("**************************************");
    }
}
