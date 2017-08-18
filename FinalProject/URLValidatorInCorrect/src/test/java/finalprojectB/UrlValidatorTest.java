/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;



/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

  private boolean printStatus = false;
  private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.
	
	//BEGIN DECLARATION BLOCK//////////////////////////////////////////////////////////////////////////
	//pool of protocol values and associated validity lookup
	public static final int protocolSize = 20;

	//ignores local file access ex. file:///C:/Users/User/file.html -- add
	public String[] protocolList = {"http://",	"https://",	"",					"http:/",
																	"ftp://", 	"sftp://", 	"hppt://",	"@",
																	"http:",		"http",			"https:/",	"https:", 
																	"https",		" ",				"://",			":", 
																	"//",				"/",				"http:///",	"fpt://"};

	public boolean[] protocolVal = {true, 			true, 			true, 			false,
																	true, 			true, 			false, 			false, 
																	false, 			false, 			false, 			false, 
																	false, 			false, 			false, 			false, 
																	false, 			false, 			false, 			false};
	
	//pool of address values and associated validity lookup
	public static final int addrSize = 28;
	//add web.engr.oregonstate.edu
	public String[] addrList = {"www.google.com",	"google.com",			"uw.edu",					"epa.gov",
															"www.go.co.uk",		"0.0.0.0",				"255.255.1.255",	"1.com",
															"google.!",				"1.1.1",					"1.1.1.1.",				"11111",
															"goo%gle",				"user@mail.com",	"#google",				"256.0.0.1",
															"go ogle",				" ",							"",								"?",
															"google.",				".google",        "code.google.com","userid:name@mail.com",
															"a.b-c.net",			" google.com",		".go.net",				"1.1.1.1."};

	public boolean[] addrVal = {true, 						true, 						true, 						true,
															true, 						true, 						true, 						true,
															false,  					false, 						false, 						false,
															false, 						true,			 				false, 						false,
															false, 						false, 						false, 						false, 
															false, 						false,						true,							true,
															true,							false,						false,						false};
	
	//pool of path values and associated validity lookup -- NOTE: can have path OR port, not both
	public static final int pathSize = 20;
	
	public String[] pathList = {"/path",					"path",						"/1_path",				"/1path2",
															"/path/",					"/path/path",			"/path/path/",		"/path.txt",
															"",								"/pa th",					".",							"..",
															"//path",					"/path//path",		"/../", 					"/.",
															"//",							".com",           "/",							"/blah_(wikipedia)_blah#cite-1"};

	public boolean[] pathVal = {true, 						false, 						true, 						true,
															true, 						true, 						true, 						true,
															true, 						false, 						false, 						false,
															false, 						false, 						false, 						false,
															false, 						false,						true,							true};

	//pool of query values and associated validity lookup
	public static final int querySize = 8;

	public String[] queryList = {"?user=123&pass=good",		"?path=something",		"",
															 "?user=123?p=pk",				"user=123",						"user=123&pass=ok",
															 "?animal= squirrel",			"?q=Test%20URL-encoded%20stuff"};

	public boolean[] queryVal = {true, 										true, 								true,
															 false, 									false, 								false,
															 false,										true};

	//pool of port values and associated validity lookup
	public static final int portSize = 9;
	
	public String[] portList = {":80",		":8080",		":1",			"",
															":0",			":-1",			"80",			":1sq",
															":8080/"};

	public boolean[] portVal = {true, 		true, 			true, 		true,
															true, 		false, 			false, 		false,
															true};
	//END DECLARATION BLOCK////////////////////////////////////////////////////////////////////////////
	 
	 
  public UrlValidatorTest(String testName) {
    super(testName);
  }

   
   
  public void testManualTest(){
	  UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	  System.out.println(urlVal.isValid("http://www.amazon.com"));
	}   
	   
     
   
  public void testYourFirstPartition(){
	   
  }
   
  public void testYourSecondPartition(){
	   
  }
   
   
  public void testIsValid(){
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		int rand;
		boolean valid;
		boolean test;
		String url;
		
		for(int i = 0;i<10000;i++){
			rand = ThreadLocalRandom.current().nextInt(1, 10+1);//generate value between 1-10
			valid = true; //reset valid
			url = "";			//reset url
			
		  //10% chance of null value or empty string
			if (rand == 1) {
				rand = ThreadLocalRandom.current().nextInt(0, 2); //flip a coin
				valid = false;
				if (rand == 1) { //5% null
					url = null;
				} else { //5% empty string
					url = "";
				}//end IF/ELSE
			} else {
				//url contains values
				//determine protocol value
				rand = ThreadLocalRandom.current().nextInt(0, protocolSize);
				url += protocolList[rand];
				if (protocolVal[rand] == false) {//set valid accordingly
					valid = false;
				}
				//determine address value
				rand = ThreadLocalRandom.current().nextInt(0, addrSize);
				url += addrList[rand];
				if (addrVal[rand] == false) {//set valid accordingly
					valid = false;
				}
				rand = ThreadLocalRandom.current().nextInt(1, 10+1);//generate value between 1-10
				if (rand <=5) { //50% chance of path
					rand = ThreadLocalRandom.current().nextInt(1, 4+1);//generate value between 1 and 4
					if (rand == 1) {
						//10% also has query
						//determine path value
						rand = ThreadLocalRandom.current().nextInt(0, pathSize);
						url += pathList[rand];
						if (pathVal[rand] == false) {//set valid accordingly
							valid = false;
						}
						//then determine query value
						rand = ThreadLocalRandom.current().nextInt(0, querySize);
						url += queryList[rand];
						if (queryVal[rand] == false) {//set valid accordingly
							valid = false;
						}
					} else {
						//30% no query
						//determine path value
						rand = ThreadLocalRandom.current().nextInt(0, pathSize);
						url += pathList[rand];
						if (pathVal[rand] == false) {//set valid accordingly
							valid = false;
						}
					}
				} else if (rand > 7) { //30% chance of query alone
					//determine query value
					rand = ThreadLocalRandom.current().nextInt(0, querySize);
					url += queryList[rand];
					if (queryVal[rand] == false) {//set valid accordingly
						valid = false;
					}
				} else { //20% chance of port
					//determine port value
					rand = ThreadLocalRandom.current().nextInt(0, querySize);
					url += portList[rand];
					if (portVal[rand] == false) {//set valid accordingly
						valid = false;
					}
				}//end IF/ELSE IF/ELSE -- tail determination
			}//end IF/ELSE -- null determination
			
			//test the url
			test = urlVal.isValid(url);
			try {
				assertEquals(url, valid, test);
			} catch(AssertionError e) {
				System.out.print("\n" + (char)27 + "[31m!!FAILURE!!" + (char)27 + "[0m URL = " + url + " expected: " + valid + " but was: " + test + "\n");
			}
			
      //assertEquals(url, valid, test);
			
	  }//end master FOR loop
  }//end method testIsValid
   
  public void testAnyOtherUnitTest(){
	   
  }
  /*
  * Create set of tests by taking the testUrlXXX arrays and
  * running through all possible permutations of their combinations.
  *
  * @param testObjects Used to create a url.
  */
   

}
