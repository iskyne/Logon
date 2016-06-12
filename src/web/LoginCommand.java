package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class LoginCommand {
	private String username;
	private String password;
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
}
