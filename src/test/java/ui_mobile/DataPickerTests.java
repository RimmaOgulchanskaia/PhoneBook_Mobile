package ui_mobile;

import config.AppiumConfig;
import dto.User;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

public class DataPickerTests extends AppiumConfig {
    ContactsScreen contactsScreen;

    User qa_user = User.builder()
            .username("qa_user_qwerty@mail.com")
            .password("Password123!")
            .build();
    @BeforeMethod
    public void login(){
        new SplashScreen(driver);
        new AuthenticationScreen(driver)
                .typeLoginForm(qa_user);
        contactsScreen = new ContactsScreen(driver);
    }

    @Test
    public void datePickerPositiveTest(){
        contactsScreen.clickBtnMoreOptions();
        contactsScreen.clickBtnDatePicker()
                .clickBtnChangeDate();
        ;
    }
}
