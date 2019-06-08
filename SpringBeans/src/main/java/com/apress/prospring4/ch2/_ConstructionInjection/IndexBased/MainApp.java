package com.apress.prospring4.ch2._ConstructionInjection.IndexBased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("InjectionForIndexBased.xml");

        EmployeeService employeeService = (EmployeeService) context.getBean("employeeServiceBean");
        System.out.println(employeeService);
    }

}
