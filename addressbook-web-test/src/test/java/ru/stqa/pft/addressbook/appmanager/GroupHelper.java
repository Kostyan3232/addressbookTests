package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;

import java.util.List;


public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupDate) {
        type(By.name("group_name"), groupDate.getName());
        type(By.name("group_header"), groupDate.getHeadr());
        type(By.name("group_footer"), groupDate.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectGroup() {
        click(By.name("delete"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.xpath("//input[@name = 'selected[]']")).get(index).click();
       // click(By.xpath("//input[@name = 'selected[]']"));
    }
    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value = '" + id +"']")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));

    }


    public void submitGroupModification() {
        click(By.name("update"));
    }

    private void typefirstname(String locator, String text) {
        if (text != null) {
            String existingText = wd.findElement(By.name(locator)).getAttribute("value");
            if (!text.equals(existingText)) {
                wd.findElement(By.name(locator)).click();
                wd.findElement(By.name(locator)).clear();
                wd.findElement(By.name(locator)).sendKeys(text);
            }
        }
    }

    public void createGroup(GroupData group) {
       initGroupCreation();
       fillGroupForm(group);
       submitGroupCreation();
       groupCache = null;
       returnToGroupPage();
    }
    public void modifyGroup( GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }
    public void delete(int index) {
        selectGroup(index);
        deleteSelectGroup();
        returnToGroupPage();
    }




    public boolean isThereAgroup() {
        return isElementPresent(By.xpath("//input[@name = 'selected[]']"));
    }

    private void returnHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void PressEnterNewContact() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public boolean isThereContact() {
        return isElementPresent(By.xpath("//input[@name='selected[]']"));
    }

    ///public int getGroupCount() {
        //return wd.findElements(By.xpath("//input[@name = 'selected[]'] ")).size();

    //}

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }
        private Groups  groupCache = null;

    public Groups all() {
        if (groupCache !=null){
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }

    public void delete(GroupData deletedGroup) {
        selectGroupById(deletedGroup.getId());
        deleteSelectGroup();
        groupCache = null;
        returnToGroupPage();

    }
}