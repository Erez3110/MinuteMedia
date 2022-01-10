package SanityTests;

import Extensions.uiActions;
import Extensions.verifications;
import Utilities.commonOps;
import Utilities.helperMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class dbltap_web extends commonOps
{
    @Test(description = "Top Navigation Bar Style")
    @Description("Verify navbar style properties")
    public void test01_navbarStyle()
    {
        verifications.cssValue(mainPage_DBLTAP.headerPanel,"background-color","rgba(0, 0, 0, 1)");
    }

    @Test(description = "Navigation bar items")
    @Description("Verify navbar items color change on hover")
    public void test02_navbarItemsColor()
    {
        for(int i = 1; i <= 10; i++)
        {
            WebElement item = driver.findElement(By.xpath("//ul[@class='fixedUl_nkctac']/li[" + i + "]/a/span"));
            softAssertion.assertTrue(item.getCssValue("color").contains("255, 255, 255"));

            uiActions.mouseHoverToElement(item);
            softAssertion.assertTrue(item.getCssValue("color").contains("220, 35, 48"));
        }
        softAssertion.assertAll();
    }

    @Test(description = "Main Cards Details")
    @Description("Verify main cards title, author, date")
    public void test03_mainCards()
    {
        for(int i = 0; i < 5; i++)
        {
            softAssertion.assertEquals(mainPage_DBLTAP.mainCardsTitles_list.get(i).getText(), helperMethods.getCell(i+1,0));
            softAssertion.assertEquals(mainPage_DBLTAP.mainCardsAuthors_list.get(i).getText(), helperMethods.getCell(i+1,1));
            softAssertion.assertEquals(mainPage_DBLTAP.mainCardsDate_list.get(i).getText(), helperMethods.getCell(i+1,2));
        }
        softAssertion.assertAll();
    }
}
