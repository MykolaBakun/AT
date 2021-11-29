package unit;

import org.testng.Assert;
import org.testng.annotations.Test;
import practice.test_helper.BaseTest;

import static practice.hw.Calculator.addition;


@Test
public class MyTest
       // extends BaseTest
{

    @Test(groups = "group1")
    public void firstTest() {
       // assertTrue(true);
        Boolean condition =addition("2","2")==4;
        Assert.assertTrue(condition);
        Integer actual=new Double(addition("2","2")).intValue();
        Integer expected=4;

        Assert.assertEquals(actual,expected,"addition error");
    }

    @Test(groups = "group1", dependsOnMethods = {"firstTest"})
    public void secondTest() {
        // assertTrue(true);
        Boolean condition =addition("2","2")==4;
        Assert.assertTrue(condition);
        Integer actual=new Double(addition("2","2")).intValue();
        Integer expected=5;

        Assert.assertEquals(actual,expected,"addition error");
    }
}
