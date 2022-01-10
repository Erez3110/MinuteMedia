package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mainPage
{
    @FindBy(className = "anniversary-top-wrapper")
    public WebElement anniversary_img;

    @FindBy(xpath = "//div[@id='w-dropdown-toggle-11']")
    public WebElement ourCompany_dropdown;

    @FindBy(xpath = "//a[text()='Contact Us']")
    public WebElement contactUs_btn;
}
