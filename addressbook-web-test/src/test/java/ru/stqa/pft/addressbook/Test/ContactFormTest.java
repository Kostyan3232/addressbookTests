package ru.stqa.pft.addressbook.Test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactFormTest extends TestBase{
    @Test
   public void testContactPhone(){
        app.goTo().gotoHomePage();
        ContactData contact = app.Contact().ContactAll().iterator().next();
        ContactData contactInfoFromEditForm = app.Contact().infoFromEditForm(contact);
        MatcherAssert.assertThat(contact.getHomephone(), CoreMatchers.equalTo(cleaned(contactInfoFromEditForm.getHomephone())));
        MatcherAssert.assertThat(contact.getMobile(), CoreMatchers.equalTo(cleaned(contactInfoFromEditForm.getMobile())));
        MatcherAssert.assertThat(contact.getWorkPhone(), CoreMatchers.equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
        //MatcherAssert.assertThat(contact.getAddres(), CoreMatchers.equalTo(contactInfoFromEditForm.getAddres()));
        MatcherAssert.assertThat(contact.getEmail(), CoreMatchers.equalTo(contactInfoFromEditForm.getEmail()));

    }
        public String cleaned(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
        }

}
