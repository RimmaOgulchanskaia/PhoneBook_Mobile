package screens;

import dto.Contact;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditContactScreen extends BaseScreen {
    public EditContactScreen(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.sheygam.contactapp:id/inputName")
    WebElement inputName;
    @FindBy(id = "com.sheygam.contactapp:id/inputLastName")
    WebElement inputLastName;
    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    WebElement inputEmail;
    @FindBy(id = "com.sheygam.contactapp:id/inputPhone")
    WebElement inputPhone;
    @FindBy(id = "com.sheygam.contactapp:id/inputAddress")
    WebElement inputAddress;
    @FindBy(id = "com.sheygam.contactapp:id/inputDesc")
    WebElement inputDescription;
    @FindBy(id = "com.sheygam.contactapp:id/updateBtn")
    WebElement btnUpdate;

    public void editContact(Contact contact) {
        inputName.sendKeys(contact.getName());
        inputLastName.sendKeys(contact.getLastName());
        inputEmail.sendKeys(contact.getEmail());
        inputPhone.sendKeys(contact.getPhone());
        inputAddress.sendKeys(contact.getAddress());
        inputDescription.sendKeys(contact.getDescription());
        btnUpdate.click();
    }
}