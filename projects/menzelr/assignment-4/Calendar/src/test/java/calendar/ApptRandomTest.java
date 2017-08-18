package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;



public class ApptRandomTest {
	private final static int MAX_CYCLE=100000;
	//arrary of possible chars
	private static final char[] BASE_CHARACTERS = {
		' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '=', '/', '_', 
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	};
	//compile strings for title and description
	public static String stringGen(){
		int rand = (int)(Math.random() * 12 - 1);//-1    - 10;
		int len;
		String str = "";
		
		if (rand == -1){
			return "";
		} else if (rand == 0){
			return null;
		} else if (rand > 0 && rand < 7){
			len = 10;
		} else if (rand >= 7 && rand <= 9){
			len = 50;
		} else {
			len = 100;
		}
		for (int i = 0; i < len; i++){
			rand = ThreadLocalRandom.current().nextInt(0, 78);//(int)(Math.random() * 78);//0-77
			str += BASE_CHARACTERS[rand];
		}
		return str;
	}//end stringGen)()
	
	//get the number of days in a given month
	public static int getDays(int year, int month){
		
		boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));

		switch (month){
			case 0://jan
				return 31;
			case 1://feb
				if (isLeapYear) {
            return 29;
        } else {
            return 28;
				}
			case 2://mar
				return 31;
			case 3://apr
				return 30;
			case 4://may
				return 31;
			case 5://jun
				return 30;
			case 6://jul
				return 31;
			case 7://aug
				return 31;
			case 8://sep
				return 30;
			case 9://oct
				return 31;
			case 10://nov
				return 30;
			case 11://dec
				return 31;
			default: //works with program constraints
				return 31;
		}//end switch	
	}//end getDays()
	
	//test for methods isValid() and setDescription()
	@Test
	public void test01()  throws Throwable  {
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
		boolean write = false;
		
		for (int i = 0; i < MAX_CYCLE; i++){
			startHour   = ThreadLocalRandom.current().nextInt(-25, 50 + 1);//(int)(Math.random() * 100 - 49);//-49 - 50
			startMinute = ThreadLocalRandom.current().nextInt(-50, 200 + 1);//(int)(Math.random() * 400 - 99);//-99 - 300
			startDay    = ThreadLocalRandom.current().nextInt(-25, 50 + 1);//(int)(Math.random() * 100 - 49);//-49 - 50
			startMonth  = ThreadLocalRandom.current().nextInt(-5, 15 + 1);//(int)(Math.random() * 16 - 3);  //-3  - 12
			startYear   = 2017;//this is not randomized because it is not checked -- (int)(Math.random() * 3000 - 499);//-499 - 2500
			title 			= stringGen();
			description = stringGen();
			numDaysInMonth=getDays(startYear,startMonth);
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
				try {
					assertFalse(appt.getValid());
				} catch(AssertionError e) {
					if (write){
						System.out.print("\n" + (char)27 + "[31m!!FAILURE!!" + (char)27 + "[0m line 124; expected: <false> but was: <true>\n");
						//dump appt to screen?
					}
				}
			}else{
				try {
					assertTrue(appt.getValid());
				} catch(AssertionError e) {
					if (write){
						System.out.print("\n" + (char)27 + "[31m!!FAILURE!!" + (char)27 + "[0m line 133; expected: <true> but was: <false>\n");
						//dump appt to screen?
					}
				}
			}// end if/else
		}//end for
	}//end test01
} //end class ApptTest
