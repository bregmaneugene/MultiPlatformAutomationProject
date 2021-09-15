package pageObjects.mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainPage {

    private  AppiumDriver mobDriver;

    public  MainPage(AppiumDriver mobDriver){
        this.mobDriver = mobDriver;
        //PageFactory.initElements(new AppiumFieldDecorator(mobDriver, 3, TimeUnit.SECONDS), this);
    }
    @AndroidFindBy(id = "etAmount")
    public AndroidElement txt_amount;

    @AndroidFindBy(id = "etTerm")
    public AndroidElement txt_term;

    @AndroidFindBy(id = "etRate")
    public AndroidElement txt_rate;

    @AndroidFindBy(id = "btnCalculate")
    public AndroidElement btn_calculate;

    @AndroidFindBy(id = "tvRepayment")
    public AndroidElement txt_repayment;

    @AndroidFindBy(id = "tvInterestOnly")
    public AndroidElement txt_InterestOnly;


}
