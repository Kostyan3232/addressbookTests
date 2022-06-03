package ru.stqa.pft.addressbook.Test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

public class GroupDeleteTests extends TestBase{
  @BeforeMethod
  public  void ensurePreconditions(){
    app.goTo().groupPage();
    if (!app.Group().isThereAgroup()){
      app.Group().createGroup(new GroupData().withName("Test2"));
    }
  }


  @Test
  public void testDeleteGroup(){
    Groups before = app.Group().all();
    GroupData deletedGroup = before.iterator().next();
    app.Group().delete(deletedGroup);
    Groups after = app.Group().all();
    Assert.assertEquals(after.size(), before.size() -1);
    before.remove(deletedGroup);
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(deletedGroup)));
    Assert.assertEquals(before,after);

  }



}



