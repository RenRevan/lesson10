package TestProg;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage {

    private static final String AUTHENTICATION_PAGE_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private WebDriver driver;
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




    public AuthenticationPage(WebDriver driver){
        this.driver = driver;
    }
    private AuthenticationPage(Builder builder) {
        this.driver = builder.driver;
        enterValue(PERS_INF_FIRST_NAME,builder.persInfoFirstName);
        enterValue(PERS_INF_LAST_NAME,builder.persInfoLastName);
        enterValue(PERS_INF_PASSWORD,builder.persInfoPassword);
        enterValue(ADDRESS_FIRST_NAMED,builder.AddressFirstName);
        enterValue(ADDRESS_LAST_NAME,builder.AddressLastName);
        enterValue(ADDRESS_ADDRESS,builder.AddressAdress);
        enterValue(ADDRESS_CITY,builder.AddressCity);
        enterValue(ADDRESS_POSTAL_CODE,builder.AddressPostalCode);
        enterValue(ADDRESS_MOBILR_PHONE,builder.AddressMobilePhone);
        enterValue(ADDRESS_ALIAS_ADDRESS,builder.AddressAliasAddress);
        enterValue(PERS_INF_FIRST_NAME,builder.persInfoFirstName);
        enterValue(PERS_INF_LAST_NAME,builder.persInfoLastName);
        enterValue(PERS_INF_PASSWORD,builder.persInfoPassword);
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

public  static  class Builder {
    // pers info Parameters
    private final WebDriver driver;
    private  String persInfoFirstName;
    private  String persInfoLastName ;
    private  String persInfoPassword ;
    // al info parameters
    private  String AddressFirstName ;
    private  String AddressLastName ;
    private  String AddressAdress ;
    private  String AddressCity ;
    private  String AddressPostalCode;
    private  String AddressMobilePhone;
    private  String AddressAliasAddress;

public  Builder(WebDriver driver){
    this.driver = driver;

}
    public Builder setpersInfoFirstName(String value){
        this.persInfoFirstName=value;
        return this;
    }
    public Builder setpersInfoLastName(String value){
        this.persInfoLastName=value;
        return this;
    }
    public Builder setpersInfoPassword(String value){
        this.persInfoPassword=value;
        return this;
    }
public Builder setAddressFirstName(String value){
    this.AddressFirstName=value;
    return this;
}
    public Builder setAddressLastName(String value){
        this.AddressLastName=value;
        return this;
    }
    public Builder setAddressAdress(String value){
        this.AddressAdress=value;
        return this;
    }
    public Builder setAddressCity(String value){
        this.AddressCity=value;
        return this;
    }
    public Builder setAddressPostalCode(String value){
        this.AddressPostalCode=value;
        return this;
    }
    public Builder setAddressMobilePhone(String value){
        this.AddressMobilePhone=value;
        return this;
    }
    public Builder setAddressAliasAddress(String value){
        this.AddressAliasAddress=value;
        return this;
    }

    public AuthenticationPage build() {
        return new AuthenticationPage(this);
    }


    }



}
