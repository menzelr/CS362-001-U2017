package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableRandomTest {
	/*
	*Test delete and getApptRange
	*/
	@Test
	public void test01()  throws Throwable  {
		TimeTable table = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		LinkedList<Appt> bench = new LinkedList<Appt>();
    LinkedList<CalDay> apptsComp = new LinkedList<CalDay>();
		
		String title="TimeTable Test";
		String description="This is a test. This is only a test.";
		
		int loopRand;
		int rand;
		Appt[] arr = new Appt[25];
		Appt foo  = new Appt(ThreadLocalRandom.current().nextInt(0, 24+1), //guaranteed to not be in the array
												 ThreadLocalRandom.current().nextInt(0, 59+1) ,
												 ThreadLocalRandom.current().nextInt(1, 28+1) ,
												 ThreadLocalRandom.current().nextInt(0, 11+1) ,
												 2700 ,
												 title,
												 description);
		Appt bar = null; //null appt object
		Appt notValid = new Appt(54,
												 2 ,
												 2 ,
												 2 ,
												 2015 ,
												 title,
												 description);
		
		GregorianCalendar start;
		GregorianCalendar end;
		GregorianCalendar first;
		GregorianCalendar second;
		int startHour;
		int startMinute;
		int startDay;
		int startMonth;
		int startYear;
		boolean write = false;
		
		
		for (int j = 0; j < 1000; j++){
			appts = new LinkedList<Appt>();
			//generate loopRand
			loopRand = ThreadLocalRandom.current().nextInt(2, 25 + 1);//2-25
			//populate GregorianCalendar's based on loopRand
			if (loopRand % 2 == 0){
				start = new GregorianCalendar(2000,0,1);
				end =   new GregorianCalendar(2026,0,1);
				first = new GregorianCalendar(2000,0,1);
				second = new GregorianCalendar(2025,12,26);
			} else {
				start = new GregorianCalendar(2010,1,16);
				end =   new GregorianCalendar(2025,8,5);
				first = new GregorianCalendar(2007,7,31);
				second = new GregorianCalendar(2025,7,26);
			}
			
			rand = ThreadLocalRandom.current().nextInt(1, 10+1);//1-10
			
			if (rand == 3){//10% chance of appts being null
				appts = null;
			} else {//generate Appt objects
				
				for (int i = 0; i < loopRand; i++){
					
					startHour   = ThreadLocalRandom.current().nextInt(0, 24+1);	
					startMinute = ThreadLocalRandom.current().nextInt(0, 59+1);	
					startDay    = ThreadLocalRandom.current().nextInt(1, 28+1);
					startMonth  = ThreadLocalRandom.current().nextInt(0,  11+1); 	
					startYear   = ThreadLocalRandom.current().nextInt(2000, 2025);
					
					//fill array with the data	 
					arr[i] = new Appt(startHour,
												 startMinute ,
												 startDay ,
												 startMonth ,
												 startYear ,
												 title,
												 description);
				
				}//end internal FOR loop
				
				//copy appts from array to list
				for (int i = 0; i < loopRand; i++){
					appts.add(arr[i]);
				}//end copy FOR loop
				//populate bench
				for (int i = 1; i < loopRand; i++){
					bench.add(arr[i]);
				}//end copy FOR loop
				
				CalDay calDay1 = new CalDay(first);
				CalDay calDay2 = new CalDay(second);
				
				calDay1.addAppt(arr[0]);
				calDay2.addAppt(arr[loopRand - 1]);
				
				//add appt to comp list
				apptsComp.add(calDay1);
				apptsComp.add(calDay2);
				
				rand = ThreadLocalRandom.current().nextInt(1, 10+1);
				
				if (rand <= 3) {
					try {
						// Retrieves a range of appointments between two dates (i.e., today and tomorrow).
						table.getApptRange(appts, end, start);
					} catch( DateOutOfRangeException e) {
						//do nothing
					}//end TRY/CATCH
				} else {
					try {
						// Retrieves a range of appointments between two dates (i.e., today and tomorrow).
						table.getApptRange(appts, start, end);
					} catch( DateOutOfRangeException e) {
						//do nothing
					}//end TRY/CATCH
				}//end inner IF/ELSE
					
			}//end IF/ELSE
			
			//test delete
			if (appts == null) {
				try{
					assertEquals(null, table.deleteAppt(appts, arr[loopRand-1]));//null LL
				} catch (AssertionError e) {
					if (write){
						System.out.print("\n" + (char)27 + "[31m!!FAILURE!!" + (char)27 + "[0m line 149; expected: <null>\n");
						//dump appt to screen?
					}
				}
			} else if (rand < 3) {
				try{
					assertEquals(null, table.deleteAppt(appts, bar)); //null appt
				} catch (AssertionError e) {
					if (write){
						System.out.print("\n" + (char)27 + "[31m!!FAILURE!!" + (char)27 + "[0m line 158; expected: <null>\n");
						//dump appt to screen?
					}
				}
			} else if (rand > 2 && rand < 5) {
				try{
					assertEquals(null, table.deleteAppt(appts, notValid));  //invalid appt
				} catch (AssertionError e) {
					if (write){
						System.out.print("\n" + (char)27 + "[31m!!FAILURE!!" + (char)27 + "[0m line 167; expected: <null>\n");
						//dump appt to screen?
					}
				}
			} else if (loopRand % 2 == 0) {
				try{
					assertEquals(null, table.deleteAppt(appts, foo));    //appt not in LL
				} catch (AssertionError e) {
					if (write){
						System.out.print("\n" + (char)27 + "[31m!!FAILURE!!" + (char)27 + "[0m line 176; expected: <null>\n");
						//dump appt to screen?
					}
				}
			} else {
				try{
					assertEquals(bench, table.deleteAppt(appts, arr[0]));   //valid inputs
				} catch (AssertionError e) {
					if (write){
						System.out.print("\n" + (char)27 + "[31m!!FAILURE!!" + (char)27 + "[0m line 185; object deletion error\n");
						//dump appt to screen?
					}
				}
			}//end IF/ELSE IF/ELSE
			
		}//end test master FOR loop
	}//end method test01
}
