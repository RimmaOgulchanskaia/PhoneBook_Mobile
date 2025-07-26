package ui_mobile;

import config.AppiumConfig;
import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

public class LoginTests extends AppiumConfig {

    AuthenticationScreen authenticationScreen;

    @BeforeMethod
    public void goToAuthScreen(){
        new SplashScreen(driver);
        authenticationScreen=new AuthenticationScreen(driver);
    }

    @Test
    public void loginPositiveTest(){
        authenticationScreen.typeLoginForm(User.builder()
                        .username("qa_mail@mail.com")
                        .password("Qwerty123!").build());
        Assert.assertTrue(new ContactsScreen(driver).validateContactsScreenOpen("Contact list"));

    }

    @Test
    public void loginNegativeTest_WrongUserName(){
        authenticationScreen.typeLoginForm(User.builder()
                .username("qa_mailmail.com")
                .password("Qwerty123!").build());
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("Login or Password incorrect"));


    }

    @Test
    public void loginNegativeTest_WrongPassword(){
        authenticationScreen.typeLoginForm(User.builder()
                .username("qa_mailmail.com")
                .password("Qwerty123").build());
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("Login or Password incorrect"));


    }


}
