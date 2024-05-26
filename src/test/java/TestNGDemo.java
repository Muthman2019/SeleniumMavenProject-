import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDemo {
    @Test
    public void test1(){
        System.out.println("test 1");
    }
   //We added dependsOnMethods parameter to the Test annotation for dependency
    // dependOnMethods to be used with E2E scenarios contain dependencies
    @Test
    public void test2(){
        System.out.println("test 2");
        Assert.fail("hwa kda");
    }
    @Test (dependsOnMethods = {"test2"})
    public void test3(){
        System.out.println("test 3");
        //asser fail here to demonstrate the privilege of denpendsOn over priority
        // to show skipped test case

    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod to run before each test case");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod to run after each test case");
    }
    @BeforeClass
    public void beforeClass (){
        System.out.println("Before class to run ONE time before any test case");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class to run ONE time after all test cases");
    }
}
