package ui_mobile;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactsScreen;
import screens.ErrorScreen;
import screens.SplashScreen;
import static utils.UserFabric.*;

public class RegistrationTests extends AppiumConfig {

    AuthenticationScreen authenticationScreen;



    @BeforeMethod
    public void goToAuthScreen(){
        new SplashScreen(driver);


    }
    @Test
    public void registrationPositiveTest(){
        authenticationScreen=new AuthenticationScreen(driver);
        authenticationScreen.typeRegistrationForm(createUser());
        Assert.assertTrue( new ContactsScreen(driver).validateContactsScreenOpen("Contact list"));

    }
    @Test
    public void registrationNegativeTestWrongEmail(){
        authenticationScreen=new AuthenticationScreen(driver);
        authenticationScreen.typeRegistrationForm(createUserWrongEmail("admin@"));
        Assert.assertTrue( new ContactsScreen(driver).validateContactsScreenOpen("Authentication"));

    }

    @Test
    public void registrationNegativeTestWrongEmailTest2(){
        authenticationScreen=new AuthenticationScreen(driver);
        authenticationScreen.typeRegistrationForm(createUserWrongEmail("admin@"));
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("must be a well-formed email address"));

    }

    @Test
    public void registrationNegativeTestWrongEmailDublicateEmail(){
        authenticationScreen=new AuthenticationScreen(driver);
        authenticationScreen.typeRegistrationForm(createUserWrongEmail("qa_mail@mail.com"));
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("User already exists"));

    }

    @Test
    public void registrationNegativeTestWrongPassword(){
        authenticationScreen=new AuthenticationScreen(driver);
        authenticationScreen.typeRegistrationForm(createUserWrongPassword("Admin"));
        Assert.assertTrue( new ContactsScreen(driver).validateContactsScreenOpen("Authentication"));

    }

    @Test
    public void registrationNegativeTestWrongPasswordTest2(){
        authenticationScreen=new AuthenticationScreen(driver);
        authenticationScreen.typeRegistrationForm(createUserWrongPassword("Admin"));
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("Must contain at least 1 uppercase letter"));


    }

}
