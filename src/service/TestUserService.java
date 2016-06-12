package service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class TestUserService {
	
	@Autowired
	UserService userService;
	@Test
	public void hasMatchUser(){
		boolean b1=userService.hasMatchUser("admin", "123456");
		boolean b2=userService.hasMatchUser("admin", "1111");
		
		assertTrue(b1);
		assertTrue(b2);
	}
	
	@Test
	public void findUserByUsername(){
		assertEquals(userService.findUserByUserName("admin").getPassword(),"123456");
		//assertEquals(userService.findUserByUserName("admin").getPassword(),"1234");
	}
}
