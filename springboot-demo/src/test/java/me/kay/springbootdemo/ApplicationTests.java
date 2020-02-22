package me.kay.springbootdemo;

import me.kay.entities.Person;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import org.junit.jupiter.api.Test;

//@SpringBootTest
//class ApplicationTests {
//
//    @Autowired
//    Person person;
//
//    @Test
//    void contextLoads() {
//        System.out.println(person.toString());
//    }
//}

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    Person person;

    @Test
    public void contextLoads() {
        System.out.println(person.toString());
    }

}