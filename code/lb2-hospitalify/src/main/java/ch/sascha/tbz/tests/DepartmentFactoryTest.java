package ch.sascha.tbz.tests;

import jdk.jfr.Label;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentFactoryTest {

    @Label("Must return true")
    @Test
    public void testGoingOn() throws Exception{
        Assert.assertTrue(1 > 0);
    }

    @Label("Must throw error")
    @Test
    public void testGoingOn2() throws Exception{
        Assert.assertTrue(1 < 0);
    }
}