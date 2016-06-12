package web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import domain.UserDom;
import service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/index")
	public String loginPage(){
		System.out.println("hello here");
		return "login";
	}
	
	@RequestMapping(value="/loginCheck")
	public String loginCheck(HttpServletRequest request,Model model){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("step1");
		boolean isValid=userService.hasMatchUser(username,password);
		if(!isValid){
			System.out.println("step2");
			model.addAttribute("error", "invalid username or password");
			return "login";
		}else{
			System.out.println("step3");
			UserDom user=userService.findUserByUserName(username);
			user.setIP(request.getRemoteAddr());
			user.setDatetime(new Date());
			userService.logSuccess(user);
			request.getSession().setAttribute("user", user);
			System.out.println("step4");
			return "main";
			
		}
	}
}
