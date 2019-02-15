import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bemycompetence.UserController;
import com.bemycompetence.dao.UserDao;
import com.bemycompetence.model.Calender;
import com.bemycompetence.model.User;
import com.bemycompetence.model.Week;

public class Main {

	public static void main(String[] args) {
		  Logger logg = LoggerFactory.getLogger(Main.class);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
			UserDao userdao = (UserDao) context.getBean(UserDao.class);
//			User user = new User();
//			user.setPhoneNo("12345");
//			user.setPassword("12345");
//			Calender cal = new Calender();
//			cal.setCalId(40);
//			Calender cal2 = new Calender();
//			cal2.setCalId(42);
//			Calender cal3 = new Calender();
//			cal3.setCalId(51);
//			List<Calender> list = new ArrayList<Calender>();
//			list.add(cal);
//			list.add(cal2);
//			list.add(cal3);
			
//			List<Calender>  resultlist = userdao.getCalenderData2(list);
			 
			
//			System.out.println("user login "+resultlist);
			ArrayList<Week> weekDate = new ArrayList<Week>();
			for(int i = 0; i<7; i++) {
			try {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				DateFormat dayformat=new SimpleDateFormat("EEEE"); 
				Calendar c = Calendar.getInstance();
				String currentdate = String.valueOf(LocalDate.now());
				c.setTime( dateFormat.parse(currentdate));
				c.add(Calendar.DATE, i);
				String tommorow = dateFormat.format(c.getTime());
				String day = dayformat.format(c.getTime());
				Week w = new Week();
				w.setDate(tommorow);
				w.setDay(day);
				weekDate.add(w);
			  } catch (ParseException e) {
				e.printStackTrace();
			  }
			}
			
			for(Week w : weekDate) {
				System.out.println(" date "+w);

			}
			logg.info(" my logger ");
	}
}
