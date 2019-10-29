package TestProg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class AuthenticationCreate {
    private static ChromeDriver driver;
    private static  AuthenticationPage authPage;
    private static By authCreateEmail = By.id("email_create");
    private static By authCreateSubmit = By.id("SubmitCreate");
    private static  By PERS_INF_FIRST_NAME = By.id("customer_firstname");
    private static  By PERS_INF_LAST_NAME = By.id("customer_lastname");
    private static  By PERS_INF_PASSWORD = By.id("passwd");
    private static  By ADDRESS_FIRST_NAMED = By.id("firstname");
    private static  By ADDRESS_LAST_NAME = By.id("lastname");
    private static  By ADDRESS_ADDRESS = By.id("address1");
    private static  By ADDRESS_CITY = By.id("city");
    private static  By ADDRESS_POSTAL_CODE = By.id("postcode");
    private static  By ADDRESS_MOBILR_PHONE= By.id("phone_mobile");
    private static  By ADDRESS_ALIAS_ADDRESS= By.id("alias");
    private static  By ADDRESS_REGISTER= By.id("submitAccount");
    private static  By ALLERT = By.xpath("//*[@class='alert alert-danger']");


    @BeforeTest
    public static void runDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ирен\\IdeaProjects\\l_SelDriver\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        authPage = new AuthenticationPage(driver);

    }

    @Test
    public static void createAnAccount(){
        authPage.openPage()
                .enterValue(authCreateEmail,"vinnipuh+1@g.com")
                .clickSubmitButton(authCreateSubmit);
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(PERS_INF_FIRST_NAME));
    }
    @Test
    public static void enterPersonalInfo(){
        authPage.enterValue(PERS_INF_FIRST_NAME,"PERS_INF_FIRST_NAME")
                .enterValue(PERS_INF_LAST_NAME,"PERS_INF_LAST_NAME")
                .enterValue(PERS_INF_PASSWORD,"12345678")
                .enterValue(ADDRESS_FIRST_NAMED,"ADDRESS_FIRST_NAMED")
                .enterValue(ADDRESS_LAST_NAME,"ADDRESS_LAST_NAME")
                .enterValue(ADDRESS_ADDRESS,"64/13, Volodymyrska Street")
                .enterValue(ADDRESS_CITY,"Kyiv")
                .enterValue(ADDRESS_POSTAL_CODE,"01601")
                .enterValue(ADDRESS_MOBILR_PHONE,"+80934655725")
                .enterValue(ADDRESS_ALIAS_ADDRESS,"64/13, Volodymyrska Street")
                .clickSubmitButton(ADDRESS_REGISTER);
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(ALLERT));
        Assert.assertTrue(driver.findElement(ALLERT).getText().contains("There are 3 errors"));

    }

    @AfterTest
    public static void closeDriver(){
        driver.close();
    }

//        driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
//        ((ChromeDriver) driver).findElementById("email_create").sendKeys("vinnipuh+1@g.com");
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        ((ChromeDriver) driver).findElementById("SubmitCreate").click();
//        wait.until(ExpectedConditions.visibilityOf(((ChromeDriver) driver).findElementByXPath("//*[@class='page-heading']")));
//
//        System.out.println ( ((ChromeDriver) driver).findElementByXPath("//*[@class='page-heading']").getText()+"  find it");
//
//
//        driver.close();
//    }



}
