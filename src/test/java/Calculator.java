import io.appium.java_client.windows.WindowsDriver;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator{
    private WindowsDriver calcsession = null;
    private WebElement calcresult = null;

   @BeforeClass
   public void setup(){
       System.out.println("setup");
       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability("app","Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
       try {
           calcsession = new WindowsDriver(new URL("http://127.0.0.1:4723"),capabilities);
       } catch (MalformedURLException e) {
           e.printStackTrace();
       }
   }    
    @AfterClass
    public  void  teardown(){

       System.out.println("teardown")       ;
       calcsession.quit();
    }
    @BeforeMethod
    public  void  clear(){
        System.out.println("clear");
        calcsession.findElementByName("Clear").click();
    }
    @Test
    public void addition(){
        System.out.println("running addition");
        calcsession.findElementByName("One").click();
        calcsession.findElementByName("Two").click();
        calcsession.findElementByName("Plus").click();
        calcsession.findElementByName("Three").click();
        calcsession.findElementByName("Equals").click();
        Assert.assertEquals(getDisplayResult(),"15");
    }

    @Test
    public void multiplication(){
        System.out.println("running  multiplication");
        calcsession.findElementByName("One").click();
        calcsession.findElementByName("Two").click();
        calcsession.findElementByName("Multiply by").click();
        calcsession.findElementByName("Nine").click();
        calcsession.findElementByName("Equals").click();
        Assert.assertEquals(getDisplayResult(),"108");
    }

    @Test
    public void subtraction(){
        System.out.println("running  subtraction");
        calcsession.findElementByName("One").click();
        calcsession.findElementByName("Two").click();
        calcsession.findElementByName("Minus").click();
        calcsession.findElementByName("Nine").click();
        calcsession.findElementByName("Equals").click();
        Assert.assertEquals(getDisplayResult(),"3");
    }

    @Test
    public void division(){
        System.out.println("running  division");
        calcsession.findElementByName("One").click();
        calcsession.findElementByName("Two").click();
        calcsession.findElementByName("Divide by").click();
        calcsession.findElementByName("Three").click();
        calcsession.findElementByName("Equals").click();
        Assert.assertEquals(getDisplayResult(),"4");
    }

    public String getDisplayResult(){
       calcresult = calcsession.findElementByAccessibilityId("CalculatorResults");
       return calcresult.getText().replace("Display is","").trim();

    }
}
