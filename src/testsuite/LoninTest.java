package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoninTest extends BaseTest {
    String baseUrl ="https://courses.ultimateqa.com/";
    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
//lolocate signin button
        WebElement singInBtn = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        singInBtn.click();
        //This is requirement
        String expectedText = "Welcome Back!";
        //actual text
        WebElement actualTextElement = driver.findElement(By.tagName("h1"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        //locate sign in
        WebElement singInBtn = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        singInBtn.click();
        //locate username field
        WebElement usernameField = driver.findElement(By.id("user[email]"));
        usernameField.sendKeys("abc@yahoo.com");
        //locate password Field
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("123456");
        // locate Click button
        WebElement clickBtn = driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        clickBtn.click();
        // this is requirement
        String expectedMessage = "Invalid email or password.";
        //actual Text
        WebElement actualMessageElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }


}
