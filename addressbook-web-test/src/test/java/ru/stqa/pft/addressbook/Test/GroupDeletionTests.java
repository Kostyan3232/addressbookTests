package ru.stqa.pft.addressbook.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Test.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.Group().all().size() == 0) {
      app.Group().createGroup(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Groups before = app.Group().all();
    GroupData deletedGroup = before.iterator().next();
    app.Group().delete(deletedGroup);
    assertThat(app.Group().count(), equalTo(before.size() - 1));
    Groups after = app.Group().all();
    assertThat(after, equalTo(before.without(deletedGroup)));
  }

}
