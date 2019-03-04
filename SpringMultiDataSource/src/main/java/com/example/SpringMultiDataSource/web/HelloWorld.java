package com.example.SpringMultiDataSource.web;

import com.example.SpringMultiDataSource.memberDev.model.UserDev;
import com.example.SpringMultiDataSource.memberDev.service.UserServiceDev;
import com.example.SpringMultiDataSource.memberPro.model.UserPro;
import com.example.SpringMultiDataSource.memberPro.service.UserServicePro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorld {

    @Autowired
    public UserServiceDev userServiceDev;

    @Autowired
    public UserServicePro userServicePro;

    @RequestMapping(value = "/world")
    public String world() {
        System.out.println("******************userServiceDev********************");
        List<UserDev> userDevs = userServiceDev.findAll();
        for (UserDev user : userDevs) {
            System.out.println(user);
        }
        System.out.println("******************userServicePro********************");

        List<UserPro> userPros = userServicePro.findAll();
        for (UserPro user : userPros) {
            System.out.println(user);
        }

        return "Hello World";
    }
}
