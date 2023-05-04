package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C07_ilkAssertion {

    /*

    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
    ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    ○ logoTest => BestBuy logosunun görüntülendigini test edin
    ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");

    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        //URL TESTİ
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void test02(){
        //  titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedTitle="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void test03(){
        //logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }

    @Test
    public void test04(){
        WebElement fransizcaLink=driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(fransizcaLink.isDisplayed());
    }
}

