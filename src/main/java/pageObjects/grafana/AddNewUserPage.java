package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddNewUserPage {
    @FindBy(how= How.XPATH, using = "//input[@name='name']")
    public WebElement txt_Name;
    @FindBy(how= How.XPATH, using = "//input[@name='email']")
    public WebElement txt_Email;
    @FindBy(how= How.XPATH, using = "//input[@name='login']")
    public WebElement txt_Username;
    @FindBy(how= How.XPATH, using = "//input[@name='password']")
    public WebElement txt_Password;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement btn_createUser;

}
