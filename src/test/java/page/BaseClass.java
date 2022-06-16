package page;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class BaseClass {

    protected  WebDriver driver;


    public BaseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public static String getValue(String key){
        String path =   System.getProperty("user.dir")+ File.separator+"config.properties";
        String val = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fis);
            val = prop.getProperty(key);
        }catch (Exception e){

        }
        return val;
    }



    public static void moveTOElement(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();
    }

    public static void click(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.click(element).build().perform();
    }

    public static void dragAnddrop(WebDriver driver, WebElement element1,WebElement element2 ){
        Actions act = new Actions(driver);
        act.dragAndDrop(element1,element2).build().perform();
    }

    public static void rightClick(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.contextClick(element).build().perform();
    }



    public static void scroll(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }


    public static void alertAccept(WebDriver driver){
        Alert at =  driver.switchTo().alert();
        System.out.println(at.getText());
        at.accept();
    }


    public static void alertDismiss(WebDriver driver){
        Alert at =  driver.switchTo().alert();
        System.out.println(at.getText());
        at.dismiss();
    }


    public static void alertAccept(WebDriver driver,String text){
        Alert at =  driver.switchTo().alert();
        System.out.println(at.getText());
        at.sendKeys(text);
        at.accept();
    }


    public static void takeScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot srcShot = (TakesScreenshot) driver;
        File src =  srcShot.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshot.png");
        FileUtils.copyFile(src,dest);
    }


    public static void selectByText(WebElement element, String text){
        Select sel = new Select(element);
        sel.selectByVisibleText(text);

    }


    public static void selectByValue(WebElement element, String text){
        Select sel = new Select(element);
        sel.selectByValue(text);

    }


    public static void selectByindex(WebElement element, int index){
        Select sel = new Select(element);
        sel.selectByIndex(index);

    }


    public static void waitForElement(long sec){
        try{
            Thread.sleep(sec);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static String generateFirstName(){

        Faker faker = new Faker(new Locale("en-IND"));
        String fn = faker.name().firstName();
        return fn;
    }

    public static String generateLastName(){

        Faker faker = new Faker(new Locale("en-IND"));
        String fn = faker.name().lastName();
        return fn;
    }

    public static String generateEmail(){

        Faker faker = new Faker(new Locale("en-IND"));
        String fn = faker.name().fullName();
        return fn.trim().replace(" ","").replace(".","")+"@testmail.com";
    }

    public static String generateMobileNumber(){
        Faker faker = new Faker(new Locale("en-IND"));
        String fn = faker.number().digits(10);
        return fn;
    }


}
