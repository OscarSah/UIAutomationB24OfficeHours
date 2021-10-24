
10/24/2021
----------

Automation day 3.

Selenium WebDriver - Browser level operations

Today we will start working with web elements.

WebElements are all the items that we see on the browser. Like links, images, input boxes, drop downs, buttons etc

In order to work with them, we need to learn LOCATORS in Selenium.

LOCATOR -> is a way of telling selenium how to find the element

---

new package today:
day03_locators_intro

Add new class in that package TC3_ClickGmailVerifyTitle


<a href="https://mail.google.com/mail/?tab=rm&amp;ogbl" target="_top">Gmail</a>

The above html tag is for Gmail link on google page.

- a - is a tag name for links
- href - it is a property, and the value is the url that it will go when clicked
- Gmail - is the link text that will be shown on the browser.

When working with links using selenium, we can click on the link by locating it first.

There are two locators, meaning ways of finding links in Selenium.

1) linkText -> we pass whole text of the link to selenium

2) partialLinkText -> we can pass the partial text of the link.

SYNTAX:

findElement(By.locator("value"))

driver.findElement(By.linkText("Gmail")).click();
----------------------------

To Tell Selenium to do any action on the webelement:

1) First we need to find the element using the locator
2) apply the action

In order to find the element on the page, we use findElement method.

driver.findElement(By.locator("value"))

- this method finds and returns a single web element
- it accepts locator parameter using By class
- if selenium cannot find the element on the page, it will throw NOSUCHELEMENT Exception
  -RETURN type -> WebElement
- it comes from selenium library
- SELENIUM can ONLY see the HTML code of the page, and it will work with that. it does not see the page how human eyes see

LOCATORS in SELENIUM:

- locators are used to tell selenium how to uniquely FIND the element on the page.
- there are 8 type of locators in Selenium:

#1 - linkText
#2 - partialLinkText
#3 - name
#4 - id
#5 - className
#6 - tagName
#7 - xpath
#8 - css

They are all methods in By class.
By.name() By.linkText() ....
--------------------------------------------

#1 - linkText

- it accepts whole text of the link and will search for the link that matches on the page
- links in HTML have <a> anchor tag, so selenium knows that and will filter elements by tag a then search the matching text
- This locator ONLY works with links
- we need to pass that EXACTLY matches the link

<a href="https://mail.google.com/mail/?tab=rm&amp;ogbl" target="_top">Gmail</a>

driver.findElement(By.linkText("Gmail")).click();


#2 - partialLinkText
- it will look for a link that PARTIALLY matches the text
- similar to contains method in java
- if there are multiple matches, it will return the first one

<a href="https://mail.google.com/mail/?tab=rm&amp;ogbl" target="_top">Goto Gmail</a>

driver.findElement(By.partialLinkText("Gmail")).click(); - good
driver.findElement(By.partialLinkText("Go")).click(); - good
driver.findElement(By.partialLinkText("to")).click(); - good
driver.findElement(By.partialLinkText("mail")).click(); - good
driver.findElement(By.partialLinkText("Gmail Go")).click(); Not good

Exception in thread "main" org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"partial link text","selector":"yahoo"}

it means selenium could not find the element using the locator.

#name -> By.name("name value")
- name is one of 8 locators in selenium
- It will search the html code and find the element with matching name attribute

 <input name="q" title="Search" value="">

driver.findElement(By.name("q")) ....

HOW TO TYPE A VALUE INTO INPUT BOX USING SELENIUM:

	- sendKeys("value")
		-> this method is used to type a value into an web element after finding it.
		-> it accepts a string argument

driver.findElement(By.name("q")).sendKeys("apple");

Keys.ENTER can be passed along in order to hit enter on keyboard.

driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
------------------------


add new class TC5_SmartBearLoginTest


Test Case automation flow:

1) Analyze the test case to make sure I understand the functionality and acceptance criteria. If it is not clear for me, I ask other teammates like BA, Manual tester, Developer .

2) Manually perform the test steps in QA environment, if it not working as expected I report a bug/defect.

3) If manually it is working as expected, and I have all the test data and environment ready, I start automation

4) Go over each element on the application and inspect them in the dev tools of google chrome, I identify which properties can be used best as locators for selenium

5) I add my test and start coding the selenium steps and actions using those locators, then make sure I am verifying the acceptance criteria.

.....


------------------

Exception in thread "main" org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"link text","selector":"Log out"}

The above error/exception means that selenium could not find the element using the locator + value we provided. We need to review that line and make sure the locator is matching with html code
========================


#id -> By.id("id from html") :
	-> one of 8 locators in Selenium
	-> works similar to name locator
	-> id is usually unique to the web element and good idea to use it
	-> but sometimes id might be dynamic meaning it will change when page refreshes/reloads, in that case id might not be good option to use

<a id="ctl00_logout" href="javascript:__doPostBack('ctl00$logout','')">Logout</a>

The above element is a link that has id.
We can either locate using id or linkText

driver.findElement(By.id("ctl00_logout")).click();

driver.findElement(By.linkText("Logout")).click();
==================================================


<h3>Log in to ZeroBank</h3>

#tagName -> By.tagName("h3")
	-> one of 8 locators, that we can use with selenium,
	-> we just provide the tagname of html element

driver.findElement(By.tagName("h3"))

System.out.println("header text = " + driver.findElement(By.tagName("h3")).getText());

getText() method of Selenium WebDriver. It returns the text value of webelement.

text is whatever characters between opening and closing html tags
<h3>Log in to ZeroBank</h3>
in above example <h3> is the tag name
Log in to ZeroBank -> is the text of the element, as we can see , it is between opening and closing html tags.

String header = driver.findElement(By.tagName("h3")).getText();

--------

<a href="/index.html" class="brand">Zero Bank</a>

a -> tag name
href -> attribute, the value is where link will go after clicking
"/index.html" -> is the address where the link will go
class -> html attribute, normally it is used for css styling
"brand" -> is the value for class attribute

This link's classname is "brand"

Zero Bank -> is the text of the link
------------

- className locator - By.className("value of class")
  -> one of 8 locators in Selenium
  -> selenium will scan the html code and find the element that has that classname value

String textOfLink = driver.findElement(By.className("brand")).getText();
System.out.println("textOfLink = " + textOfLink);
