package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.grafana.AddNewUserPage;
import pageObjects.grafana.EditUserPage;
import pageObjects.grafana.ServerAdminMainPage;
import pageObjects.grafana.ServerAdminMenuPage;

public class ManagePages extends Base {
    /*####################################################################################
         Method Name: initGrafana
         Method Description: The method initiates elements of Grafana web application pages
         Method Parameters: NA
         Method Returns: Void
     ####################################################################################*/
    public static void initGrafana()
    {
        grafanaLogin = PageFactory.initElements(driver, pageObjects.grafana.LoginPage.class);
        grafanaStart = PageFactory.initElements(driver, pageObjects.grafana.StartPage.class);
        grafanaLeftMenu = PageFactory.initElements(driver, pageObjects.grafana.LeftMenuPage.class);
        grafanaServerAdminMenu = PageFactory.initElements(driver, ServerAdminMenuPage.class);
        grafanaServerAdminMain = PageFactory.initElements(driver, ServerAdminMainPage.class);
        grafanaAddNewUser = PageFactory.initElements(driver, AddNewUserPage.class);
        grafanaEditUser = PageFactory.initElements(driver, EditUserPage.class);

    }
    /*####################################################################################
         Method Name: initMortgageCalc
         Method Description: The method initiates elements of Mortgage Calculator mobile application pages
         Method Parameters: NA
         Method Returns: Void
     ####################################################################################*/
    public static void initMortgageCalc()
    {
        mortgageCalcMain = new pageObjects.mortgage.MainPage(mobDriver);
    }
    /*####################################################################################
         Method Name: initToDo
         Method Description: The method initiates elements of ToDoList Electron application pages
         Method Parameters: NA
         Method Returns: Void
     ####################################################################################*/
    public static void initToDo()
    {
        todoMain = PageFactory.initElements(driver, pageObjects.todolist.MainPage.class);
    }
    /*####################################################################################
         Method Name: initCalculator
         Method Description: The method initiates elements of Windows Calculator desktop application pages
         Method Parameters: NA
         Method Returns: Void
     ####################################################################################*/
    public static void initCalculator()
    {
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
