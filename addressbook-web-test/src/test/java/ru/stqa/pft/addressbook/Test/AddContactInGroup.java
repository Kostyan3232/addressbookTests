package ru.stqa.pft.addressbook.Test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

public class AddContactInGroup extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.Group().createGroup(new GroupData().withName("Test2"));
        }
        if (app.db().contacts().size() == 0) {
            app.goTo().gotoHomePage();
            app.Contact().createContact(new ContactData().withFirstname("Yhhh").
                    withMiddlename("Wqqj").withLastname("GR").withAddres("Russia").
                    withHomephone("57-82-99").withMobile("+79432459947").withWorkphone("51-51-88").withEmail("ffsdfsdf"));
        }
    }

    @Test
    public void testContactAddGroup() {
        Contacts before = app.db().contacts();
        Groups beforeGroup = app.db().groups();
        app.goTo().gotoHomePage();
        ContactData contactingroup = before.iterator().next();
        GroupData groupForContact = beforeGroup.iterator().next();
        app.Contact().ContactAddInGroup(contactingroup.getId(),groupForContact.getName());
        Contacts after = app.db().contacts();
        Groups afterGroup = app.db().groups();
        MatcherAssert.assertThat((after.size()), CoreMatchers.equalTo(before.size()));
       // MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(beforeGroup).withAdded(group)));


    }


}