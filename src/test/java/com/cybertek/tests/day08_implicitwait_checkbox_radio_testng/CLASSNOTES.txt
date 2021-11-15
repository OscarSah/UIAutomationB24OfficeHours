
11/14/2021
----------

Test Automation Day 8:
----------------------

Xpath
implicit wait
checkbox, radio
testNg tool
drop downs
---------------

XPATH:
-> one of 8 locators in Selenium, that we can create custom locator for our web elements. We can use any attribute and value, or locate parent then navigate to element that we need. We can also locate elements by index, text etc.
It is very flexible locator in Selenium. And I use it a lot.
It has advantages over CSS locator, since, CSS cannot use indexes, nor locating by text, and also cannot navigate from child to parent. etc

	So in my experience, I find Xpath to be more flexible and I am able to locate basically any element on the page.

	---------
	BASICS: absolute(parent/child hierarchy), relative(searches everywhere on the page and does not depend on hierarchy)

	//TAG[@Property='value']

	//car[@make='honda']

	We already learned different ways that we can write xpath. 
--------------------------------------------
	How do you handle dynamic elements?

1) How do you handle when id of element is dynamic and it is only way to locate it.

Lets say below element has this id and text.
<h3 id="sunny12abc43">Sunday</h3>

After page refresh, depending on tests data or day, date etc , the id and text changes:

<h3 id="sunny55wz12">Monday</h3>

Lets think about it, i would not just go by tagname, because there might be other elements with same tag.

The id seems dynamic but, one portion of id seems constant which is "sunny" part.

Also text seems to be changing based on the day today, but it is always ending with "day".

So based on these conclusions afters my analysis, I could write XPATH with
built in functions like "starts-with", "ends-with", "contains".

EX:

//h3[starts-with(@id,'sunny')]
//h3[ends-with(text(),'day')]

How do you handle dynamic elements?

--> I inspect the element and analyze how it is changing, normally there could be constant part of the id, name or text. and other part is changing/dynamic.
If so -> I write custom xpath that uses "starts-with", "ends-with", "contains" methods.
EX : //h3[starts-with(@id,'sunny')]
//h3[ends-with(text(),'day')]

--> if all attributes seem to be changing every time, I look at the parent elements to see if I can locate the parent then navigate to child
---------------------------------
<h3 id="sunny55wz12">Monday</h3>
<h3 id="!rainy33">java</h3>

I need to see if parent is somehow constant.

<div id="main"> 
	<h3 id="sunny55wz12">Monday</h3>
</div>

//div[@id='main']/h3

=======================================
EX:	Locating mpg value from gas mileage calculator:

	<b>107.8 mpg</b>
	then 
	<b>22.8 mpg</b>

//b[contains(text(),'mpg')]

Seems like ends-with might not work with text. But it works other properties for sure.

Other approach would be going from parent then to child.

EX:
<font color="green">
<b>107.8 mpg</b>
</font>

//font[@color='green']/b
The above xpath will always work, even text of b element changes.
------------------
Going from grand parent to our element:

<p class="verybigtext" style="padding-top:10px;">
	Gas mileage: 
	<font color="red">
		<b>107.8 mpg</b>
	</font> 
</p>

//p[@class='verybigtext']/font/b
//GRANDPARENT/CHILD/CHILD
-------------------
//b will work when there is only 1 b on the page.

//GRANDPARENT // CHILD
//p[@class='verybigtext']//b
//div[@id='content']//b

We are learning how to locate parent/grandparent then locate the child/target element.
We can use // anywhere in the middle of xpath, the meaning will be to search the matching child element.

//p[@class='verybigtext']//b

in above xpath, we mean find p element using class attribute, then look for element with tag b among all child/granchild elements.

//form//input[@name='q']
The above xpath could be used for the search field in google page.
===============================

locating by index:

<div id="hi"> 
	<a href="https://www.google.com">Google</a>
	<a href="https://www.google.com">Google</a>
	<a href="https://www.google.com">Google</a>
</div>

//a[.='Google'] --> this will match all 3 links

(//a[.='Google'])[1] -> this will match first Google link, index of html starts with 1. not zero based. Why? I dont know.

(//a[.='Google'])[2]
(//a[.='Google'])[3]

Lets say you want to go from parent to one of children.

//div[@id='hi']/a -> this will match all 3 elements


//div[@id='hi']/a[1]
//div[@id='hi']/a[2]
//div[@id='hi']/a[3]
-------------------------------

IMPLICIT WAIT:
When selenium findElement method is called, by default, if element is not on the page at that moment, it will throw NoSuchElement exception.

	By adding implicit wait command, we can tell Selenium to wait until element apprears on the page within certain seconds.

	So selenium will look for element until that time passes, 
		-if element is not found within given seconds, then it will throw NoSuchElement exception
        - if element is found before the timeout seconds, it will locate and continue to next step, it does not wait full 10(ex) seconds.
We add below line ONCE, after launching selenium:

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

This 10 second wait time will apply to each time we use findElement method.

implicitlyWait(10, TimeUnit.SECONDS); ==> works with findElement method.

driver will wait up to 10 seconds to find the element, if it finds before 10 seconds, it will continue to next step.
If it cannot find within 10 seconds, then it will show Exception.

-------

add new package day08_implicitwait_checkbox_radio_testng
add new class CheckBoxesWithImplicitWait

After we add below line after launching selenium:
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

lets say we want to locate below element:
<input type="checkbox" name="checkbox1" id="box1">

WebElement checkbox = driver.findElement(By.name("checkbox1"));
checkbox.click();
Selenium will wait upto 10 seconds for the above element to apprear on the page.

Thread.sleep(10000); it will wait 10 seconds no matter what, it is from java, not selenium.

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
it comes from Selenium library, and it will WAIT up to 10 seconds, if element is found before 10 seconds, it will not keep waitining, instead it will goto next step.
=========================

WORKING WITH CHECKBOXES:

<input type="checkbox" name="checkbox1" id="box1">

Checkboxes in html are written using input tag and type="checkbox"

We locate the checkbox using any one of locators like name, id, xpath, classname etc

Then in order to check or UNcheck it, we click on it.

WebElement checkbox1 = driver.findElement(By.name("checkbox1"));
checkbox1.click();

Above click command will CHECK it if checkbox was UN-checked.
OR
it will Un-CHECK it if checkbox was checked.

So we use .click() method for BOTH checking and Unchecking.

---------
I want to make sure to check it and NOT uncheck it?

we use isSelected() method in selenium with If statement - to find out if checkbox currently checked or no.

WebElement checkbox1 = driver.findElement(By.name("checkbox1"));
if(!checkbox1.isSelected()) {
checkbox1.click();
}

How to check if checkbox is checked or un checked?
We use isSelected method with webelement.

if(checkbox1.isSelected()) {
System.out.println("Checkbox is checked");
} else {
System.out.println("Checkbox is NOT checked");
}
======================================================

RADIOBUTTONS IN SELENIUM:
It is similar to checkbox, we locate it using one of locators, then we click() on it to select.
isSelected() method can be used to check if radio is selected or no.

	WebElement red = driver.findElement(By.id("red"));
    if(!red.isSelected()) {
        red.click();
    }
------------------------------------------------------

Launch Browser and goto etsy homepage
search for wooden spoon
click on filters
Select free shipping, on sale
select under $25
Click on apply filters
Print count of results


<span>1,780 results,</span>

//span[contains(text(),'results,')]

<span class="wt-display-inline-flex-sm">
    <span>1,780 results,</span>
</span>

//span[@class='wt-display-inline-flex-sm']/span[1]
=========================

TESTNG INTRODUCTION:

TestNG is Unit Testing tool/framework in Java.

It is used for unit testing by developers and automation testing by SDETs.

So far, our automation code was in main method and it would run and just print pass or fail.

Now, when we start using TestNG , our automation code will actually be A TEST that PASSES or FAILS. Does not depend on print statements.

How do we use TestNG:
-> goto mnvrepository.com and search for testng
-> click on library link and select latest version
-> copy the dependency tag information and paste in to pom.xml
-> refreshed maven so it downloads the library to our machines.

After successfully adding it to pom.xml.
We create normal java class and start using ANNOTATIONS of TestNG

@Test -> to make a method as test
@Before
and many more, lets learn more next class!

add new class TestNGIntro

Go home
