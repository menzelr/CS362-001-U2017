package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {
	/*
	*Test constructor
	*/
	@Test
	public void test01()  throws Throwable  {
		//create GregorianCalendar
    Calendar today = Calendar.getInstance();
    int thisMonth = today.get(Calendar.MONTH)+1;
		int thisYear = today.get(Calendar.YEAR);
		int thisDay = today.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar currDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
		//create CalDay object
		CalDay calDay = new CalDay(currDay);
		CalDay badDay = new CalDay();
		//assertions
		assertTrue(calDay.isValid());
		assertFalse(badDay.isValid());
		assertEquals(thisMonth, calDay.getMonth());
		assertEquals(thisYear, calDay.getYear());
		//assertEquals(0, calDay.getSizeAppts());//reveals bug
		assertEquals(thisDay, calDay.getDay());//reveals bug -- 146
	}
	@Test
	public void test02()  throws Throwable  {
		//create GregorianCalendar
    Calendar today = Calendar.getInstance();
    int thisMonth = today.get(Calendar.MONTH)+1;
		int thisYear = today.get(Calendar.YEAR);
		int thisDay = today.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar currDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
		//create CalDay object
		CalDay calDay = new CalDay(currDay);
		CalDay badDay = new CalDay();
		//assertions
		assertTrue(calDay.isValid());
		assertFalse(badDay.isValid());
		assertEquals(thisMonth, calDay.getMonth());
		assertEquals(thisYear, calDay.getYear());
		assertEquals(0, calDay.getSizeAppts());//reveals bug in array indexing
	}
	/*
	*Test addAppt
	*/
	@Test
	public void test03()  throws Throwable  {
		//create GregorianCalendar
    Calendar today = Calendar.getInstance();
    int thisMonth = today.get(Calendar.MONTH)+1;
		int thisYear = today.get(Calendar.YEAR);
		int thisDay = today.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar currDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
		//create CalDay object
		CalDay calDay = new CalDay(currDay);
		//initialize appt vars
		int startHour=13;
		int startMinute=30;
		int startDay=28;
		int startMonth=7;
		int startYear=2017;
		String title="Test Appt";
		String description="This is a test. This is only a test.";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour+1,	//valid
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		Appt appt2 = new Appt(startHour,	//valid
												 startMinute ,
												 startDay+1 ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		Appt appt3 = new Appt(startHour,	//valid
												 startMinute ,
												 startDay-1 ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		Appt appt4 = new Appt(startHour,	//valid
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		Appt apptBad = new Appt(25,	//invalid
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		LinkedList<Appt> appts = new LinkedList<Appt>();
		calDay.addAppt(appt1);//should insert -> size == 0
		calDay.addAppt(appt2);//size == 1
		calDay.addAppt(appt3);//size == 2
		calDay.addAppt(appt4);//size == 3
		calDay.addAppt(apptBad);//should not insert
		appts.add(appt3);
		appts.add(appt4);
		appts.add(appt1);
		appts.add(appt2);
		//assertions
		assertTrue(calDay.isValid());
		assertEquals(3, calDay.getSizeAppts());
		assertEquals(appts, calDay.getAppts());//reveals bug in ordering method
	}
	/*
	*Test addAppt put in correct order
	*/
	@Test
	public void test04()  throws Throwable  {
		
	}
	/*
	*Test set methods
	*
	@Test
	public void test04()  throws Throwable  {
		//create GregorianCalendar
    Calendar today = Calendar.getInstance();
    int thisMonth = today.get(Calendar.MONTH)+1;
		int thisYear = today.get(Calendar.YEAR);
		int thisDay = today.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar currDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
		//create CalDay object
		CalDay calDay = new CalDay(currDay);
		//update vars
		thisMonth += 1;
		thisYear += 1;
		thisDay += 1;
		calDay.setDay(thisDay);
		calDay.setMonth(thisMonth);
		calDay.setYear(thisYear);
		//assertions
		assertTrue(calDay.isValid());
		assertEquals(thisDay, calDay.getDay());
		assertEquals(thisMonth, calDay.getMonth());
		assertEquals(thisYear, calDay.getYear());
		assertEquals(0, calDay.getSizeAppts());
	}
	*/
	/*
	*Test Iterator
	*/
	@Test
	public void test05()  throws Throwable  {
		//create GregorianCalendar
    Calendar today = Calendar.getInstance();
    int thisMonth = today.get(Calendar.MONTH)+1;
		int thisYear = today.get(Calendar.YEAR);
		int thisDay = today.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar currDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
		//create CalDay objects
		CalDay calDay = new CalDay(currDay);
		CalDay badDay = new CalDay();
		//assertions
		assertTrue(calDay.isValid());
		assertFalse(badDay.isValid());
		assertEquals(null, badDay.iterator());
		assertEquals(0, calDay.iterator());
	}
	/*
	*Test stringBuilder
	*/
	@Test
	public void test06()  throws Throwable  {
		//create GregorianCalendar
    Calendar today = Calendar.getInstance();
    int thisMonth = today.get(Calendar.MONTH)+1;
		int thisYear = today.get(Calendar.YEAR);
		int thisDay = today.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar currDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
		//create CalDay objects
		CalDay calDay = new CalDay(currDay);
		CalDay badDay = new CalDay();
		//assertions
		assertTrue(calDay.isValid());
		assertFalse(badDay.isValid());
		assertEquals("", badDay.toString());
		assertEquals("\t --- " + thisMonth + "/" + thisDay + "/" + thisYear + " --- \n --- -------- Appointments ------------ --- \n", calDay.toString());
	}
//add more unit tests as you needed	
}//end class CalDayTest
