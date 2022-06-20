package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void gotoAllNewPage() {
        click(By.linkText("add new"));
    }
    public void gotoHomePage() {
        if (isElementPresent(By.name("maintable"))) {
            return;
        }
        click(By.xpath("//a[@href='./']"));
    }


    public void returnHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void PressEnterNewContact() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public boolean isThereContact() {
        return isElementPresent(By.xpath("//input[@name='selected[]']"));
    }
    public void createContact(ContactData contact) {
        gotoAllNewPage();
        fillNewContact(contact);
        PressEnterNewContact();
        //contactCache = null;
        returnHomePage();

    }
    public void fillNewContact(ContactData contactDate) {
        typefirstname("firstname", contactDate.getFirstname());
        typefirstname("middlename", contactDate.getMiddlename());
        typefirstname("lastname", contactDate.getLastname());
        typefirstname("address", contactDate.getAddress());
        typefirstname("home", contactDate.getHomephone());
        typefirstname("mobile", contactDate.getMobile());
        typefirstname("work", contactDate.getWorkPhone());
        typefirstname("email", contactDate.getEmail());
        //attach("photo", contactDate .getPhoto());
    }

    public void typefirstname(String locator, String text) {
        if (text != null) {
            String existingText = wd.findElement(By.name(locator)).getAttribute("value");
            if (!text.equals(existingText)) {
                wd.findElement(By.name(locator)).click();
                wd.findElement(By.name(locator)).clear();
                wd.findElement(By.name(locator)).sendKeys(text);
            }
        }
    }
    public void attach(String locator, File file) {
        if (file != null) {
                wd.findElement(By.name(locator)).sendKeys(file.getAbsolutePath());
        }

    }

    public void SelectContact(int index) {
        wd.findElements(By.xpath("//input[@name='selected[]']")).get(index).click();
        //click(By.xpath("//input[@id][1]"));
    }
    public void SelectContactById(int id) {
        wd.findElement(By.xpath("//input[@value='"+ id +"']")).click();
        //click(By.xpath("//input[@id][1]"));
    }
    public void deleteSelectContact() {
        click(By.xpath("//input[@value='Delete']"));
    }
    public void editContactLinkById(int id) {
        wd.findElement(By.xpath("//img[@alt='Edit']")).click();
        //click(By.xpath("//a[@href='edit.php?id=64']"));
    }
    public void updateContactLink() {
        click(By.xpath("//input[@name = 'update'][2]"));
    }
    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();

    }

    public Contacts ContactAll() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry'] "));
        for (WebElement element : elements){
            String firstname = element.findElement(By.xpath("./td[3]")).getText();
            String lastname =  element.findElement(By.xpath("./td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String address = element.findElement(By.xpath("//tr[@name='entry']/td[4]")).getText();
            //String phones = element.findElement(By.xpath("//tr[@name='entry']/td[6]")).getText();
            String email = element.findElement(By.xpath("//tr[@name='entry']/td[5]")).getText();
            //String detail = element.findElement((By.xpath("//div[@id='content']"))).getText();
            String phone = element.findElement(By.xpath("//tr[@name='entry']/td[6]")).getText();
            String[] phones = phone.split("\n");

            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAddres(address);
                   // withHomephone(phones[0]).withMobile(phones[1]).withWorkphone(phones[2]).withAddres(address).withEmail(email);
            contacts.add(contact);
        }
        return contacts;
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }
    public void modifycontact( ContactData contact) {
        editContactLinkById(contact.getId());
        fillNewContact(contact);
        updateContactLink();
        //contactCache = null;
        gotoHomePage();
    }


    public void deletecont(ContactData deletedCnt) {
        SelectContactById(deletedCnt.getId());
        deleteSelectContact();
        wd.switchTo().alert().accept();
        //contactCache = null;
        gotoHomePage();
    }
    private void initContactModificationById(int id) {
        wd.findElement(By.xpath("//img[@alt='Edit']")).click();

    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).
                withLastname(lastname).withHomephone(home).withMobile(mobile).withWorkphone(work).withAddres(address).withEmail(email);
    }
    public void ContactAddInGroup(int id,String name) {
        wd.findElement(By.xpath("//input[@value='"+ id +"']")).click();
        new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(name);
        click(By.name("add"));
    }


    public void ContactDelToGroup(int id, String name) {
            //new Select(wd.findElement(By.name("group"))).selectByVisibleText(name);
            //wd.findElement(By.xpath("//input[@value='"+ id +"']")).click();
        wd.findElement(By.xpath(String.format("//a[@href = 'view.php?id=%s']",id))).click();
        wd.findElement(By.xpath(" //a[@href='./index.php?group=226']")).click();
       //wd.findElement(By.xpath(String.format(" //a[@href='./index.php?group=%s']",id))).click();
        wd.findElement(By.xpath("//input[@name='remove']")).click();
        //a[@href='./index.php?group=226']
        //a[@href='view.php?id=363']


    }

}
