package Helpers;

import Utilities.commonOps;
import Utilities.helperMethods;
import org.testng.annotations.Test;

import java.io.IOException;

public class visualTesting extends commonOps
{
    // Use to create an initial screenshot
    @Test
    public void createScreenShot() throws IOException
    {
        helperMethods.takeElementScreenShot(mainPage_DBLTAP.headerLogo_img, "DBLTAP_Logo");
    }
}
