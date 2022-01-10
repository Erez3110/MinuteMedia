package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class commonOps extends base
{
    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("Configuration\\dataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
            catch(Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
            doc.getDocumentElement().normalize();
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initBrowser(String browserType, String url)
    {
        if(browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if(browserType.equalsIgnoreCase("firefox"))
            driver = initFFDriver();
        else if(browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid platform name stated");
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeout")) , TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("timeout")));
        action = new Actions(driver);
        js = (JavascriptExecutor)driver;
    }

    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initAPI()
    {
        RestAssured.baseURI = getData("url_api");
        httpRequest = RestAssured.given();
    }

    @BeforeClass
    @Parameters({"platform","browser", "url"})
    public void startSession(String platform, String browser, @Optional("url") String url)
    {
        if(platform.equalsIgnoreCase("web"))
            initBrowser(browser, url);
        else if(platform.equalsIgnoreCase("api"))
            initAPI();
        else
            throw new RuntimeException("Invalid platform name stated");
        managePages.init();
    }

    @BeforeMethod
    @Parameters({"url","platform"})
    public void beforeMethod(@Optional("url") String url, String platform)
    {
        if(platform.equalsIgnoreCase("web"))
            driver.get(url);
    }

    @AfterClass
    @Parameters({"platform"})
    public void closeSession(@Optional("platform") String platform)
    {
        if(platform.equalsIgnoreCase("web"))
            driver.quit();
    }
}
