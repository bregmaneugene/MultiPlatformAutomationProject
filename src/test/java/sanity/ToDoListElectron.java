package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class ToDoListElectron extends CommonOps {

    @Test(description = "Test 01: Add task and check total number of tasks is changed")
    @Description("Test 01: Adds and verifies the new task in the list ")
    public void test01_addTaskAndCheck(){
        ElectronFlows.addTask("Research Universe");
        Verifications.verifyNumber(ElectronFlows.countTasks(),1);
    }

    @Test(description = "Test 02: Add more tasks and check total number of tasks is changed")
    @Description("Test 01: Adds and verifies one more task in the list ")
    public void test02_addMoreTasksAndCheck(){
        ElectronFlows.addTask("Research Planet");
        ElectronFlows.addTask("Research Galaxy");
        ElectronFlows.addTask("Research Everything and All");
        Verifications.verifyNumber(ElectronFlows.countTasks(),3);
    }

}
