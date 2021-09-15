package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class MobActions extends CommonOps {
@Step("Tap the element")
public static void tap (int fingers, MobileElement elem, int duration) {
    wait.until(ExpectedConditions.elementToBeClickable(elem));
    //mobDriver.tap(fingers, elem, duration);
}

@Step("Swipe")
public static void swipe (int startX, int startY, int endX, int ednY, int duration) {
    Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
       //mobDriver.swipe(startX, startY,endX,ednY,duration);
    }

    @Step("Zoom element")
    public static void zoom (MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        //mobDriver.zoom(elem);
    }

    @Step("Pinch element")
    public static void pinch (MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        //mobDriver.pinch(elem);
    }

    @Step("Execute script")
    public static void executeScript (String script) {
    mobDriver.executeScript(script);
    }
    @Step("Update Text Element")
    public static void  updateText(MobileElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

}
