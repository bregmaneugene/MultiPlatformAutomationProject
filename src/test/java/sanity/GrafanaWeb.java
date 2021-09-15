package sanity;

import extensions.GUIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {
    @Test(description = "Test01 - Verify Page Title")
    @Description("This test verifies page's title")
    public void test01_checkTitle(){
        WebFlows.logIn("admin", "admin");
        Verifications.verifyElemText(grafanaStart.title_StartPage, "Welcome to Grafana");
    }

    @Test(description = "Test02 - Verify default user")
    @Description("This test verifies default user")
    public void test02_adminRowValidation(){
        GUIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdminMenu.link_users);
        Verifications.numberOfElements(grafanaServerAdminMain.userRows, 1);
    }

    @Test(description = "Test03 - Verify new added user")
    @Description("This test verifies new added user")
    public void test03_newUserValidation(){
        GUIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdminMenu.link_users);
        WebFlows.createNewUser("Eugene", "E@test.co.il", "eugeneb", "54321");
        Verifications.numberOfElements(grafanaServerAdminMain.userRows, 2);
    }

    @Test(description = "Test04 - Verify removal of the user")
    @Description("This test verifies removal of the user")
    public void test04_userRemoval(){
        GUIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdminMenu.link_users);
        WebFlows.removeLastUser();
        Verifications.numberOfElements(grafanaServerAdminMain.userRows, 1);
    }

    @Test(description = "Test05 - Verify the start page's panel elements")
    @Description("This test verifies visibility of the start page's panel elements (via soft assertions of TestNG)")
    public void test05_verifyStartPanelStages(){
        Verifications.visibilityOfElements(grafanaStart.panel_StartPage);
    }
    @Test(description = "Test06 - Verify user's pic icon")
    @Description("This test verifies user's pic icons (via Sikulli UI Tool)")
    public void test06_verifyUserPicIcon(){
        Verifications.visualElement("GrafanaUserPic");
    }

    @Test(description = "Test07 - Verify user's pic icon", dataProvider = "data-provider-users", dataProviderClass = utilities.DDTManage.class)
    @Description("This test verifies user search functionality")
    public void test07_verifySearchUsern(String user, String exists){
        GUIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdminMenu.link_users);
        WebFlows.searchAndCheckUser(user, exists);

    }
}
