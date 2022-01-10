package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        mainPage_minuteMedia = PageFactory.initElements(driver, PageObjects.mainPage.class);
        contactUs_minuteMedia = PageFactory.initElements(driver, PageObjects.contact.class);
        mainPage_DBLTAP = PageFactory.initElements(driver, PageObjects.mainPage_DBLTAP.class);
    }
}
