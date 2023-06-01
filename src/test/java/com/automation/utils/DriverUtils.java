package com.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;


public class DriverUtils {
    static WebDriver driver;


    public static void createDriver(Method test) {


        if (PropertyReader.getProperty("application.host").equalsIgnoreCase("local")) {

            if (driver == null) {
                switch (PropertyReader.getProperty("application.browser")) {


                    case "edge" -> {
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                    }
                    case "safari" -> {
                        WebDriverManager.safaridriver().setup();
                        driver = new SafariDriver();
                    }
                    case "firefox" -> {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                    }
                    default -> {

                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("disable-infobars");
                        options.addArguments("--disable-save-password-bubble");
                        options.addArguments("--disable-autofill-keyboard-accessory-view");
                        options.addArguments("--disable-profile-password-manager");
                        options.addArguments("--disable-features");
                        options.addArguments("--disable-autofill-keyboard-accessory-view");
                        options.addArguments("--disable-save-password-bubble");
                        options.addArguments("disable-features=Autofill");
                        options.addArguments("--disable-popup-blocking");
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver(options);


                    }
                }
            }


        } else if (PropertyReader.getProperty("application.host").equalsIgnoreCase("saucelabs")) {

            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username", PropertyReader.getProperty("sauce.username"));
            sauceOptions.setCapability("accessKey", PropertyReader.getProperty("sauce.accessKey"));

            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("browserName", PropertyReader.getProperty("sauce.browserName"));
            capabilities.setCapability("browserVersion", PropertyReader.getProperty("sauce.browserVersion"));
            capabilities.setCapability("platformName", PropertyReader.getProperty("sauce.platformName"));
            capabilities.setCapability("sauce:options", sauceOptions);

            try {

                driver = new RemoteWebDriver(new URL(PropertyReader.getProperty("sauce.urlWest")), capabilities);
                ((JavascriptExecutor) driver).executeScript("sauce:job-name=" + test.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get(PropertyReader.getProperty("getStarted.url"));
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
