package com.jonas;

import com.jonas.domain.User;
import io.ebean.DB;
import io.ebean.Database;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    private final Database database = DB.getDefault();

    @Test
    public void testInsertUser() {
        User user = new User("Tom", 20, 1);
        database.save(user);
        Assert.assertNotNull(user.getUserId());
        System.out.println(user.getUserId());
    }

    @Test
    public void testSelectUser() {
        User user = database.find(User.class).where().eq("userId", 4).findOne();
        Assert.assertNotNull(user);
    }

    @Test
    public void testUpdateUser() {
        User user = database.find(User.class).where().eq("userId", 4).findOne();
        if (null != user) {
            user.setUserName("Jonas");
            database.update(user);
        }
        User u = database.find(User.class).where().eq("userId", 4).findOne();
        if (null == u) {
            Assert.fail();
        } else {
            Assert.assertEquals(u.getUserName(), "Jonas");
        }
    }
}
