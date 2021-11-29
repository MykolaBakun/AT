package unit;

import io.restassured.internal.common.assertion.AssertionSupport;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import practice.test_helper.BaseTest;

import static practice.hw.Calculator.addition;

@Test
public class MySecondTest
      //  extends BaseTest
{

    @Test(groups = "group1"
            //enabled = false
    )
    public void firstTest() {
       // assertTrue(true);
        Boolean condition =addition("2","2")==4;
        Assert.assertTrue(condition);
        Integer actual=new Double(addition("2","2")).intValue();
        Integer expected=5;

        Assert.assertEquals(actual,expected,"addition error");
    }

    @Test
    @Parameters({"1", "2"})
    public void bTest(@Optional String a, @Optional String b) {
        Assert.assertEquals(addition(a, b),3,"addition error");
    }

    @Test(dataProvider = "numbersProvider")
    public void addTest(Integer a,Integer b, Integer expected) {

        double actual=addition(a + "", b + "");

        double expectedDouble=expected.doubleValue();

        Assert.assertEquals(actual,expectedDouble,"addition error");


    }

    @DataProvider
    Object[][] numbersProvider(){
        int n=4;
        Object[][] res= new Object[n][];
        res[0]=new Integer[]{2,2,4};
        res[1]=new Integer[]{0,0,0};
        res[2]=new Integer[]{10,-10,0};
        res[3]=new Integer[]{10,-10,1};
        return res;
    }

}
