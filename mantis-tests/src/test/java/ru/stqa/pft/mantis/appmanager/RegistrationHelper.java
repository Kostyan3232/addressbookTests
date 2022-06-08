package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper {
    private final ApplicationManager app;
    private WebDriver wd;
    public RegistrationHelper(ApplicationManager app) {
        this.app = app;
        wd= app.getDriver();
    }

    public void start(String username, String email) {
       wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        wd.findElement(By.name("username")).sendKeys(username);
        wd.findElement(By.name("email")).sendKeys(email);
        click(By.xpath("//input[@class='button']"));

    }

    private void click(By xpath) {

    }

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"),password);
        type(By.name("password_confirm"),password);
        click(By.cssSelector("input=[Uppdate_User]")) ;
    }

    private void type(By password, String password1) {

    }
}
