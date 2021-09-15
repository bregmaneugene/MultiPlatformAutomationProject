package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.APIFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaAPI extends CommonOps {

    @Test(description = "Test 01: Verify team's name in Grafana ")
    @Description("Test 01: Verify team's name in Grafana ")
    public void test01_teamVerification(){
   Verifications.verifyText(APIFlows.getTeamProperty("teams[0].name"), "Team_1");
    }
    @Test(description = "Test 02: Add new team and verify team's name in Grafana ")
    @Description("Test 02:  Adds the team and verifies its name in Grafana ")
    public void test02_addTeamAndVerification(){
        APIFlows.postTeam("EugeneTeam", "eugeneteam@best.com");
        Verifications.verifyText(APIFlows.getTeamProperty("teams[0].name"), "EugeneTeam");
    }
    @Test(description = "Test 03: Update team and verify team's name in Grafana ")
    @Description("Test 03:  Updates the team and verifies its name in Grafana ")
    public void test03_updateTeamAndVerification(){
        String id=APIFlows.getTeamProperty("teams[0].id");
        APIFlows.updateTeam("EugeneTeam", "eugeneteam@thebest.com", id);
        Verifications.verifyText(APIFlows.getTeamProperty("teams[0].email"), "eugeneteam@thebest.com");
    }
    @Test(description = "Test 04: Delete team and verify its removal")
    @Description("Test 04:  Deletes team and verifies its removal")
    public void test04_deleteTeamAndVerification(){
        String id=APIFlows.getTeamProperty("teams[0].id");
        APIFlows.deleteTeam(id);
        Verifications.verifyText(APIFlows.getTeamProperty("totalCount"), "1");
    }

}
