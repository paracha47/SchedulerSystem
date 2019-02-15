package com.bemycompetence;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bemycompetence.dao.UserDao;
import com.bemycompetence.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class.getName());
	
	@Autowired
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		userDao = userDao;
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
	public ModelAndView home( Model model) {
		System.out.println(" system index");
		logger.info("index page "+model);
		logger.debug("index page "+model);
		logger.error("index page ");

		return new ModelAndView("index");
		
	}
	
	@RequestMapping(value = "/signup", method= RequestMethod.GET)
	public ModelAndView signupPage(Model model) {
		logger.info("signup page ");
		
		return new ModelAndView("signup");

	}
	
	@RequestMapping(value = "/createUser", method= RequestMethod.POST)
	public ModelAndView CreateUser(Model model,HttpServletRequest req) {
		
		String name = req.getParameter("name");
		System.out.println("phone no: "+req.getParameter("phone_no"));
		logger.info("signup link ");
		User user = new User();
		user.setName(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setPhoneNo(req.getParameter("phone_no"));
		user.setPassword(req.getParameter("password"));
		String password = req.getParameter("password");
		String rePassword = req.getParameter("re_password");
		if (password.equals(rePassword)) {
			boolean userAvailable = userDao.createAccount(user);
			if(!userAvailable) {
				return new ModelAndView("signup","message","User Successfully Created");
			}
			else {
				return new ModelAndView("signup","message","User Already Available");	
			}
		}
		else {
			return new ModelAndView("redirect:signup","message","Password Not Match");
			
			
		}
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView userLogin(Model model,HttpServletRequest req) {
		
		String userNumber  = req.getParameter("your_number");
		String password =  req.getParameter("your_password");
		System.out.println(" no and password : "+ userNumber+" pass "+password);
		User user = new User();
		user.setPhoneNo(userNumber);
		user.setPassword(password);
		boolean isValidate = userDao.userLogin(user);
		if(!isValidate) {
			
			return new ModelAndView("index","message","Username and Password Not Match");
		}
		else {
			User userdata = userDao.getUser(userNumber);
			HttpSession session = req.getSession();
			session.setAttribute("number", userNumber);
			session.setAttribute("username", userdata.getName());
			System.out.println("else part ");
			return new ModelAndView("redirect:userCalender");
				
		}
	
	}

	@RequestMapping(value = "/logout", method= RequestMethod.GET)
	public ModelAndView logout(Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		session.invalidate();
		return new ModelAndView("redirect:index");

	}
	
}
