package ru.stqa.pft.addressbook.Test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

public class DeleteContafromGrop extends TestBase {
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
        Contacts before = app.db().contacts();
        ContactData contactinGroup = before.iterator().next();
        if (contactinGroup.getGroups().size() == 0) {
            Groups group = app.db().groups();
            GroupData groupForContact = group.iterator().next();
            app.Contact().ContactAddInGroup(contactinGroup.getId(),groupForContact.getName());
            app.goTo().gotoHomePage();
        }

    }

    @Test
    public void deleteContafromGrop() {
        Contacts before = app.db().contacts();
        Groups beforeGroup = app.db().groups();
        ContactData contactingroup = before.iterator().next();
        GroupData groupForContact = beforeGroup.iterator().next();
        app.goTo().gotoHomePage();
        app.Contact().ContactDelToGroup(contactingroup.getId(),groupForContact.getName()); // удаление контакта из группы
        Contacts after = app.db().contacts();
        Groups afterGroup = app.db().groups();
        // группа из которой удалили контакт
        //GroupData groupForContact = contactForGroup.getGroups()
                //.stream().filter(g -> g.getName().equals(name)).findFirst().get();


        MatcherAssert.assertThat((after.size()), CoreMatchers.equalTo(before.size())); // проверка на совпадение колич-ва контактов

       //Groups afterGroup = app.db().contactAllCountGroups();
        //MatcherAssert.assertThat(((afterGroup)), CoreMatchers.equalTo(new Groups(beforeGroup.without(groupForContact))));


    }
}
