package ui_mobile;

import config.AppiumConfig;
import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

import static utils.ContactFactory.*;


public class AddNewContactTest extends AppiumConfig {
    ContactsScreen contactsScreen;
    AddNewContactScreen addNewContactScreen;


    @BeforeMethod
    public void login(){
        new SplashScreen(driver);
        new AuthenticationScreen(driver)
                .typeLoginForm(User.builder()
                        .username("qa_mail@mail.com")
                        .password("Qwerty123!")
                        .build());
        contactsScreen=new ContactsScreen(driver);
        contactsScreen.clickbtnPlus();
        addNewContactScreen = new AddNewContactScreen(driver);
    }
    @Test
    public void addNewContactPositiveTest(){
        addNewContactScreen.typeContactForm(createPositiveContact());
        Assert.assertTrue(addNewContactScreen.validateMessageSucceess("Contact was added!"));

    }
    @Test
    public void addNewContactNegativeTest_WrongName(){
        addNewContactScreen.typeContactForm(createNegativeContact_WrongName("   "));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("must not be blank"));


    }

    @Test
    public void addNewContactNegativeTest_WrongLastName(){
        addNewContactScreen.typeContactForm(createNegativeContact_WrongLastName("   "));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("must not be blank"));


    }

    @Test
    public void addNewContactNegativeTest_WrongEmail(){
        addNewContactScreen.typeContactForm(createNegativeContact_WrongEmail(""));



    }
    @Test
    public void addNewContactNegativeTest_WrongPhone(){
        addNewContactScreen.typeContactForm(createNegativeContact_WrongPhone(""));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("Phone number must contain only"));


    }

    @Test
    public void addNewContactNegativeTest_WrongPhone2(){
        addNewContactScreen.typeContactForm(createNegativeContact_WrongPhone("Aa123"));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("Phone number must contain only"));


    }

    @Test
    public void addNewContactNegativeTest_WrongPhone3(){
        addNewContactScreen.typeContactForm(createNegativeContact_WrongPhone("#@78"));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("Phone number must contain only"));


    }


    @Test
    public void addNewContactNegativeTest_Address(){
        addNewContactScreen.typeContactForm(createNegativeContact_WrongAddress(""));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("must not be blank"));


    }


}
