package workflows;

import extensions.DBActions;
import extensions.GUIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;

public class WebFlows extends CommonOps {
    @Step("Work Flow: Login")
    public static void logIn(String user, String pass){
        GUIActions.updateText(grafanaLogin.txt_username, user);
        GUIActions.updateText(grafanaLogin.txt_password, pass);
        GUIActions.click(grafanaLogin.btn_login);
        GUIActions.click(grafanaLogin.btn_skip);
    }
    @Step("Work Flow: Login via credentials from DB")
    public static void logInDB(){
        String query ="SELECT name, password FROM Users where id ='5'";
        List<String> creds = DBActions.getCredentials(query);
        GUIActions.updateText(grafanaLogin.txt_username,creds.get(0));
        GUIActions.updateText(grafanaLogin.txt_password,creds.get(1));
        GUIActions.click(grafanaLogin.btn_login);
        GUIActions.click(grafanaLogin.btn_skip);
    }

    @Step("Work Flow: Create a New User")
    public static void  createNewUser (String name, String email, String username, String password){
        GUIActions.click(grafanaServerAdminMain.btn_newUser);
        GUIActions.updateText(grafanaAddNewUser.txt_Name, name);
        GUIActions.updateText(grafanaAddNewUser.txt_Email, email);
        GUIActions.updateText(grafanaAddNewUser.txt_Username, username);
        GUIActions.updateText(grafanaAddNewUser.txt_Password, password);
        GUIActions.click(grafanaAddNewUser.btn_createUser);
    }
    @Step("Work Flow: Remove Last User")
    public static void  removeLastUser (){
        GUIActions.click(grafanaServerAdminMain.userRows.get(grafanaServerAdminMain.userRows.size()-1));
        GUIActions.click(grafanaEditUser.btn_deleteUser);
        GUIActions.click(grafanaEditUser.btn_deleteUserConfirm);
    }
    @Step("Work Flow: Search User")
    public static void  searchAndCheckUser (String user, String exists){
        GUIActions.updateTextAsUser(grafanaServerAdminMain.txt_search, user );
        if (exists.equalsIgnoreCase("exists"))
            Verifications.elemPresence(grafanaServerAdminMain.userRows);
        else if(exists.equalsIgnoreCase("doesn't exist"))
            Verifications.elemAbsence(grafanaServerAdminMain.userRows);
        else throw new RuntimeException(("Invalid output of the testing"));
    }
}
