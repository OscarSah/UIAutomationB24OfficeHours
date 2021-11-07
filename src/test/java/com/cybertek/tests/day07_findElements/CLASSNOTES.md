
11/07/2021
----------

Review practice with Calculator task
css vs xpath
going from parent to child using css and xpath

findElements method
-----------------------

add new package day07_findElements

add new class CalculatorAddTest


<div id="sciOutPut">&nbsp;8</div>

&nbsp; -> a HTML character for empty space " "

============================================

Using Variable value as a part of Xpath/CSS or any locator.

<span onclick="r(2)" class="scinm">2</span>
<span onclick="r(3)" class="scinm">3</span>
<span onclick="r(4)" class="scinm">4</span>

In above html elements, they are similar except the text and onclick value is changing.

If you have to work with those elements, we can write one xpath and pass numbers from variable.

EX:

Xpath:
int num1 = 2;
int num2 = 5;

	//span[.='2'] ==> "//span[.='" + num1 + "']"
	
	"//span[.='" + num2 + "']"

CSS:
int num1 = 2;
int num2 = 5;

	"span[onclick='r(2)']"" 
	"span[onclick='r(" + num1 + ")']
=======================================

IQ: Difference between CSS and Xpath?

- both are one of 8 locators in Selenium webdriver and help us write custom locators. Especially useful when there is no id or name etc.

- we can use tagname and any html attribute

- 1) Xpath can locate elements using the TEXT value
     CSS cannot use text value
2) Xpath can use indexes when there are multiple matches
   CSS does not support indexing numbers
3) Xpath we can navigate from parent to child. and child to parent
   CSS does not support Child to parent navigation.
   CSS supports only Parent > child navigation
4) Xpath is considered to be slower
   CSS is slightly faster.
   But we do not feel the difference unless we work with many elements
   ======================================================================

NAVIGATING FROM PARENT TO CHILD IN XPATH AND CSS:

<html>
	<body>
	   <form>
			<div id="info">
				<h2>Fill out</h2>
				<p>
					<a href="https://www.google.com"> Google </a>
					<input type="text">
					<input type="submit">
				</p>
			</div>
		</form>
	</body>
</html>

xpath: //h2[.='Type your info below']
The above xpath relies on the text to be non-changing, so if text changes or it is dynamic then locator will not work.

In these kind of situations, we can go to parent with some id or name then navigate to child from that parent.

XPATH:
//div[@id='info']/h2

We use / to navigate from parent to child in xpath.

CSS:
In CSS , we use > to navigate from parent to child
div[id='info'] > h2

//div[@class='example']/h2
div[class='example']>h2

//div[@id='content']/div/h2
div[id='content']>div>h2
==================================

NAVIGATING FROM CHILD TO PARENT USING XPATH:

We use /.. to goto parent element:

<div id="info">
		<h2 class="msg">Fill out</h2>
</div>

//h2[@class='msg']/..    <--- this locator will find div.

CSS does not support going from Child to Parent.
----------------

We can use parent>child, child > parent , siblings navigations when it is impossible to locate our element directly.
Maybe id or text or any properties are dynamic.
----------------

FINDELEMENTS METHOD in Selenium:

This method locates and returns one or more elements as a List.
It will find all matching elements to the locator and return them as a List of WebElement objects.

EX:

Below statement returns one element that has classname as 'java'
WebElement el1 = driver.findElement(By.className("java"));

The following statement returns all elements that have classname 'java'
as a List of WebElement objects
List<WebElement> elements = driver.findElements(By.className("java"));

We need findElements method when working with multiple elements on the page like, multiple images, links and loop through them. or check count.


<a href="https://www.google.com"> Google </a>
<input type="text">
<input type="submit">

Lets say I want to find count of elements with 'input' tag:

List<WebElement> inputElems = driver.findElements(By.tagName("input"));

System.out.println("count of input elems = " + inputElems.size() ); 2
--------------------------

<a href="https://www.google.com"> Google </a>
<a href="https://www.etsy.com"> Etsy </a>
<a href="https://www.amazon.com"> Amazon </a>

List<WebElement> links = driver.findElements(By.tagName("a"));

System.out.println("count = " + links.size());

//click first link
links.get(0).click();

//print text of second link:
System.out.println(links.get(1).getText());

-----------------------
List<String> names = new ArrayList<>();
= new LinkedList<>();
....
names.add("Gurkan");
names.add("Takhmina");
names.add("Syeda");
names.add("Mykyta");

System.out.println(names.get(0)); ==> "Gurkan"
System.out.println(names.get(1).toUpperCase()); ==> TAKHMINA

for(String friendName : names) {
System.out.println(friendName + " => " + friendName.length());
}

-----------------------

LOOP THROUGH THE LIST OF WEBELEMENTS:

<a href="https://www.google.com"> Google </a>
<a href="https://www.etsy.com"> Etsy </a>
<a href="https://www.amazon.com"> Amazon </a>

List<WebElement> links = driver.findElements(By.tagName("a"));

For each loop/ Enhanced for loop
I want to print text of each link on the page/list:

for(WebElement eachLink : links) {
System.out.println("text = " + eachLink.getText());
}

Google
Etsy
Amazon
---------------------------------------------

Add new class ForgotPassWordFindElements

Add new class RegistrationFormInputFields
Goto
https://form.jotform.com/213106431512137

Type "wooden spoon" in each and every input box/field

input[type='text']

student[mobile='iphone']








