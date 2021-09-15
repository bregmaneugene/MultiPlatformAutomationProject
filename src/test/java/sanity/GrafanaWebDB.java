package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWebDB extends CommonOps {
    @Test(description = "Test01 - Login to Grafana via credentials from the DB")
    @Description("This test checks login using credentials received from DB")
    public void test01_checkTitle(){
        WebFlows.logInDB();
        Verifications.verifyElemText(grafanaStart.title_StartPage, "Welcome to Graf");
    }
}
