/*package ru.stqa.pft.addressbook.Test;


import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase{
  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
      BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/groups.xml"));
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
          xml += line;
          line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(GroupData.class);
      List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }
    //String line = reader.readLine();
    //while (line !=null){
        //String[] split = line.split(";");
        //list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
        //line = reader.readLine();


    ///list.add(new Object[]{new GroupData().withName("test1").withHeader("header 1").withFooter("footer 1")});
    ///list.add(new Object[]{new GroupData().withName("test2").withHeader("header 2").withFooter("footer 2")});
    ///list.add(new Object[]{new GroupData().withName("test3").withHeader("header 3").withFooter("footer 3")});

      //return list.iterator();


  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group)  {
    //GroupData group = new GroupData().withName(name).withHeader(header).withFooter(footer);
      app.goTo().groupPage();
      Groups before = app.db().groups();
      app.Group().createGroup(group);
      Groups after = app.db().groups();
      assertThat(after, equalTo(before));
      //assertThat(after.size(), equalTo(before.size()+1));

      //assertThat(after, equalTo(before.withAdded(group.withId((after.stream().mapToInt(GroupData::getId).max().getAsInt())))));
     // verifyGroupListInUI();

    }

  }*/



