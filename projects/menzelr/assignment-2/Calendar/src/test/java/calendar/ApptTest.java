package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
  /*
  * Test that the gets methods work as expected. CONSTRUCTOR TEST
  */
	@Test
	public void test01()  throws Throwable  {
		int startHour=13;
		int startMinute=30;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		// assertions
		assertTrue(appt.getValid());
		assertEquals(13, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(10, appt.getStartDay());
		assertEquals(04, appt.getStartMonth());
		assertEquals(2017, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());
		//assertions for recurrence
	}
	/*
	*Testing the method isValid
	*/
	//test startHour valid
	//test startMinute valid
	//test startDay valid
	//test startMonth valid
	@Test
	public void test02()  throws Throwable  {
		int startHour=12;
		int startMinute=30;
		int startDay=15;
		int startMonth=6;
		int startYear=2017;
		String title="Start Valid Test";
		String description="This is a test. This is only a test.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		// assertions
		assertTrue(appt.getValid());
	}
	/*
	//Probably doesn't belong here -> Move to CalendarUtil tests
	//test NumDaysInMonth function -- baseline
	@Test
	public void test02()  throws Throwable  {
		int NumDaysInMonth30 = CalendarUtil.NumDaysInMonth(2017,6);
		int NumDaysInMonth31 = CalendarUtil.NumDaysInMonth(2017,7);
		// assertions
		assertEquals(30, NumDaysInMonth30);
		assertEquals(31, NumDaysInMonth31);
	}
	*/
	
	//test startHour < 0, >24
	@Test
	public void test03()  throws Throwable  {
		int startHour=-1;
		int startMinute=00;
		int startDay=01;
		int startMonth=1;
		int startYear=2017;
		String title="Start Hour Test";
		String description="This is a test. This is only a test.";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		startHour=25;
		Appt appt2 = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		// assertions
		assertFalse(appt1.getValid());
		assertFalse(appt2.getValid());
	}
	//test startHour valid
	//test startMinute < 0, > 60
	@Test
	public void test04()  throws Throwable  {
		int startHour=12;
		int startMinute=-1;
		int startDay=01;
		int startMonth=1;
		int startYear=2017;
		String title="Start Minute Test";
		String description="This is a test. This is only a test.";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		startMinute=61;
		//Construct a new Appointment object with the initial data	 
		Appt appt2 = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		// assertions
		assertFalse(appt1.getValid());
		assertFalse(appt2.getValid());
	}
	//test startHour valid
	//test startMinute valid
	//test startDay < 1, > NumDaysInMonth
	@Test
	public void test05()  throws Throwable  {
		int startHour=12;
		int startMinute=30;
		int startDay=00;
		int startMonth=1;
		int startYear=2017;
		int NumDaysInMonth=CalendarUtil.NumDaysInMonth(startYear,startMonth);
		
		String title="Start Day Test";
		String description="This is a test. This is only a test.";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		startDay=NumDaysInMonth+1;
		//Construct a new Appointment object with the initial data	 
		Appt appt2 = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		// assertions
		assertFalse(appt1.getValid());
		assertFalse(appt2.getValid());
	}
	//test startHour valid
	//test startMinute valid
	//test startDay valid
	//test startMonth < 1, > 12
	//NOTE: there is a bug in the month boundary checking, but is impossible
	//			to run that line of code with the input that would reveal it due 
	//			to IndexOutOfBounds exception thrown by function to get NumDaysInMonth
	@Test
	public void test06()  throws Throwable  {
		int startHour=12;
		int startMinute=30;
		int startDay=15;
		int startMonth=0;
		int startYear=2017;		
		String title="Start Month Test";
		String description="This is a test. This is only a test.";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		startMonth=13;
		//Construct a new Appointment object with the initial data	 
		Appt appt2 = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		// assertions
		assertFalse(appt1.getValid());
		assertFalse(appt2.getValid());
	}
	/*
	*Test set methods
	*Also ensures accuracy of get methods
	*/
	@Test
	public void test07()  throws Throwable  {
		int startHour=12;
		int startMinute=30;
		int startDay=15;
		int startMonth=6;
		int startYear=2017;	
		String title="Set Methods Test";
		String description="This is a test. This is only a test.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		//test calls 1
		appt.setStartHour(10);
		appt.setStartMinute(45);
		appt.setStartDay(11);
		appt.setStartMonth(9);
		appt.setStartYear(2001);
		appt.setTitle("Changed");
		appt.setDescription("This has been changed.");
		//assertions
		assertEquals(10, appt.getStartHour());
		assertEquals(45, appt.getStartMinute());
		assertEquals(11, appt.getStartDay());
		assertEquals(9, appt.getStartMonth());
		assertEquals(2001, appt.getStartYear());
		assertEquals("Changed", appt.getTitle());
		assertEquals("This has been changed.", appt.getDescription());
		//test calls 2   
		appt.setTitle(null);
		appt.setDescription(null);
		//assertions
		assertEquals("", appt.getTitle());
		assertEquals("", appt.getDescription());
	}
	/*
	*Test reccurrence methods
	*/
	/*
	@Test
	public void test08()  throws Throwable  {
		int startHour=12;
		int startMinute=30;
		int startDay=15;
		int startMonth=6;
		int startYear=2017;	
		String title="Set Methods Test";
		String description="This is a test. This is only a test.";
		int[] recurringDays = new int[0]; //[7]//{1,1,1}
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		appt.setRecurrence(null, 2, 6, 2);
		appt.setRecurrence(int[] recurDays, int recurBy, int recurIncrement, int recurNumber);
		//assertions
		//test recurDays[] == null
		//test setRecurrence
		//test recurDays[] != null
		
		
		//assertEquals(10, appt.getStartHour());
		
	}
	*/
	/*
	*Test string conversion methods
	*/
	//test represntationApp !!NOTE: There is a typo in the method name!!
	//There is a bug in the handling of am vs. pm assignment
	@Test
	public void test09()  throws Throwable  {
		//test am
		int startHour=6;//6 am
		int startMinute=30;
		int startDay=15;
		int startMonth=6;
		int startYear=2017;	
		String title="String Conversion Test";
		String description="This is a test for AM. This is only a test.";
		//Construct a new Appointment object with the initial data	 
		Appt apptAM = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		//test pm
		startHour=20;//8 pm
		//Construct a new Appointment object with the initial data	 
		Appt apptPM = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		//test noon
		startHour=12;//12 pm
		//Construct a new Appointment object with the initial data	 
		Appt apptNoon = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		//test midnight 
		startHour=24;//8
		//Construct a new Appointment object with the initial data	 
		Appt apptMid = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		//test zero dark thirty
		startHour=00;//00
		//Construct a new Appointment object with the initial data	 
		Appt apptZero = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		//assertions -- I have intentionally formatted these myself rather than reproducing an algorithm
		assertEquals("\t6/15/2017 at 6:30am ," + title + ", " + description + "\n", apptAM.toString());
		assertEquals("\t6/15/2017 at 8:30pm ," + title + ", " + description + "\n", apptPM.toString());
		assertEquals("\t6/15/2017 at 12:30pm ," + title + ", " + description + "\n", apptNoon.toString());
		assertEquals("\t6/15/2017 at 12:30am ," + title + ", " + description + "\n", apptMid.toString());
		assertEquals("\t6/15/2017 at 12:30am ," + title + ", " + description + "\n", apptZero.toString());
	}
	//test toString
	@Test
	public void test10()  throws Throwable  {
		//valid
		int startHour=6;//I picked 6 am on purpose as it will not throw errors with the existing bug; this error will be isolated to test 9
		int startMinute=30;
		int startDay=15;
		int startMonth=6;
		int startYear=2017;	
		String title="String Conversion Test";
		String description="This is a test for AM. This is only a test.";
		//Construct a new Appointment object with the initial data	 
		Appt apptGood = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		//invalid
		startHour=25;
		//Construct a new Appointment object with the initial data	 
		Appt apptBad = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		//assertions
		assertTrue(apptGood.getValid());
		assertEquals("\t" + startMonth + "/" + startDay + "/" + startYear + " at 6:" + startMinute + "am ," + title + ", " + description + "\n", apptGood.toString());
		assertFalse(apptBad.getValid());
		assertEquals(null, apptBad.toString());
	}
	//test recurrence functions ommitted in cobertura rpt
	@Test
	public void test11()  throws Throwable  {
		
	}
} //end class ApptTest
