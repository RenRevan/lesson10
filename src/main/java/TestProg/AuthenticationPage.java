package TestProg;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage {

    private static final String AUTHENTICATION_PAGE_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private WebDriver driver;




    public AuthenticationPage(WebDriver driver){
        this.driver = driver;
    }

    public AuthenticationPage openPage(){
        this.driver.navigate().to(AUTHENTICATION_PAGE_URL);
        return this;
    }

    public AuthenticationPage enterValue(By elem, String value){
        this.driver.findElement(elem).clear();
        this.driver.findElement(elem).sendKeys(value);
        return this;
    }

    public AuthenticationPage clickSubmitButton(By btn){
        this.driver.findElement(btn).click();
        return this;
    }





}
