package testscripts;

import org.testng.annotations.Test;
import page.BaseClass;
import page.LoginPage;
import page.RegisterAccount;

public class TC_LF_001 extends BaseTest{


    @Test
    public void TC_LF_001(){

        String
                email = BaseClass.getValue("TC_LF_001","email"),pass = BaseClass.getValue("TC_LF_001","password");


        LoginPage lp = new LoginPage(driver);
        lp.navigateToLoginPage();
        lp.validateLogin(email,pass);
        lp.validateGroupList();


    }
}
