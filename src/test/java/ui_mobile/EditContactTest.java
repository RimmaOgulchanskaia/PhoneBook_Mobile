package ui_mobile;

import config.AppiumConfig;
import dto.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactsScreen;
import screens.EditContactScreen;
import screens.SplashScreen;
import static utils.ContactFactory.*;

public class EditContactTest extends AppiumConfig {
    ContactsScreen contactsScreen;




    @BeforeMethod
    public void login(){
        new SplashScreen(driver);
        new AuthenticationScreen(driver)
                .typeLoginForm(User.builder()
                        .username("qa_mail@mail.com")
                        .password("Qwerty123!")
                        .build());
        contactsScreen=new ContactsScreen(driver);

    }
    @Test
    public void editContactPositiveTest(){
        contactsScreen.swipeLeftToRight()
        .editContact(createPositiveContact());
    }
}
