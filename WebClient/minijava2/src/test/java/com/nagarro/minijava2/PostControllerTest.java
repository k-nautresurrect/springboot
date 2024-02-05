package com.nagarro.minijava2;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.nagarro.minijava2.controller.UserController;
import com.nagarro.minijava2.services.UserService;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
@SpringBootTest
public class PostControllerTest {
 
	@Mock
	private UserService userService;
 
	@InjectMocks
	private UserController userController;
 
	@Test
	public void testAddUserWithValidSize() throws Exception {
		int validSize = 2;
		
		Mockito.doNothing().when(userService).postUsers(validSize);

		userController.addUser(validSize);
 
		verify(userService).postUsers(validSize);
	}
 
	
}
