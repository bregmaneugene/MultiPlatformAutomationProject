package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class APIActions extends CommonOps {
    @Step ("Get data from server")
    public static Response get(String paramValues){
      response=httpRequest.get(paramValues);
      response.prettyPrint();
      return response;
    }

    @Step ("Extract value from JSON")
    public static String extractFromJSON(Response response, String path){
     jPath = response.jsonPath();
     return jPath.get(path).toString();
    }

    @Step ("Post data to server")
    public static void post(JSONObject params, String resource){
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response=httpRequest.post(resource);
        response.prettyPrint();
    }

    @Step ("Update data at the server")
    public static void put(JSONObject params, String resource){
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response=httpRequest.put(resource);
        response.prettyPrint();
    }
    @Step ("Delete data from the server")
    public static void delete(String id){
        response=httpRequest.delete("/api/teams/"  + id);
        response.prettyPrint();
    }

}
