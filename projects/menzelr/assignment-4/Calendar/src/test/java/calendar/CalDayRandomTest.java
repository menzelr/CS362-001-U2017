package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayRandomTest {
	private final static int MAX_CYCLE=10000;
	
	//test method addAppt()
	@Test
	public void test01()  throws Throwable  {
		//create GregorianCalendar
    Calendar today = Calendar.getInstance();
		int randMonth = ThreadLocalRandom.current().nextInt(0, 11 + 1);
		int randYear = today.get(Calendar.YEAR);
		int randDay = ThreadLocalRandom.current().nextInt(1, ApptRandomTest.getDays(randYear, randMonth) + 1);
		GregorianCalendar randCal = new GregorianCalendar(randYear, randMonth, randDay);
		
		//other declarations
		LinkedList<Appt> appts = new LinkedList<Appt>();
		int startHour;
		int startMinute;
		int startDay;
		int startMonth;
		int startYear;
		String title = "";
		String description = "";
		int numDaysInMonth;
		int rand;
		Appt appt;
		int size = 0;
		int comp = 0;
		boolean write = false;
		
		//create CalDay object
		CalDay calDay = new CalDay(randCal);
		
		//generate and add appts
		for (int i = 0; i < MAX_CYCLE; i++){
			startHour   = ThreadLocalRandom.current().nextInt(-25, 50 + 1);//(int)(Math.random() * 100 - 49);//-49 - 50
			startMinute = ThreadLocalRandom.current().nextInt(-50, 200 + 1);//(int)(Math.random() * 400 - 99);//-99 - 300
			startDay    = ThreadLocalRandom.current().nextInt(-25, 50 + 1);//(int)(Math.random() * 100 - 49);//-49 - 50
			startMonth  = ThreadLocalRandom.current().nextInt(-5, 15 + 1);//(int)(Math.random() * 16 - 3);  //-3  - 12
			startYear   = randYear;//this is not randomized because it is not checked -- (int)(Math.random() * 3000 - 499);//-499 - 2500
			title 			= ApptRandomTest.stringGen();
			description = ApptRandomTest.stringGen();
			numDaysInMonth=ApptRandomTest.getDays(startYear,startMonth);
			//Construct a new Appointment object with the data	 
			appt = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
												 
			if (startHour > 24 || startHour < 0 || 
				  startMinute > 59 || startMinute < 0 || 
					startDay > numDaysInMonth || startDay < 1 ||
					startMonth > 11 || startMonth < 0){
				//appt invalid
				calDay.addAppt(appt);
			}else{
				//appt valid
				calDay.addAppt(appt);
				size++;
				appts.add(appt);
			}// end if/else
		}//end for
		//assertions
		try{
			assertTrue(calDay.isValid());
		} catch (AssertionError e) {
			if (write){
				System.out.print("\n" + (char)27 + "[31m!!FAILURE!!" + (char)27 + "[0m line 86; expected: <true> but was: <false>\n");
				//dump appt to screen?
			}
		}
		try{
			comp = calDay.getSizeAppts();
			assertEquals(size, comp);
		} catch (AssertionError e) {
			if (write){
				System.out.print("\n" + (char)27 + "[31m!!FAILURE!!" + (char)27 + "[0m line 95; expected: <" + size + "> but was: <" + comp + ">\n");
				//dump appt to screen?
			}
		}
	}//end test01
}//end class CalDayTest
