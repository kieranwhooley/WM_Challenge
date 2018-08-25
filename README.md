QA Challenge
============

Required software:
------------------

This project requires the following:

Test/Progamming tools:
----------------------
Java 9.0.1\
Selenium 3.14.0\
TestNG

You should also download the Chrome, Firefox and IE drivers for Selenium. Save these locally and then put the folder location you saved them in into the src/utilities/DriverFactory file. Replace "C:\\QA_Challenge\\Software\\.." with the location you have saved the files locally. This DriverFactory will allow you to test the 
application across multilple browsers.

Selenium Drivers:
-----------------
The required drivers are:\
chromedriver\
geckodriver\
IEDriverServer

These can be downloaded from here: https://www.seleniumhq.org/download/

Browsers:
---------
I ran these tests against Chrome Version 68.0.3440.106 (Official Build) (64-bit)

Running the tests:
------------------

In order to run the tests you will need to enter a valid website URL, a valid email address and a valid password. (The ones which were provided in the original email for this challenge).

These are the fields to fill in:

String webURL = ""; //Enter URL for site to be tested here\
String validLoginEmail = ""; //Enter valid email address to login here\
String validLoginPassword = ""; //Enter valid password to login here

Once these details have been added at the top of the LoginPageTests, ResetPasswordPageTests and TalentPageTests pages the tests can then run.

Further Details:
----------------

I did not cover all the possible tests for each page. For example I have not included basic checks confirming elements are displayed on a page. These can easily be added using an isDisplayed() method if required but I felt this task was a check of more advanced test automation skills. There are also dozens of tests that could be executed against the Find Talent page, but I feel I have given a good level of coverage for the most basic functionality.

Also, currently the tests for each page of the application need to be run individually, however it would be possible to create an XML file using TestNG to run all of these tests as a combined test suite if required.
