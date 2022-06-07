package ru.stqa.pft.addressbook.Test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

public class GroupModificationTest extends TestBase {
    @BeforeMethod
    public  void ensurePreconditions(){
        if (app.db().groups().size()==0){
            app.goTo().groupPage();
            app.Group().createGroup(new GroupData().withName("Test2"));
        }

    }
    @Test
    public void testGroupModification(){
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().
                withId(modifiedGroup.getId()).withName("test42").withHeader("5").withFooter("test3");
        app.goTo().groupPage();
        app.Group().modifyGroup(group);
        Groups after = app.db().groups();
        Assert.assertEquals(after.size(), before.size() );

        //before.remove(modifiedGroup);
        //before.add(group);
        ///Comparator<? super GroupDate> byId = Comparator.comparingInt(GroupDate::getId);
        ///before.sort(byId);
        ///after.sort(byId);
        //Assert.assertEquals(before,after);
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifiedGroup).withAdded(group)));
        verifyGroupListInUI();
    }




}
