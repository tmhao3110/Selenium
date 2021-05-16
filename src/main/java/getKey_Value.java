import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class getKey_Value {

    private static WebDriver driver;
    public static JavascriptExecutor js;
    public static WebElement hover;
    public static WebElement click;

    @Test
    public void ABC() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\UDPM\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/trangchu.html");
        hover = driver.findElement(By.xpath("/html/body/article/div[6]/div[1]/div/div[1]/div/div[1]/img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hover).build().perform();
        click = driver.findElement(By.xpath("/html/body/article/div[6]/div[1]/div/div[1]/div/div[1]/div/div/button[1]/i"));
        click.click();
        driver.get("http://127.0.0.1:5500/sanpham.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String sItem = getItemFromLocalStorage("cart");
        System.out.println(sItem);
        driver.quit();
    }

    public static String getItemFromLocalStorage(String key) {
        js = ((JavascriptExecutor)driver);
        return (String) js.executeScript(String.format(
                "return window.localStorage.getItem('%s');", key));
    }

    public static void Hover(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public static void main(String[] args) {
        System.out.println("hello Git");
    }

}
