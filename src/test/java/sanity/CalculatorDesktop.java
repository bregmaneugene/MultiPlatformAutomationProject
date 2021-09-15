package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {
    @Test(description = "Test 01: Validate Addition action")
    @Description("Test 01: Verifies addition calculation's result")
    public void test01_addTaskAndCheck(){
        DesktopFlows.calculateAddition();
        Verifications.verifyElemText(calcMain.field_result, "Display is 9");
    }
}