package ui_mobile;

import config.AppiumConfig;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class SplashTest extends AppiumConfig {
    @Test
    public void splashTest(){
        new SplashScreen(driver).validateVersionApp("Version 1.0.0");

    }
}
