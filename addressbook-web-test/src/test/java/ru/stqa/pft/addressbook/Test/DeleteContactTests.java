package ru.stqa.pft.addressbook.Test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class DeleteContactTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition(){
    app.Contact().gotoHomePage();
    if (!app.Contact().isThereContact()){
      app.Contact().createContact(new ContactData().withFirstname("Yhhh").
              withMiddlename("Wqqj").withLastname("GR").withAddres("Russia").
              withHomephone("57-82-99").withMobile("+79432459947").withWorkphone("51-51-88").withEmail("ffsdfsdf"));
    }
  }

  @Test
  public void testDeleteContact()  {
    Contacts before = app.Contact().ContactAll();
    ContactData deletedCnt = before.iterator().next();
    app.Contact().deletecont(deletedCnt);
    Contacts after = app.Contact().ContactAll();
    Assert.assertEquals(after.size(),before.size() -1);
    ///   before.remove(deletedCnt);
    // Assert.assertEquals(before,after);
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(deletedCnt)));


    }


}



