package SanityTests;

import Extensions.uiActions;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Listeners(Utilities.listeners.class)
public class minuteMedia_web extends commonOps
{
    @Test(description = "Anniversary Hero Image")
    @Description("Verify hero image is displayed")
    public void test01_HelloMinuteMedia()
    {
        assertTrue(mainPage_minuteMedia.anniversary_img.isDisplayed());
    }

    @Test(description = "(Almost) Submit a Form")
    @Description("Go to Contact Us and fill a form")
    public void test02_contactUs() throws InterruptedException
    {
        uiActions.mouseHoverToElement(mainPage_minuteMedia.ourCompany_dropdown);
        driver.navigate().to("https://www.minutemedia.com/contact-us");
        webFlows.fillForm("Erez Toblem","Menora","Erez3110@gmail.com", "054-8823590","Career","Facebook","Hope I'll get the chance to work for you :)");
        uiActions.scrollIntoView(contactUs_minuteMedia.fullName_txt);
        Thread.sleep(2000);
    }
}
