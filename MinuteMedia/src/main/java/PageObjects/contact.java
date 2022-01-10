package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class contact
{
    @FindBy(id = "Full-Name")
    public WebElement fullName_txt;

    @FindBy(id = "Company-Name")
    public WebElement companyName_txt;

    @FindBy(id = "Business-Email")
    public WebElement email_txt;

    @FindBy(id = "Phone-number")
    public WebElement phoneNum_txt;

    @FindBy(id = "Inquiries")
    public WebElement Inquiries_dropdown;

    @FindBy(id = "How-did-you-hear-about-us-2")
    public WebElement heardFrom_txt;

    @FindBy(xpath = "//textarea[@id='Message']")
    public WebElement message_txt;
}
