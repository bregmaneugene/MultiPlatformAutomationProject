package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobFlows;

@Listeners(utilities.Listeners.class)
public class MortgageCalcMob extends CommonOps {
    @Test(description = "Test01 - Verify the motgage calculation")
    @Description("This test verifies repayment's calculation")
    public void test01_checkRepayment(){
        MobFlows.calculatorMortgage("2500", "4", "5");
        Verifications.verifyElemText(mortgageCalcMain.txt_repayment, "£58.75");
    }
}
