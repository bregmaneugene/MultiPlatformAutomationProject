package workflows;

import extensions.GUIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {
    @Step("Calculates addition 1+9")
    public static void calculateAddition() {
        GUIActions.click(calcMain.btn_clear);
        GUIActions.click(calcMain.btn_one);
        GUIActions.click(calcMain.btn_plus);
        GUIActions.click(calcMain.btn_eight);
        GUIActions.click(calcMain.btn_equals);
    }
}
