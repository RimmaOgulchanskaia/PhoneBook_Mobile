package ui_mobile;

import config.AppiumConfig;
import dto.Contact;
import dto.ContactsDto;
import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactsScreen;
import screens.ErrorScreen;
import screens.SplashScreen;

import java.util.Arrays;

import static utils.ContactFactory.*;
import static utils.GetAllUserContactsApi.*;

public class EditContactTests extends AppiumConfig {
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
    public void editContactPositiveTestApi(){
        Contact contact = createPositiveContact();
        contactsScreen.swipeLeftToRight()
                .editContact(contact)
        ;
        ContactsDto contactsDto = getAllUserContactsApi(qa_user);
        boolean flag = false;
        for (Contact contact1 : contactsDto.getContacts()){
            if(contact1.equals(contact)){
                flag=true;
            }
        }
        Assert.assertTrue(flag);
    }

    @Test
    public void editContactPositiveTest(){
        contactsScreen.swipeLeftToRight()
                .editContact(createPositiveContact());
    }

    @Test
    public void editContactNegativeTest_WrongEmail(){
        contactsScreen.swipeLeftToRight()
                .editContact(createNegativeContact_WrongEmail("Rrr@"));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("email=must be a well-formed email address"));

    }
    @Test
    public void editContactNegativeTest_WrongEmail2(){
        contactsScreen.swipeLeftToRight()
                .editContact(createNegativeContact_WrongEmail("@gmail.com"));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("email=must be a well-formed email address"));

    }

    @Test
    public void editContactNegativeTest_WrongEmail3(){
        contactsScreen.swipeLeftToRight()
                .editContact(createNegativeContact_WrongEmail("Rimmagmail.com"));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("email=must be a well-formed email address"));

    }

    @Test
    public void editContactNegativeTest_EmptyEmail(){
        contactsScreen.swipeLeftToRight()
                .editContact(createNegativeContact_WrongEmail(" "));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("email=must be a well-formed email address"));

    }

    @Test
    public void editContactNegativeTest_WrongName(){
        contactsScreen.swipeLeftToRight()
                .editContact(createNegativeContact_WrongName(""));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("name=must not be blank, email=must be a well-formed email address"));

    }

    @Test
    public void editContactNegativeTest_WrongLastName(){
        contactsScreen.swipeLeftToRight()
                .editContact(createNegativeContact_WrongLastName(""));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("lastName=must not be blank, email=must be a well-formed email address"));

    }
    @Test
    public void editContactNegativeTest_WrongPhone(){
        contactsScreen.swipeLeftToRight()
                .editContact(createNegativeContact_WrongPhone(""));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("phone=Phone number must contain only digits! And length min 10, max 15!, email=must be a well-formed email address"));

    }

    @Test
    public void editContactNegativeTest_WrongAddress(){
        contactsScreen.swipeLeftToRight()
                .editContact(createNegativeContact_WrongAddress(""));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("address=must not be blank, email=must be a well-formed email address"));

    }


}