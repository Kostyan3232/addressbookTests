package ru.stqa.pft.mantis.appmanager;

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

import static org.openqa.selenium.remote.BrowserType.*;


public class ApplicationManager {
    private final String browser;
    public WebDriver wd;
    private final Properties properties;


    public ApplicationManager(String browser) {
        this.browser = browser;
        properties =  new Properties();


    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if(Objects.equals(browser, FIREFOX)){
            wd = new FirefoxDriver();
        }else  if (Objects.equals(browser, CHROME)){
            wd = new ChromeDriver();
        }else if (Objects.equals(browser, EDGE)){
            wd = new EdgeDriver();
        }
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseURL"));

    }



    public void stop() {
        wd.quit();
    }

}
