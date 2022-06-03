package ru.stqa.pft.addressbook.Test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

public class UpdateContactTest extends TestBase{
    @BeforeMethod
    public  void ensurePreconditions(){
        app.Contact().gotoHomePage();
        if (!app.Contact().isThereAContact()){
            app.Contact().createContact(new ContactData().withFirstname("Ttttt").
                    withMiddlename("YUj").withLastname("Yghgfh").withAddres("Russia").
                    withHomephone("558899").withMobile("+79532559944").withWorkphone("555588").withEmail("fdsfsdfsdf"));
        }
    }
    @Test
    public void testUpdateContact() {
        Contacts before = app.Contact().ContactAll();
        ContactData modefiedCnt = before.iterator().next();
        ContactData contact = new ContactData().withId(modefiedCnt.getId()).withFirstname("Ttttt").
                withMiddlename("fdsfdsf").withLastname("Yghgfh").withAddres("Russia").
                withHomephone("558899").withMobile("79532559944").withEmail("fsdfsdfdf").withWorkphone("555588");
        app.Contact().modifycontact(contact);
        Contacts after = app.Contact().ContactAll();
        Assert.assertEquals(after.size(),before.size());

        before.remove(modefiedCnt);
        before.add(contact);
        ///Comparator<? super ContactDate> byfirst = Comparator.comparing(ContactDate::getFirstname);
        //before.sort(byfirst);
        //after.sort(byfirst);
        //Assert.assertEquals(before,after);
        //MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modefiedCnt).withAdded(contact)));

    }


}

