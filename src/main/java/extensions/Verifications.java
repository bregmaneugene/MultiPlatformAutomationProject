package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;


public class Verifications extends CommonOps {
    @Step ("Verify Text in Element")
    public static void verifyElemText(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }
    @Step ("Verify Number of Elements")
    public static void numberOfElements(List<WebElement> elems, int expected){
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(), expected);
    }
    @Step ("Verify Visibility of Elements")
    public static void visibilityOfElements(List<WebElement> elems){
        for(WebElement elem:elems){
            softAssert.assertTrue(elem.isDisplayed(), "Sorry " +elem.getText() + " not displayed");
        }
        softAssert.assertAll("Some elements were not displayed");
    }

    @Step("Verify visual element")
    public static void visualElement(String expectedImage){
        try{
    screen.find(getData("ImageRepo") + expectedImage +".png");
    } catch (FindFailed findFailed){
            System.out.println("Error comparing image file" + findFailed);
            fail("Error comparing image file" + findFailed);
        }
    }
    @Step ("Verify Element is present")
    public static void elemPresence(List<WebElement> elems){
        assertTrue(elems.size() > 0);
    }
    @Step ("Verify Element is absent")
    public static void elemAbsence(List<WebElement> elems){
        assertFalse(elems.size() > 0);
    }

    @Step ("Verify Text correctness")
    public static  void  verifyText(String actual, String expected){
        assertEquals(actual, expected);
    }

    @Step ("Verify Number correctness")
    public static  void  verifyNumber(int actual, int expected){
        assertEquals(actual, expected);
    }
}
