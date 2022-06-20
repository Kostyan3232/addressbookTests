package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends HelperBase {
    private WebDriver wd;
    public RegistrationHelper(ApplicationManager app) {
        super(app);
        wd= app.getDriver();
    }

    public void start(String username, String email) {
       wd.get(app.getProperty("web.baseURL") + "/signup_page.php");
        wd.findElement(By.name("username")).sendKeys(username);
        wd.findElement(By.name("email")).sendKeys(email);
        click(By.xpath("//input[@class='button']"));

    }

    public void click(By xpath) {

    }

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"),password);
        type(By.name("password_confirm"),password);
        click(By.cssSelector("input=[Update_User]")) ;
    }

    public void type(By password, String password1) {

    }
}
