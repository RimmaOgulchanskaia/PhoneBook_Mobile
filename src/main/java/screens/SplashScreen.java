package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SplashScreen extends BaseScreen{
    public SplashScreen(AppiumDriver driver){
        super(driver);
    }

    @FindBy(id="com.sheygam.contactapp:id/version_text")
    WebElement versionApp;

    public boolean validateVersionApp(String text){

        return textInElementPresent(versionApp, text, 10);
    }

    public boolean validateSplashScreenToDissapear(long expectedTime){
        long stastTime= System.currentTimeMillis();
        long endTime= 0L;
        if(new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.invisibilityOf(versionApp))){
            endTime=System.currentTimeMillis();
        }
        long duration= endTime- stastTime;
        System.out.println("Duration" + duration);
        if(duration<=expectedTime)
            return true;
        return false;
    }

}
