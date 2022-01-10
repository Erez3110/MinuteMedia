package WorkFlows;

import Extensions.apiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

public class apiFlows extends commonOps
{
    @Step("Search a character by name")
    public static List<String> searchCharByName(String name)
    {
        Response response = apiActions.get("/people/?search=" + name);
        jp = response.jsonPath();
        return jp.getList("results");
    }

    @Step("Get a value of a property")
    public static String getPropertyValue(String resource, String property)
    {
        Response response = apiActions.get(resource);
        jp = response.jsonPath();
        return jp.get(property);
    }

//    Examples for methods using Post, Put, Delete requests
//    @Step("Add a New Character")
//    public static void postChar(String name, String gender)
//    {
//        requestParams.put("name",name);
//        requestParams.put("gender",gender);
//        ...
//        ...
//        ...
//        apiActions.post(requestParams,"people");
//    }
//
//    @Step("Update a Star ship")
//    public static void putStarship(String name, String model, String id)
//    {
//        requestParams.put("name",name);
//        requestParams.put("model",model);
//        ...
//        ...
//        ...
//        apiActions.put(requestParams,"starships/" + id);
//    }
//
//    @Step("Delete a Species")
//    public static void deleteSpecies(String id)
//    {
//        apiActions.delete("species/" + id);
//    }
}
