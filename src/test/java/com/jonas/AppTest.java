package com.jonas;

import com.jonas.domain.User;
import io.ebean.DB;
import io.ebean.Database;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void testInsertUser() {
        User user = new User("Tom", 20, 1);
        Database database = DB.getDefault();
        database.save(user);
        Assert.assertNotNull(user.getUserId());
    }
}
