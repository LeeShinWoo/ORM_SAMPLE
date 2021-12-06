package com.lsw.menagement.repository;

import com.lsw.menagement.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

@SpringBootTest //모든 빈을 IoC컨테이너에 기동
@TestPropertySource(locations="classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("User saved Test")
    @Order(1)
    public void createUserTest(){
        User user = new User();
        user.setUserNm("우사랑");
        user.setEmpNo("1054024");

        userRepository.save(user);

        user = new User();
        user.setUserNm("현최강");
        user.setEmpNo("1394064");

        userRepository.save(user);

        user = new User();
        user.setUserNm("김진은");
        user.setEmpNo("1790064");

        userRepository.save(user);
    }

    @Test
    @DisplayName("User name search Test")
    @Order(2)
    public void findByUserNmTest(){
        long id1 = 1l;
        Optional<User> userA = userRepository.findById(id1);
        userA.ifPresent(System.out::println);

        List<User> userList = userRepository.findByUserNm("현최강");
        for(User user : userList){
            System.out.println(user.toString());
        }
    }

    @Test
    @DisplayName("User All search Test")
    @Order(3)
    public void findAllByUser(){
        List<User> userList = userRepository.findAll();
        for(User user : userList){
            System.out.println(user.toString());
        }
    }
}
