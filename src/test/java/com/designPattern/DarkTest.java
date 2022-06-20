package com.designPattern;

import com.designPattern.darklaunch.DarkLaunch;
import com.designPattern.darklaunch.IDarkFeature;
import com.designPattern.darklaunch.UserProgrammedDarkRule;
import org.junit.Assert;
import org.junit.Test;

public class DarkTest {
    @Test
    public void test() {
        DarkLaunch launch = new DarkLaunch();
        Assert.assertNotNull(launch);
        launch.addProgrammedDarkFeature("call_custom_getUserById", new UserProgrammedDarkRule());
        IDarkFeature darkFeature = launch.getDarkFeature("call_newapi_getUserById");
        IDarkFeature userDarkFeature = launch.getDarkFeature("call_custom_getUserById");
        Assert.assertNotNull(darkFeature);
        Assert.assertTrue(darkFeature.dark(893));
        Assert.assertTrue(darkFeature.dark("342"));
        Assert.assertTrue(darkFeature.dark(1020));
        Assert.assertTrue(darkFeature.dark(1120));
        Assert.assertTrue(darkFeature.dark(1025));
        Assert.assertFalse(darkFeature.dark(40));
        Assert.assertTrue(darkFeature.dark(29));
        Assert.assertTrue(userDarkFeature.dark(5201314));
        Assert.assertFalse(userDarkFeature.dark("123"));
    }
}
