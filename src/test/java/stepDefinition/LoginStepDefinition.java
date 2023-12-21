package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;



@CucumberOptions(glue = {"<stepDefinition>", "<stepDefinition>", "<etc>"})

public class LoginStepDefinition {
    WebDriver driver=null;
    LoginPage login;
@Given("user open browser")
    public void user_open_browser() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Hazem Alaa Mostafa\\IdeaProjects\\Learning\\src\\Browsers\\chromedriver.exe");
    driver =new ChromeDriver();
    driver.navigate().to("https://the-internet.herokuapp.com/login");
    login =new LoginPage(driver);

    Thread.sleep(3000);


}
@And("user navigates to login page")
    public  void user_navigates(){
    driver.navigate().to("https://the-internet.herokuapp.com/login");

}
@When("user enter valid username and password")
    public void user_valid(){
    login.LoginSteps("tomsmith","SuperSecretPassword!");
}
@When("user enter invalid username and password")
      public void invalid_data(){
    login.LoginSteps("invalid","invalid");

}
@And("user click on login button")
    public void login_button() throws InterruptedException {
    login.passwordEle().sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    }

    @Then("user login successfully")
    public void user_success(){
        String expectedvalue= "You logged into a secure area!";
        String actualvalue= driver.findElement(login.flashEle()).getText();
        Assert.assertTrue(actualvalue.contains(expectedvalue));

    }
    @Then("user could not login")
    public void wrong_success(){
        String expectedvalue= "Your username is invalid!";
        String actualvalue= driver.findElement(login.flashEle()).getText();
        Assert.assertTrue(actualvalue.contains(expectedvalue));

    }
    @And("go to home page")
    public void home_page(){
    Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");

    }
    @After()
    public void close_browser(){
    driver.quit();
    }

}
