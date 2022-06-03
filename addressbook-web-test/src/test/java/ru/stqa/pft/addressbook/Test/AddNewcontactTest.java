package ru.stqa.pft.addressbook.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewcontactTest extends TestBase{


  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list =new ArrayList<Object[]>();
    try(BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.csv"))){
        String  line = reader.readLine();
        while (line !=null){
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData().withFirstname(split[0]).withMiddlename(split[1]).withLastname(split[2])});
            line = reader.readLine();
        }

        return list.iterator();
    }
    ///list.add(new Object[]{new ContactData().withFirstname("name1").withMiddlename("name2").withLastname("name3")});
    ///list.add(new Object[]{new ContactData().withFirstname("name1").withMiddlename("name2").withLastname("name3")});
    //list.add(new Object[]{new ContactData().withFirstname("name1").withMiddlename("name2").withLastname("name3")});
  }


  @Test(dataProvider = "validContacts")
  public void testAddNewcontact(ContactData contact) throws Exception {
   // ContactData contact = new ContactData().withFirstname(firstname).withLastname(lastname).withMiddlename(middlename);
      app.Contact().gotoHomePage();
      Contacts before = app.Contact().ContactAll();
      app.Contact().gotoAllNewPage();
      File photo = new File("src/test/man.png");
      app.Contact().createContact(contact);//new ContactData().withFirstname("Ttttt").
              //withMiddlename("YUj").withLastname("fghgfh").withAddres("Russia"));
             // withHomephone("55-88-99").withMobile("+79532559944").withWorkphone("55-55-88").withEmail("fsfsdfdsf").
              //withPhoto(photo));
      Contacts after = app.Contact().ContactAll();

      Assert.assertEquals(after.size(),before.size() +1);


    }




  }

