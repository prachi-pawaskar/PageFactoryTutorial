# PageFactoryTutorial

The project demonstrates use of Page Factory automation framework. The framework implements one test case for showcase purpose.

## Getting Started

These instructions will help you get started.

### Prerequisites

1. Java
2. Maven
3. Browser driver [Project have a chrome driver embedded, chrome version: Version 76.0.3809.100 (64-bit)]

## Tests

Uses [Zero banking site](http://zero.webappsecurity.com/index.html) for scenarios.

### Test scenarios

1. Login to the portal successfully and verify landing page.

### How to execute test

1. Through IDE: right click on "TestsToExecute.java" and run "verifyLogin()"
2. Through IDE: right clicj on "testng.xml" and run
3. Through command prompt: mvn test

### Reports from execution

When step 2. and 3. are used for execution, the default testng reports are generated at location
```
target/surefire-reports/
```

## About Page Factory framework

"Page factory" is one of the way to implement "Page Object Model" and is an optimised way as well.
Page Object Model: Each page have an associated class created for it. Each class with UI elements and methods associated with the page. Classes have UI elements declared as "By" object: By signinButton = By.id("signin_button");

Page Factory is annotation inside selenium which we give it to class.
```
@FindBy(id = "signin_button") WebElement signinButton;
```
Usage:
```
signinButton.click();
```
So, when you define any class as page factory, all the elements inside the class will get loaded while any of element in the class is called.
```
PageFactory.initElements(driver, this);
```
This is really a bad practice if we have 100s elements inside a class and we just have to make use of only one. In this case Page Object model should be used
