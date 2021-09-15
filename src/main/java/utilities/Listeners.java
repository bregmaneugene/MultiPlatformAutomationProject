package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    /*####################################################################################
        Method Name: onStart
        Method Description: The method prints 'Starting execution' message during the test execution
        Method Parameters: ITestContext
        Method Returns: Void
    ####################################################################################*/
    public void  onStart (ITestContext execution){
      System.out.println("---Starting execution---");
    }
    /*####################################################################################
        Method Name: onStart
        Method Description: The method prints 'Finishing execution' message during the test execution
        Method Parameters: ITestContext
        Method Returns: Void
    ####################################################################################*/
    public void  onFinish (ITestContext execution){
        System.out.println("---Finishing execution---");
    }
    /*####################################################################################
        Method Name: onTestFailedButWithinSuccessPercentage
        Method Description: The method prints 'Finishing execution' message during the test execution
        Method Parameters: ITestResult
        Method Returns: Void
    ####################################################################################*/
    public void  onTestFailedButWithinSuccessPercentage (ITestResult arg0){
        System.out.println("Test failed but it is in defined success ratio " + arg0.getName() + " ---");
    }
    /*####################################################################################
         Method Name: onTestSkipped
         Method Description: The method prints 'Skipping test: ' message during the test execution
         Method Parameters: ITestResult
         Method Returns: Void
     ####################################################################################*/
    public void  onTestSkipped (ITestResult test){
        System.out.println("---Skipping test: " + test.getName() + " ---");
    }
    /*####################################################################################
         Method Name: onTestStart
         Method Description: The method prints 'Starting test: ' message during the test execution
         Method Parameters: ITestResult
         Method Returns: Void
     ####################################################################################*/
    public void  onTestStart (ITestResult test){
        System.out.println("---Starting test: " + test.getName() + " ---");
    }
    /*####################################################################################
         Method Name: onTestSuccess
         Method Description: The method prints '"---Test: " + test.getName() + " passed---"' message during the test execution, and stops and removes recording
         Method Parameters: ITestResult
         Method Returns: Void
     ####################################################################################*/
    public void  onTestSuccess (ITestResult test) {
        if (!platform.equalsIgnoreCase("api")) {
            System.out.println("---Test: " + test.getName() + " passed---");

            //Stopping video recording
            try {
                MonteRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Removing the video record
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete())
                System.out.println("Deleted successfully");
            else
                System.out.println("Failed to delete file");
        }
    }
    /*####################################################################################
         Method Name: onTestFailure
         Method Description: The method prints '"---Test: " + test.getName() + " failed---"' message during the test execution, and stops and saves recording
         Method Parameters: ITestResult
         Method Returns: Void
     ####################################################################################*/
    public void  onTestFailure (ITestResult test) {
        if (!platform.equalsIgnoreCase("api")) {
            System.out.println("---Test: " + test.getName() + " failed---");
            try {
                MonteRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenshot();
        }
    }
    /*####################################################################################
         Method Name: saveScreenshot
         Method Description: The method saves the screenshot
         Method Parameters: NA
         Method Returns: byte
     ####################################################################################*/
    @Attachment(value="Page Screen-shot", type="image/png")
    public byte[] saveScreenshot(){
        if (!platform.equalsIgnoreCase("mobile"))
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        else return ((TakesScreenshot)mobDriver).getScreenshotAs(OutputType.BYTES);

    }

}
