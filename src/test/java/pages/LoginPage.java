package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    //use page factory
    @FindBy(id="username")
    WebElement usernamepf;
    @FindBy (name="password")
    WebElement passwordpf;
    public WebElement usernameEle(){

        return  driver.findElement(By.id("username"));

    }
    public WebElement passwordEle(){

        return  driver.findElement(By.name("password"));

    }
    public By flashEle(){
        return By.id("flash");
    }
    public By cssSelectorEle(){
        return By.cssSelector("a[href=\"/logout\"]");
    }
    public void LoginSteps(String username,String password){
        usernamepf.clear();
        usernameEle().sendKeys(username);
        passwordpf.sendKeys(password);

    }
}
