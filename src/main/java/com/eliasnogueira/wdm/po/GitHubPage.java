package com.eliasnogueira.wdm.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubPage {

    @FindBy(css = "[itemprop='name'] > a")
    private WebElement projectLink;

    public GitHubPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getProjectReferenceLink() {
        return projectLink.getAttribute("href");
    }

    public String getProjectText() {
        return projectLink.getText();
    }
}
