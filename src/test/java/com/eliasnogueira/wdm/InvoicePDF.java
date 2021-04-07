package com.eliasnogueira.wdm;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eliasnogueira.wdm.po.GitHubPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

class InvoicePDF {

    private static WebDriver driver;
    private static final String URL = "https://github.com/bonigarcia/webdrivermanager";

    @BeforeMethod
    static void webdrivermanagerSetup() {
      try {
        WebDriverManager.chromedriver().setup();        
        DesiredCapabilities capability = new DesiredCapabilities();
        ChromeOptions chromeOpts = new ChromeOptions();
        //chromeOpts.addArguments("--dns-prefetch-disable");
        capability=DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setCapability(ChromeOptions.CAPABILITY, chromeOpts);
        chromeOpts.setHeadless(true);
        driver = new ChromeDriver(chromeOpts);
        driver.get(URL);
        Thread.sleep(10000);
      
        System.out.println("********************** Page title is **********************"+driver.getTitle());
        System.out.println("************************ Invoice PDF Test Execution completed Successfully *************************************");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    @AfterMethod
    static void quitBrowser() {
        driver.quit();
    }

    @Test
    void checkDescription() {
        GitHubPage page = new GitHubPage(driver);

        assertEquals("webdrivermanager", page.getProjectText());
        assertEquals(URL, page.getProjectReferenceLink());
    }
}
