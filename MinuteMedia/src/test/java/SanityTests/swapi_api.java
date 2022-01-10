package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.apiFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(Utilities.listeners.class)
public class swapi_api extends commonOps
{
    @Test(description = "Test 01: Search for a Character Using a Keyword")
    @Description("Test Description: Search for a character and verify number of results")
    public void test01_searchChar()
    {
        List<String> res =  apiFlows.searchCharByName("Obi-Wan Kenobi");
        verifications.numberOfElements(res, 1);
    }

    @Test(description = "Test 02: Search With a Partial Keyword")
    @Description("Test Description: Verify number of results searching with a partial keyword")
    public void test02_searchCharByPartialText()
    {
        List<String> res =  apiFlows.searchCharByName("sky");
        verifications.numberOfElements(res, 3);
    }

    @Test(description = "Test 03: Check Diameter of a Planet")
    @Description("Test Description: Verify the diameter of Tatooine")
    public void test03_verifyTatooineDiameter()
    {
        String value = apiFlows.getPropertyValue("/planets/1/", "diameter");
        verifications.textInElement(value, "10465");
    }

    @Test(description = "Test 04: Check Number of Appearances")
    @Description("Test Description: Verify the number of movie appearances of the Millennium Falcon")
    public void test04_millenniumFalconAppearances()
    {
        String value = apiFlows.getPropertyValue("/starships/10/", "max_atmosphering_speed");
        verifications.textInElement(value, "1050");
    }
}
