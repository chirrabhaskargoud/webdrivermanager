package com.eliasnogueira.wdm;

import com.eliasnogueira.wdm.po.GitHubPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GithubWDMPageTest {

    private static WebDriver driver;
    private static final String URL = "https://github.com/bonigarcia/webdrivermanager";

    @BeforeAll
    static void webdrivermanagerSetup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        driver = new ChromeDriver(options);

        driver.get(URL);
    }

    @AfterAll
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
