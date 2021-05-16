import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class abc {


        public static WebDriver driver;
        public static JavascriptExecutor js;

        public static void main(String[] args)
        {
            System.setProperty("webdriver.chrome.driver", "D:\\UDPM\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://html5demos.com/storage");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("local")).sendKeys("myLocal");
            driver.findElement(By.id("session")).sendKeys("mySession");
            driver.findElement(By.tagName("code")).click(); // just to escape textbox

            String sItem = getItemFromLocalStorage("value");
            System.out.println(sItem);
        }

        public static String getItemFromLocalStorage(String key)
        {
            js = ((JavascriptExecutor)driver);
            return (String) js.executeScript(String.format(
                    "return window.localStorage.getItem('%s');", key));
        }
}
