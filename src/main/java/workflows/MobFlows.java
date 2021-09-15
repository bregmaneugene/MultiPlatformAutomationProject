package workflows;

import extensions.MobActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobFlows extends CommonOps {
    @Step("Work Flow: Calculate Mortgage")
    public static void calculatorMortgage(String amount, String term, String rate){
        MobActions.updateText(mortgageCalcMain.txt_amount, amount);
        MobActions.updateText(mortgageCalcMain.txt_term, term);
        MobActions.updateText(mortgageCalcMain.txt_rate, rate);
        MobActions.tap(1,mortgageCalcMain.btn_calculate, 500);
    }
}
