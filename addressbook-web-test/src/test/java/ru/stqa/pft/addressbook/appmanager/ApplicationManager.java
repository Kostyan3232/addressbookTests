package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import static io.opentelemetry.semconv.trace.attributes.SemanticAttributes.NetHostConnectionSubtypeValues.EDGE;
import static org.openqa.selenium.remote.BrowserType.*;


public class ApplicationManager {
    public WebDriver wd;

    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private  NavigationHelper navigationHelper;
    private  GroupHelper groupHelper;
    private String browser;
    private final Properties properties;
    private DbHelper dbHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties =  new Properties();


    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        dbHelper = new DbHelper();

        if(Objects.equals(browser, FIREFOX)){
            wd = new FirefoxDriver();
        }else  if (Objects.equals(browser, CHROME)){
            wd = new ChromeDriver();
        }else if (Objects.equals(browser, EDGE)){
            wd = new EdgeDriver();
        }
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseURL"));
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper.login(properties.getProperty("web.adminlogin"), properties.getProperty("web.adminpassword"));

    }



    public void stop() {
        wd.quit();
    }

    public GroupHelper Group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
    public ContactHelper Contact() {
        return contactHelper;
    }
    public DbHelper db(){
        return dbHelper;
    }
}
