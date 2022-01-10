package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class helperMethods extends commonOps
{
    // Both of the approaches crop the img element when taking a screenshot - need to resolve
    public static void takeElementScreenShot(WebElement imageElem, String imageName) throws IOException
    {
//        imageScreenShot = new AShot().coordsProvider((new WebDriverCoordsProvider())).shootingStrategy(ShootingStrategies.scaling(2f)).takeScreenshot(driver,imageElem); //win 10
////        imageScreenShot = new AShot().shootingStrategy(ShootingStrategies.scaling(1.5f)).takeScreenshot(driver,imageElem);
//        try
//        {
//            ImageIO.write(imageScreenShot.getImage(),"png", new File(getData("imageRepo") + imageName + ".png"));
//
//        }
//        catch (Exception e)
//        {
//            System.out.println("Error writing image file, see details: " + e);
//        }
        // Get entire page screenshot
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

// Get the location of element on the page
        Point point = imageElem.getLocation();
        System.out.println(point);

// Get width and height of the element
        int eleWidth = imageElem.getSize().getWidth();
        int eleHeight = imageElem.getSize().getHeight();
        System.out.println(eleWidth);
        System.out.println(eleHeight);

// Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
                eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);

// Copy the element screenshot to disk
        File screenshotLocation = new File(getData("imageRepo") + imageName + ".png");
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    // Get cell value from xls file
    public static String getCell(int row, int column)
    {
        FileInputStream fis= null;
        try
        {
            fis = new FileInputStream(new File(getData("cardDetails")));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        HSSFWorkbook wb= null;

        try
        {
            assert fis != null;
            wb = new HSSFWorkbook(fis);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        assert wb != null;
        HSSFSheet sheet=wb.getSheetAt(0);
        return String.valueOf(sheet.getRow(row).getCell(column));
    }
}
