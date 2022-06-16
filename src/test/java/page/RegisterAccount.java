package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccount extends BaseClass{


    public RegisterAccount(WebDriver driver) {
        super(driver);
    }

// Locators / / Object Repo

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(xpath = "(//a[text()='Register'])[1]")
    WebElement registerButton;

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstnameText;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastnameText;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailText;

    @FindBy(xpath = "//input[@name='telephone']")
    WebElement telephoneText;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement passwordText;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement confirmPasswordText;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkBox;



    public void enterMandatoryField(String fn, String ln, String em, String tel, String pw, String cpw){

        firstnameText.sendKeys(fn);
        lastnameText.sendKeys(ln);
        telephoneText.sendKeys(tel);
        emailText.sendKeys(em);
        passwordText.sendKeys(pw);
        confirmPasswordText.sendKeys(cpw);

    }

    public void navigateToRegPage(){

        myAccount.click();
        waitForElement(2000);
        registerButton.click();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }



}
