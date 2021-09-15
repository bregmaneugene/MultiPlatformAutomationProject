package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditUserPage {
    @FindBy(how= How.XPATH, using = "//button[@class='css-jigxr0-button']")
    public WebElement btn_deleteUser;
    @FindBy(how= How.XPATH, using = "//div[@class='css-1nrg97p']")
    public WebElement btn_deleteUserConfirm;
}
