# MultiPlatformAutomationProject
[Project Execution via Jenkins - Demo Record](https://drive.google.com/file/d/1TCVnRFDsLhQL6IgA7PMXpwCXJI92CifG/view?usp=sharing)
### **_This is a demo QA automation infrastructure project written in JAVA and allowing testing on multiple platforms. The test scenarios in the project are basic ones and were added for demo purposes only and not to provide extensive test coverage of the system under test._**
***
### _Project Overview_
The project’s architecture is built in a manner that allows easy usage and implementation for different applications platforms testing and could be applied to almost every application (web, mobile, API, desktop) with almost minimum efforts. Also its maintenance would be reasonably easy.

Specifically the project provides an infrastructure for automation testing of the following platforms:
1. Web based application (UI testing) – via Selenium
2. Mobile application – via Appium
3. Web API – via REST Assured
4. Electron application – via Selenium
5. Desktop application – via WinAppDriver

The following applications are used as a system under test in this project:
1. Grafana – an open source analytics and interactive visualization web application.
Used for UI Web testing automation and for an API testing automation
2. Mortgage Calculator mobile app – used for a mobile application testing
3. ToDoList – Electron based application used as an example for Electron’s testing
4. Calculator (default Windows desktop app) – used for the desktop testing.

### **_The project’s includes examples of the following methods, patterns and mechanisms usage:_**
1. Different clients’ (including different browsers) support
2. Failure mechanism’s realisation
3. Page Object Model (POM) design pattern
4. Support of external files usage
5. Reporting system implementation (including screenshots for the failed tests)
6. CI support
7. DB testing example
8. Data Driven Testing example
9. Visual testing example

### _In addition to mentioned above, the following Tools & Frameworks have been used in the project:_
* Jenkins has been used for CI and running the tests automatically 
* Allure Reports has been set as the main reporting system
* TestNG testing framework is used for the tests’ implementation
* Listeners interface (to generate logs and customize the TestNG reports)
* MySQL DB free hosting service – used for DB testing example (specifically to test the login flow for Grafana web app while using users’ credentials from the DB)
