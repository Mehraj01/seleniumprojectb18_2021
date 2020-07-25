package test.day6_testing_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGPractice {

//
//    public static void main(String[] args) {
//        test1();
//    }


    // TestNG helps us to run the program without the main method

    @BeforeClass // it runs before each test methods
    public void before_class(){
        System.out.println("BeforeClass is running !---------------------------");
    }

    @AfterClass // this method will run once and first before BeforeMethod
    public void after_class(){
        System.out.println("AfterClass is running!----------------------------");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before method is running...");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After method is running...");
    }

    @Test
    public void test1(){
        System.out.println("Test1 running...");

        String actualTitle="Homepage"; // driver.getTitle();
        String expectedTitle="Homepage";

        Assert.assertEquals(actualTitle, expectedTitle);
        // Assertions: we can use Assert method instead of if else statement in testNG

//        if(actualTitle.equals(expectedTitle)){
//            System.out.println("Title verification passed!");
//        }else{
//            System.out.println("Title verification failed!");
//        }

    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("Test2 is running....");

        Assert.assertEquals("string1","string2","String verification on test2 failed");
    }


    //@Test
    public void test3(){
        System.out.println("Test3 is running...");

        String actualTitle="Amazon prime";
        String expectedTitle="prime";
        String testString="sfghdkhfkgh";

        // if the boolean value we pass in assertTrue is "true", assertion will pass
        // else it will fail

        Assert.assertTrue(false);
        Assert.assertTrue(actualTitle.contains(expectedTitle));// expected pass boolean value. => true
        System.out.println("Just checking if this line is running");
        Assert.assertFalse(actualTitle.contains(testString));// expected pass boolean value. => false
    }




}
