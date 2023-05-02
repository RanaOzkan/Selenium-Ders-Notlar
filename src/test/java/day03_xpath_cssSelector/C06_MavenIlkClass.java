package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C06_MavenIlkClass {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        System.out.println(driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText());


        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();


        // sayfadaki basliklar yan da olanlar.soldaki aramayı daraltabileceğimiz baslıklar.
        driver.navigate().back();// LİSTEYİ GORMEK ADİNA BİR AYFA GERİ GELDİK.

        List<WebElement> baslikElementleriLstesi=driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));
        // LİSTEYİ GORMAK İCİN FOR EACH LOOP

        int baslikno=1;
        for (WebElement each:baslikElementleriLstesi
        ) {
            System.out.println(baslikno+"-------- "+each.getText());
            baslikno++;
        }

        Thread.sleep(3000);
        driver.close();

    }
}
