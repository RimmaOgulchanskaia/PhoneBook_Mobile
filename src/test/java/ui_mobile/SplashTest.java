package ui_mobile;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class SplashTest extends AppiumConfig {
    @Test
    public void splashTest(){
        new SplashScreen(driver).validateVersionApp("Version 1.0.0");

    }

    @Test
    public void validateSplashTimeTest(){
        Assert.assertTrue(new SplashScreen(driver).validateSplashScreenToDissapear(5000));
    }
}
