package ru.vsprog.seleniumapp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;

public class AppTest {

    @Test
    public void startWebDriver() throws InterruptedException {

        /*
        String myProxy = "proxy.vsushko.ru:8080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, new Proxy().setHttpProxy(myProxy));

        WebDriver driver = new FirefoxDriver(capabilities);
        ProfilesIni profilesIni = new ProfilesIni();
        FirefoxProfile profile = profilesIni.getProfile("vsa");
*/

        HtmlUnitDriver driver = new HtmlUnitDriver();
        driver.setJavascriptEnabled(true);

        driver.get("https://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }

    @Test
    public void openSiteAndClickToLink() {
        ProfilesIni profilesIni = new ProfilesIni();
        FirefoxProfile profile = profilesIni.getProfile("vsa");
        WebDriver driver = new FirefoxDriver(profile);

        driver.get("http://www.google.com");

        Assert.assertTrue("title should start differently", driver.getTitle().startsWith("Selenium Simplified"));
    }

    @Test
    public void openAppAndCheckExistsInitData() throws InterruptedException {
        ProfilesIni profilesIni = new ProfilesIni();
        FirefoxProfile profile = profilesIni.getProfile("vsa");

        WebDriver driver = new FirefoxDriver(profile);
        driver.get("http://192.168.0.1:10000/wps/portal");

        WebElement userId = driver.findElement(By.id("userID"));
        userId.sendKeys("KEY1");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("KEY2");

        WebElement submitButton = driver.findElement(By.className("wpsButtonText"));
        submitButton.submit();

        WebElement sodTab = driver.findElement(By.linkText("SOME_STRING"));
        sodTab.click();

        WebElement gridElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("root-tree-row")));

        // проверки
        assertEquals("SOME_STRING", gridElement.getText());

//        Actions action = new Actions(driver);
//        action.doubleClick(sodTab).build().perform();

        Thread.sleep(10000);


        driver.quit();
    }
    @Test
    public void openGoogleAndSearchString() throws InterruptedException, MalformedURLException {

        HtmlUnitDriver driver = new HtmlUnitDriver(true);
        driver.get("http://www.google.com");
        driver.get(String.valueOf(new URL("http://www.google.com")));
//        driver.setProxy("proxygoogle.com", 8080);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println(driver.getPageSource());
        System.out.println(driver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(driver, 60);


        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q"))); //driver.findElement(By.name("q"));

            element.sendKeys("Java oracle");
        } catch (Exception e) {
            Thread.sleep(1000);
            System.out.println("exception");
        }
//        element.sendKeys("Java oracle");
//        element.submit();

        System.out.println("Page title is: " + driver.getTitle());

//        driver.quit();
    }
}
