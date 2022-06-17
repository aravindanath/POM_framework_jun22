package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BaseClass{


    public LoginPage(WebDriver driver) {
        super(driver);
    }

// Locators / / Object Repo

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(xpath = "(//a[text()='Register'])[1]")
    WebElement registerButton;


    @FindBy(xpath = "//div[@class='list-group']/a")
    List<WebElement> listGroup;



    @FindBy(id ="input-email")
    WebElement emailTextField;

    @FindBy(id ="input-password")
    WebElement passwordTextField;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement loginLink;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginbutton;




    public void validateGroupList(){
        System.out.println("Total Group: "+ listGroup.size());
        for(WebElement element : listGroup){
          System.out.println(element.getText());
        }
    }

    public void navigateToLoginPage(){
        myAccount.click();
        loginLink.click();
    }


    public void validateLogin(String email, String password){
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        loginbutton.click();
    }


}
