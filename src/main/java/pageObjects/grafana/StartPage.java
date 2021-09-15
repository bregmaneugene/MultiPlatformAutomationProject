package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class StartPage {
    @FindBy(how= How.XPATH,using = "//h1[@class='css-jjwbqw']")
    public WebElement title_StartPage;

    @FindBy(how= How.XPATH,using = "//div[@class='css-12ve8b']")
    public List<WebElement> panel_StartPage;

}
