package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_RadioButtons {

    //  Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //	a. Verilen web sayfasına gidin "https://facebook.com"
    //	b. Cookies’i kabul edin
    //	c. Create an account buton’una basin
    //	d. Radio button elementlerini locate edin ve size uygun olani secin
    //  e. Sectiginiz radio butoon'un secili, otekilerin ise secili olmadigini test edin

    WebDriver driver;
    @Before
    public void setup(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://facebook.com");

        //driver.findElement(By.xpath("//button[text()='Allow essential and optional cookies']")).click();

        driver.findElement(By.xpath("//a[text()='Yeni hesap oluştur']")).click();
        Thread.sleep(3000);

        WebElement femaleElementi= driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement maleElementi= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement customElementi= driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

        Thread.sleep(3000);
        femaleElementi.click();


        Assert.assertTrue(femaleElementi.isSelected());
        Assert.assertFalse(maleElementi.isSelected());
        Assert.assertFalse(customElementi.isSelected());

    }
}
