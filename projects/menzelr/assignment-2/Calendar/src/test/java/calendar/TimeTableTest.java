package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	/*
	*  The goal of the test01 is to call the public method getApptRange with the exact objects too cover the following targets:
	*  Switch Statement in the private method getNextApptOccurrence
	*  in particular case Appt.RECUR_BY_MONTHLY
	*/
	@Test
	public void test01()  throws Throwable  {
		TimeTable table = new TimeTable();
		//create linked list of Appt type
    //create Appt objects
    //add the object to the linked list
    //create first day and last day of type GregorianCalendar today = new GregorianCalendar(2, 3, 4);
		//get todays date
	  Calendar today = Calendar.getInstance();
	  //current month/year/date is today
	  int thisMonth = today.get(Calendar.MONTH)+1;
		int thisYear = today.get(Calendar.YEAR);
		int thisDay = today.get(Calendar.DAY_OF_MONTH);
			
		int startHour=15;
		int startMinute=30;
		int startDay=thisDay;  	//11
		int startMonth=thisMonth; 	//4
		int startYear=thisYear; 	//2017
    String title="Birthday Party";
    String description="This is my birthday party.";
    // Create a valid appointment!
    Appt appt = new Appt(startHour, 
												 startMinute, 
												 startDay, 
												 startMonth, 
												 startYear, 
												 title, 
												 description);
		LinkedList<Appt> appts = new LinkedList<Appt>();
    appts.add(appt);
		//establish recurrence
    int[] recurringDays =  new int[0];
		appt.setRecurrence(recurringDays, Appt.RECUR_BY_MONTHLY, 0, 1);
		//setup timetable
		//get a list of appointments for one day that are occurred between today and tomorrow!
    GregorianCalendar firstDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
    //Copy firstDay as lastDay
		GregorianCalendar lastDay = (GregorianCalendar)firstDay.clone();
		//Increment lastDay
		lastDay.add(Calendar.DAY_OF_MONTH,1);
		//
		try {
    	// Retrieves a range of appointments between two dates (i.e., today and tomorrow).
      table.getApptRange(appts, firstDay, lastDay);
    } catch( NullPointerException e) {
			//do nothing
    }
	}//end test01
	/*
	*Test delete
	*/
	@Test
	public void test02()  throws Throwable  {
		TimeTable table = new TimeTable();
		//create linked list of Appt type
    //create Appt objects
    //add the object to the linked list
    //create first day and last day of type GregorianCalendar today = new GregorianCalendar(2, 3, 4);
		//get todays date
	  Calendar today = Calendar.getInstance();
	  //current month/year/date is today
	  int thisMonth = today.get(Calendar.MONTH)+1;
		int thisYear = today.get(Calendar.YEAR);
		int thisDay = today.get(Calendar.DAY_OF_MONTH);
			
		int startHour=15;
		int startMinute=30;
		int startDay=thisDay;  	//11
		int startMonth=thisMonth; 	//4
		int startYear=thisYear; 	//2017
    String title="Birthday Party";
    String description="This is my birthday party.";
    // Create a valid appointment!
    Appt appt1 = new Appt(startHour, //valid
												 startMinute, 
												 startDay, 
												 startMonth, 
												 startYear, 
												 title, 
												 description);
		startDay -= 1;
		Appt appt2 = new Appt(startHour, //valid -1
												 startMinute, 
												 startDay, 
												 startMonth, 
												 startYear, 
												 title, 
												 description);
		startMonth += 1;
		Appt appt3 = new Appt(startHour, //valid, diff month, not in LL
												 startMinute, 
												 startDay, 
												 startMonth, 
												 startYear, 
												 title, 
												 description);
		startDay = 35;
		Appt apptBad = new Appt(startHour, //invalid
												 startMinute, 
												 startDay, 
												 startMonth, 
												 startYear, 
												 title, 
												 description);
		Appt apptNull = null;								//null
		LinkedList<Appt> appts = new LinkedList<Appt>();
		LinkedList<Appt> bench = new LinkedList<Appt>();
		LinkedList<Appt> apptsNull = null;
    appts.add(appt1);
		appts.add(appt2);
		appts.add(apptBad);
		bench.add(appt1);
		bench.add(apptBad);
		//assertions
		assertTrue(appt1.getValid());
		assertTrue(appt2.getValid());
		assertTrue(appt3.getValid());
		assertFalse(apptBad.getValid());
		assertEquals(null, table.deleteAppt(apptsNull, appt1));//null LL
		assertEquals(null, table.deleteAppt(appts, apptNull)); //null appt
		assertEquals(null, table.deleteAppt(appts, apptBad));  //invalid appt
		assertEquals(null, table.deleteAppt(appts, appt3));    //appt not in LL
		assertEquals(bench, table.deleteAppt(appts, appt2));   //valid inputs
	}
	/*
	*test permute
	*NOTE: reveals bug in reordering scheme
	*/
	@Test
	public void test03()  throws Throwable  {
		TimeTable table = new TimeTable();

		int startHour=6;
		int startMinute=30;
		int startDay=15; //wk = 22
		int startMonth=6; //mon = 7
		int startYear=2017;	
		String title="Permutation Test";
		String description="This is a test for AM. This is only a test.";
		//construct appts
		Appt appt1 = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description); 
		Appt appt2 = new Appt(startHour,
												 startMinute ,
												 startDay+1 ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		Appt appt3 = new Appt(startHour,
												 startMinute ,
												 startDay+2 ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		Appt appt4 = new Appt(startHour,
												 startMinute ,
												 startDay+3 ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		Appt appt5 = new Appt(startHour,
												 startMinute ,
												 startDay+4 ,
												 startMonth ,
												 startYear ,
												 title,
												 description);										 
		LinkedList<Appt> appts = new LinkedList<Appt>();
		LinkedList<Appt> apptsFinal = new LinkedList<Appt>();
		int[] pv = {4, 3, 2, 1, 0};
		appts.add(appt1);//0
		appts.add(appt2);//1
		appts.add(appt3);//2
		appts.add(appt4);//3
		appts.add(appt5);//4
		//permuted
		apptsFinal.add(appt5);
		apptsFinal.add(appt4);
		apptsFinal.add(appt3);
		apptsFinal.add(appt2);
		apptsFinal.add(appt1);
		//assertions
		assertEquals(apptsFinal, table.permute(appts, pv));
	}
	/*
	*test getApptOccurrences, getNextApptOccurrence
	*/
	@Test
	public void test04()  throws Throwable  {
		TimeTable table = new TimeTable();
		//int thisMonth = today.get(Calendar.MONTH)+1;
		//int thisYear = today.get(Calendar.YEAR);
		//int thisDay = today.get(Calendar.DAY_OF_MONTH);
		//GregorianCalendar currDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
		
		int startHour=6;
		int startMinute=30;
		int startDay=15; //wk = 22
		int startMonth=6; //mon = 7
		int startYear=2017;	
		String title="Private Class Test";
		String description="This is a test for AM. This is only a test.";
		GregorianCalendar currDay = new GregorianCalendar(startYear,startMonth,startDay);
		GregorianCalendar nextWk = new GregorianCalendar(startYear,startMonth,startDay+7);
		GregorianCalendar nextMon = new GregorianCalendar(startYear,startMonth+1,startDay);
		GregorianCalendar nextYr = new GregorianCalendar(startYear+1,startMonth,startDay);
		LinkedList<Appt> appts = new LinkedList<Appt>();
		//Construct a new Appointment object with the initial data	 
		Appt apptNoRecur = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description); 
		Appt apptRecurWeek = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		Appt apptRecurMonth = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		Appt apptRecurYear = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		Appt apptOutOfBounds = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear+2 ,
												 title,
												 description);
		Appt apptBadRecur = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		Appt apptBad = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
		int[] recurringDaysEmpty =  new int[0];
		int[] recurringDays =  {1,1,1};
		apptRecurWeek.setRecurrence(recurringDaysEmpty, Appt.RECUR_BY_WEEKLY, 2, 5);
		apptRecurMonth.setRecurrence(recurringDays, Appt.RECUR_BY_MONTHLY, 2, 5);
		apptRecurYear.setRecurrence(recurringDays, Appt.RECUR_BY_YEARLY, 2, 5);
		apptOutOfBounds.setRecurrence(recurringDays, Appt.RECUR_BY_YEARLY, 2, 5);
		apptBadRecur.setRecurrence(recurringDays, 37, 2, 5);
    //appts.add(apptNoRecur);
		appts.add(apptRecurWeek);
		appts.add(apptRecurMonth);
		appts.add(apptRecurYear);
		appts.add(apptBadRecur);
		appts.add(apptOutOfBounds);
		appts.add(apptBad);
		//assertions
		assertTrue(apptRecurWeek.isRecurring());
		assertTrue(apptRecurMonth.isRecurring());
		assertTrue(apptRecurYear.isRecurring());
		assertFalse(apptNoRecur.isRecurring());
		assertEquals(Appt.RECUR_BY_WEEKLY, apptRecurWeek.getRecurBy());
		assertEquals(Appt.RECUR_BY_MONTHLY, apptRecurMonth.getRecurBy());
		assertEquals(Appt.RECUR_BY_YEARLY, apptRecurYear.getRecurBy());
		//assertEquals(null, table.getNextApptOccurrence(apptNoRecur, currDay));
		//assertEquals(nextWk, table.getNextApptOccurrence(apptRecurWeek, currDay));
		//assertEquals(nextMon, table.getNextApptOccurrence(apptRecurMonth, currDay));
		//assertEquals(nextYr, table.getNextApptOccurrence(apptRecurYear, currDay));
		//assertEquals("", table.getApptOccurences(apptRecurYear, nextWk, currDay));
		//assertEquals("", table.getApptOccurences(apptRecurYear, currDay, nextWk));
		try {
    	// Retrieves a range of appointments between two dates (i.e., today and tomorrow).
      table.getApptRange(appts, currDay, nextWk);
    } catch(NullPointerException e) {
			//do nothing
    }
		try {
    	// Retrieves a range of appointments between two dates (i.e., today and tomorrow).
      table.getApptRange(appts, nextWk, currDay);
    } catch(NullPointerException e) {
			//do nothing
    }
	}
//add more unit tests as you needed
}
