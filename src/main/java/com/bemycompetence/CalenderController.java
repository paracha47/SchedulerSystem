package com.bemycompetence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.bemycompetence.dao.CalenderDao;
import com.bemycompetence.model.AcknowledgeCalender;
import com.bemycompetence.model.Calender;
import com.bemycompetence.model.SharedCalender;
import com.bemycompetence.model.User;
import com.bemycompetence.model.Week;
import com.bemycompetence.services.CalenderService;
import com.bemycompetence.services.CalenderUtils;

@Controller
public class CalenderController {

	@Autowired
	private CalenderService calenderService;
	
	@RequestMapping(value = "/getIndex", method = RequestMethod.GET)
	public ModelAndView calenderIndex(@RequestParam("day") String day,@RequestParam("time") String time,@RequestParam("status") String status, HttpServletRequest req) {
		
		HttpSession session = req.getSession(false);
		if(session !=null) {
			String userid = (String) session.getAttribute("number");
			calenderService.calenderDayTime(day, time, userid,status);;
				
		}
		
		System.out.println(" calnder controller : day "+day+" time : "+time+" user id ");		
		return new ModelAndView("index");
		
	}

	// get Detail of user current date to following schedule
	// home calender page call
	@RequestMapping("/userCalender")
	public ModelAndView getCalender(Model model,HttpServletRequest req) {
		List<Week> weekDate = new ArrayList<Week>();
		List<Calender> calList = new ArrayList<Calender>();
		List<AcknowledgeCalender> ackList = new ArrayList<AcknowledgeCalender>();
		HttpSession session = req.getSession(false);
		if(session !=null) {
			String userid = (String) session.getAttribute("number");
			String username = (String) session.getAttribute("username");
			System.out.println(" username "+username);
			weekDate = CalenderUtils.getWeekDate();
			System.out.println("week date list :"+weekDate);
			System.out.println(" user no "+userid);
			calList = calenderService.getUserCalender(userid);
//			List<User> ackUserCalList = calenderService.getSharedUserList(userid);
			System.out.println(" user  list  shar :"+calList);
			ackList = calenderService.getAckCalender(userid);
			model.addAttribute("ackList", ackList);
			model.addAttribute("weekDateList", weekDate);
			System.out.println(" Ack calender list controller"+ackList);
			
		}
		
		
		return new ModelAndView("home","calenderList",calList);
	}
	
	// is use for shared your calender to other user
	//My calender page call
	@RequestMapping("/shareYourCalender")
	public ModelAndView shareYourCalender(Model model,HttpServletRequest req) {
		List<Week> weekDate = new ArrayList<Week>();
		List<Calender> calList = new ArrayList<Calender>();
		HttpSession session = req.getSession(false);
		if(session !=null) {
			String userid = (String) session.getAttribute("number");
			weekDate = CalenderUtils.getWeekDate();
			System.out.println("week date list :"+weekDate);
			model.addAttribute("weekDateList", weekDate);
			calList = calenderService.getUserCalender(userid);
		}
		
		return new ModelAndView("MyCalender","calenderList",calList);
	}
	
	
	@RequestMapping(value = "/getSharedIndex", method = RequestMethod.GET)
	public ModelAndView sharedCalenderIndex(@RequestParam("day") int day,@RequestParam("time") int time,@RequestParam("status") String status, HttpServletRequest req) {
		
		HttpSession session = req.getSession(false);
		if(session !=null) {
			String userid = (String) session.getAttribute("number");
			List<User> sharedUserList = calenderService.getSharedUserList(String.valueOf(userid));
		
			for(User cal: sharedUserList) {
				System.out.println(" shared calender List : "+cal);
				
			}
//					String userid = "12345";
//			calenderService.calenderDayTime(day, time, Integer.parseInt(userid),status);;
		}		
		
		
		System.out.println(" calnder controller : day "+day+" time : "+time+" user id ");		
		return new ModelAndView("index");
		
	}
	
	//  share your calendar data save in db
	@RequestMapping("/share")
	public ModelAndView share(Model model,HttpServletRequest req,@RequestParam("phone_no") String senderNo) {
		
		System.out.println(" share your : "+ senderNo);
		List<Calender> calList =null;
		HttpSession session = req.getSession(false);
		if(session !=null) {
			String userid = (String) session.getAttribute("number");
			boolean isUserAvailable = calenderService.isUserAvailable(senderNo);
			System.out.println(" is user Available : "+isUserAvailable);
			calList = calenderService.getUserCalender(userid);
			if(isUserAvailable) {
				if(calList.size()>0) {
					calenderService.shareYourCalender(calList,senderNo);				
				}
				return new ModelAndView("redirect:userCalender");
			}
			
		}
			return new ModelAndView("MyCalender","message","User Not Availabe");
	}
	

	
	@RequestMapping("/sharedCalender/{shared_id}")
	public ModelAndView sharedCalender(@PathVariable("shared_id") String sharedUserId,Model model,HttpServletRequest req) {
		
		System.out.println(" shared calender");
		List<Week> weekDate = new ArrayList<Week>();
		List<User> sharedUserList = new ArrayList<User>();
		List<Calender> calenderList = new ArrayList<Calender>();
		List<AcknowledgeCalender> ackList = new ArrayList<AcknowledgeCalender>();
		HttpSession session = req.getSession(false);
		if(session !=null) {
			String userid = (String) session.getAttribute("number");
			sharedUserList = calenderService.getSharedUserList(userid);
			calenderList = calenderService.getSharedUserCalender(sharedUserId,userid);
			weekDate = CalenderUtils.getWeekDate();
			model.addAttribute("weekDateList", weekDate);
			System.out.println(" shared user  list [] : "+sharedUserList);
			System.out.println(" calender list size "+calenderList.size()+" [] : "+calenderList);

			if(!sharedUserId.equals(1) && calenderList.size() > 0) {
				
				List<Calender> calenderData = calenderService.getCalenderData(calenderList);
				ackList = calenderService.getAckCalender(sharedUserId);
				System.out.println("ack list [] "+ackList);
				model.addAttribute("ackList", ackList);
				model.addAttribute("user_id",userid);
				model.addAttribute("sh_user_id",sharedUserId);
				model.addAttribute("calenderData", calenderData);		
			}
			System.out.println(" shared user list : "+sharedUserList.size());
			
		}
		return new ModelAndView("/sharedCalenderPage","sharedUserList",sharedUserList);
	}
	
	// Param day is actualy a date  
	@RequestMapping("/send")
	public ModelAndView sendBookingAcknowledge(@RequestParam("user_id") String user_id,@RequestParam("sh_user_id") String sh_user_id,
			@RequestParam("day") String date,@RequestParam("time") String time,@RequestParam("status") String status,Model model,HttpServletRequest req) {
		
//		System.out.println(" send booking respone : u|"+user_id+" sh|"+sh_user_id+" day|"+date+" time|"+time+" status|"+status);
		calenderService.sendAcknowledgeData(user_id, sh_user_id, date, time,status);
		
		return new ModelAndView("home");
	}
}
