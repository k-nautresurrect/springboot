package com.nagarro.minijava2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.nagarro.minijava2.Entity.User;
import com.nagarro.minijava2.Repository.UserRepository;
import com.nagarro.minijava2.services.RandomUserService;



@SpringBootTest
//@RunWith(SpringRunner.class)
class Minijava2ApplicationTests {

	@MockBean
    private UserRepository userRepository;

    @Autowired
    private RandomUserService userService;

    @Test
    void testGetUser() {
       
        String field = "firstName";
        List<User> expectedUsers = Arrays.asList(
                new User(1, "Male", 25, "John", "Doe", "USA", "Verified"),
                new User(2, "Female", 30, "Jane", "Doe", "Canada", "Not Verified")
        );

        when(userRepository.findAll(Sort.by(Sort.Direction.ASC, field))).thenReturn(expectedUsers);

      
        List<User> actualUsers = userService.getUser(field);

        
        assertEquals(expectedUsers, actualUsers);
    }
  @Test
  void testGetUserWithPagination() {
     
      int offset = 0;
      int pageSize = 2;
      List<User> expectedUsers = Arrays.asList(
              new User(1, "Male", 25, "John", "Doe", "USA", "Verified"),
              new User(2, "Female", 30, "Jane", "Doe", "Canada", "Not Verified")
      );

      Page<User> expectedPage = new PageImpl<>(expectedUsers);

      when(userRepository.findAll(PageRequest.of(offset, pageSize))).thenReturn(expectedPage);

      
      Page<User> actualPage = userService.getUserWithPagination(offset, pageSize);

    
      assertEquals(expectedPage, actualPage);
  }


}
