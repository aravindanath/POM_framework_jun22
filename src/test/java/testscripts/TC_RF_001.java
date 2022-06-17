package testscripts;

import org.testng.annotations.Test;
import page.BaseClass;
import page.RegisterAccount;

public class TC_RF_001 extends BaseTest{


    @Test
    public void TC_RF_001(){

        String fn = BaseClass.generateFirstName(), ln = BaseClass.generateLastName(),
                tel = BaseClass.generateMobileNumber(),
                email = BaseClass.generateEmail(),
                pw = fn, cpw = fn;

        RegisterAccount ra = new RegisterAccount(driver);
        ra.navigateToRegPage();
        ra.enterMandatoryField(fn,ln,email,tel,pw,cpw);
        ra.agreePrivacyPolicy();
        ra.clickOnContinueButton();


    }
}
