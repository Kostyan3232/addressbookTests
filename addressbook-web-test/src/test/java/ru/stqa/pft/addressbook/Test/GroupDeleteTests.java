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
    if (app.db().groups().size()==0){
      app.goTo().groupPage();
      app.Group().createGroup(new GroupData().withName("Test2"));
    }
  }


  @Test
  public void testDeleteGroup(){
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.goTo().groupPage();
    app.Group().delete(deletedGroup);
    Groups after = app.db().groups();
    Assert.assertEquals(after.size(), before.size() -1);
    before.remove(deletedGroup);
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(deletedGroup)));
    //Assert.assertEquals(before,after);
    verifyGroupListInUI();

  }



}



