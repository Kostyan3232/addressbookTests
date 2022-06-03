package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupPage() {
        click(By.linkText("groups"));
    }

    public void gotoAllNewPage() {
        click(By.linkText("add new"));
    }


    public void returnHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void logOut() {
        click(By.linkText("Logout"));
    }

    public void gotoHomePage() {
        if (isElementPresent(By.name("maintable"))) {
            return;
        }
        click(By.xpath("//a[@href='./']"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }
}