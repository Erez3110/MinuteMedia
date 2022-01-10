package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class verifications extends commonOps
{
    @Step("Verify Text in Element")
    public static void textInElement(WebElement elem, String expectedValue)
    {
        assertEquals(elem.getText(),expectedValue);
    }

    @Step("Verify Text with Text")
    public static void textInElement(String elem, String expectedValue)
    {
        assertEquals(elem,expectedValue);
    }

    @Step("Verify Number of Elements")
    public static void numberOfElements(List<String> items, int expectedValue)
    {
        assertEquals(items.size(),expectedValue);
    }

    @Step("Verify CSS value of an Element - Soft Assertion")
    public static void cssValue(WebElement elem, String cssAttribute, String expectedValue)
    {
        String actual = elem.getCssValue(cssAttribute);
        softAssertion.assertEquals(actual, expectedValue);
    }

    @Step("Verify Image")
    public static void visualElement(WebElement imageElement, String expectedImageName)
    {
        BufferedImage expectedImage = null;
        try
        {
            expectedImage = ImageIO.read(new File(getData("imageRepo") + expectedImageName + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error reading image file, see details: " + e);
        }
        Screenshot imageScreenShot = new AShot().takeScreenshot(driver,imageElement);
        BufferedImage actualImage = imageScreenShot.getImage();
        diff = imageDiff.makeDiff(actualImage,expectedImage);
        assertFalse(diff.hasDiff(), "Images are not the same");
    }
}
