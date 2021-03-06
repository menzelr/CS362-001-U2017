/*
 * This file was automatically generated by EvoSuite
 * Sun Aug 06 22:42:16 GMT 2017
 */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.MockitoExtension.*;
import static org.evosuite.runtime.EvoAssertions.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CalDay_ESTest extends CalDay_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      // Undeclared exception!
      try { 
        calDay0.addAppt((Appt) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("calendar.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      CalDay calDay0 = null;
      try {
        calDay0 = new CalDay((GregorianCalendar) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("calendar.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.valid = true;
      calDay0.month = 0;
      calDay0.getMonth();
      // Undeclared exception!
      try { 
        calDay0.toString();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("calendar.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.getDay();
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      GregorianCalendar gregorianCalendar0 = mock(GregorianCalendar.class, new ViolatedAssumptionAnswer());
      doReturn(0, 0, 0).when(gregorianCalendar0).get(anyInt());
      CalDay calDay0 = new CalDay(gregorianCalendar0);
      calDay0.getAppts();
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      LinkedList<Appt> linkedList0 = calDay0.appts;
      calDay0.year = (-4634);
      calDay0.appts = null;
      calDay0.getYear();
      calDay0.getMonth();
      calDay0.iterator();
      calDay0.iterator();
      calDay0.isValid();
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.getMonth();
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      // Undeclared exception!
      try { 
        calDay0.getSizeAppts();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("calendar.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.valid = true;
      // Undeclared exception!
      try { 
        calDay0.iterator();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("calendar.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      Appt appt0 = mock(Appt.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(appt0).getValid();
      Appt appt1 = mock(Appt.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(appt1).getValid();
      calDay0.addAppt(appt1);
      calDay0.month = (-432);
      calDay0.addAppt(appt0);
      calDay0.getDay();
      calDay0.getMonth();
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      GregorianCalendar gregorianCalendar0 = mock(GregorianCalendar.class, new ViolatedAssumptionAnswer());
      doReturn(13, 13, 13).when(gregorianCalendar0).get(anyInt());
      CalDay calDay0 = new CalDay(gregorianCalendar0);
      calDay0.getMonth();
      Appt appt0 = mock(Appt.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(appt0).getValid();
      doReturn((String) null).when(appt0).toString();
      calDay0.addAppt(appt0);
      calDay0.getAppts();
      calDay0.year = 13;
      calDay0.getSizeAppts();
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      GregorianCalendar gregorianCalendar0 = mock(GregorianCalendar.class, new ViolatedAssumptionAnswer());
      doReturn((-398), 1, 1).when(gregorianCalendar0).get(anyInt());
      CalDay calDay0 = new CalDay(gregorianCalendar0);
      calDay0.iterator();
      calDay0.getSizeAppts();
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      GregorianCalendar gregorianCalendar0 = mock(GregorianCalendar.class, new ViolatedAssumptionAnswer());
      doReturn(2727, 2727, 2727).when(gregorianCalendar0).get(anyInt());
      CalDay calDay0 = new CalDay(gregorianCalendar0);
      calDay0.toString();
      Appt appt0 = mock(Appt.class, new ViolatedAssumptionAnswer());
      doReturn(0).when(appt0).getStartHour();
      doReturn(true).when(appt0).getValid();
      doReturn((String) null, (String) null, (String) null, (String) null, (String) null).when(appt0).toString();
      calDay0.addAppt(appt0);
      calDay0.day = 0;
      calDay0.isValid();
      calDay0.iterator();
      Appt appt1 = mock(Appt.class, new ViolatedAssumptionAnswer());
      doReturn(0).when(appt1).getStartHour();
      doReturn(true).when(appt1).getValid();
      doReturn((String) null, (String) null).when(appt1).toString();
      calDay0.addAppt(appt1);
      calDay0.getAppts();
      calDay0.iterator();
      calDay0.isValid();
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      GregorianCalendar gregorianCalendar0 = mock(GregorianCalendar.class, new ViolatedAssumptionAnswer());
      doReturn(3, 3, 3).when(gregorianCalendar0).get(anyInt());
      CalDay calDay0 = new CalDay(gregorianCalendar0);
      Appt appt0 = mock(Appt.class, new ViolatedAssumptionAnswer());
      doReturn(3556).when(appt0).getStartHour();
      doReturn(true).when(appt0).getValid();
      doReturn("/", "/", "UKU]", "/", "UKU]").when(appt0).toString();
      calDay0.addAppt(appt0);
      calDay0.getMonth();
      calDay0.getYear();
      calDay0.iterator();
      Appt appt1 = mock(Appt.class, new ViolatedAssumptionAnswer());
      doReturn(1223).when(appt1).getStartHour();
      doReturn(true).when(appt1).getValid();
      doReturn("(EL{VA\"A,<@").when(appt1).toString();
      calDay0.addAppt(appt1);
      calDay0.isValid();
      calDay0.toString();
      calDay0.getDay();
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      GregorianCalendar gregorianCalendar0 = mock(GregorianCalendar.class, new ViolatedAssumptionAnswer());
      doReturn(0, 0, 0).when(gregorianCalendar0).get(anyInt());
      CalDay calDay0 = new CalDay(gregorianCalendar0);
      calDay0.isValid();
      calDay0.toString();
      calDay0.iterator();
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      GregorianCalendar gregorianCalendar0 = mock(GregorianCalendar.class, new ViolatedAssumptionAnswer());
      doReturn(1, 1, 11).when(gregorianCalendar0).get(anyInt());
      CalDay calDay0 = new CalDay(gregorianCalendar0);
      calDay0.iterator();
      Appt appt0 = mock(Appt.class, new ViolatedAssumptionAnswer());
      doReturn(0, 0).when(appt0).getStartHour();
      doReturn(true).when(appt0).getValid();
      doReturn("Y07)rwV*u/?*B", "", "aTH.3cV08JX.K-AvO{", "aTH.3cV08JX.K-AvO{", "pxWu(e").when(appt0).toString();
      LinkedList<Appt> linkedList0 = calDay0.appts;
      calDay0.iterator();
      calDay0.day = 0;
      calDay0.appts = linkedList0;
      calDay0.iterator();
      calDay0.year = 0;
      calDay0.addAppt(appt0);
      int int0 = calDay0.day;
      Appt appt1 = mock(Appt.class, new ViolatedAssumptionAnswer());
      doReturn(0, 0).when(appt1).getStartHour();
      doReturn(true).when(appt1).getValid();
      doReturn("Y07)rwV*u/?*B", "", "", "pxWu(e", "Y07)rwV*u/?*B").when(appt1).toString();
      calDay0.addAppt(appt1);
      calDay0.iterator();
      calDay0.iterator();
      Appt appt2 = mock(Appt.class, new ViolatedAssumptionAnswer());
      doReturn(0, 0).when(appt2).getStartHour();
      doReturn(true).when(appt2).getValid();
      doReturn("aTH.3cV08JX.K-AvO{", "Y07)rwV*u/?*B", "am", "^E%(kI'J1>", "pxWu(e").when(appt2).toString();
      calDay0.addAppt(appt2);
      calDay0.day = 11;
      calDay0.getDay();
      calDay0.toString();
      calDay0.toString();
      calDay0.getMonth();
      calDay0.getAppts();
      calDay0.getDay();
      calDay0.isValid();
      calDay0.toString();
      calDay0.getAppts();
      int int1 = calDay0.getSizeAppts();
      assertEquals(2, int1);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Appt appt0 = mock(Appt.class, new ViolatedAssumptionAnswer());
      Appt appt1 = mock(Appt.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(appt1).getValid();
      Appt appt2 = mock(Appt.class, new ViolatedAssumptionAnswer());
      CalDay calDay0 = new CalDay();
      calDay0.getAppts();
      calDay0.appts = null;
      calDay0.getAppts();
      calDay0.addAppt(appt1);
      assertFalse(calDay0.isValid());
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.iterator();
      int int0 = calDay0.getYear();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.year = 3;
      calDay0.toString();
      Appt appt0 = mock(Appt.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(appt0).getValid();
      calDay0.addAppt(appt0);
      assertFalse(calDay0.isValid());
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.year = 11;
      Appt appt0 = mock(Appt.class, new ViolatedAssumptionAnswer());
  }
}
