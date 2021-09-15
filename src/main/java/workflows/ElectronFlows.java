package workflows;

import extensions.GUIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {
    @Step("Work Flow: Add a task")
    public static void addTask (String taskName){
        GUIActions.updateText(todoMain.txt_CreateTask, taskName);
        GUIActions.insertKey(todoMain.txt_CreateTask, Keys.RETURN);
    }
    @Step("Work Flow: Count tasks quantity in the list")
    public static int countTasks (){
    return  todoMain.list_Tasks.size();
    }

    @Step("Work Flow: Removes tasks from the list")
    public static void clearTasks () {
        for (int i = 0; i < countTasks(); i++) {
            GUIActions.mouseHover(todoMain.btn_x);
        }
    }
}
