package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class mainPage_DBLTAP
{
    @FindBy(xpath = "//header[@class='foldingDown_170nbrz-o_O-style_ykgsfd']/div/div/a/img")
    public WebElement headerLogo_img;

    @FindBy(className = "headerFirstRow_13p737w")
    public WebElement headerPanel;

    @FindBy(xpath = "//div[@class='padding_73yipz-o_O-wrapper_109guv8']/*")
    public List<WebElement> mainCards_list;

    @FindBy(xpath = "//h3[@class='tagStyle_1gkizes-o_O-style_e4x16a-o_O-style_g151si'] " +
                  "| //h3[@class='tagStyle_7istvo-o_O-style_e4x16a-o_O-style_g151si']")
    public List<WebElement> mainCardsTitles_list;

    @FindBy(xpath = "//div[@class='padding_73yipz-o_O-wrapper_109guv8']/descendant::h4/div[1]")
    public List<WebElement> mainCardsAuthors_list;

    @FindBy(xpath = "//div[@class='padding_73yipz-o_O-wrapper_109guv8']/descendant::h4/time")
    public List<WebElement> mainCardsDate_list;

    @FindBy(className = "padding_73yipz-o_O-wrapper_109guv8")
    public WebElement cardsSection;
}
