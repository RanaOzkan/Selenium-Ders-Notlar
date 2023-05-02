package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C04_CookiesGecme {
    public static void main(String[] args) {


        //1- https://www.amazon.com/ sayfasina gidelim
        //2- arama kutusunu locate edelim
        //3- “Samsung headphones” ile arama yapalim
        //4- Bulunan sonuc sayisini yazdiralim
        //5- Ilk urunu tiklayalim
        //6- Sayfadaki tum basliklari yazdiralim



        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com");

        // arama cubuguna Java yazip aratin
        WebElement aramaCubugu=driver.findElement(By.xpath("//input[@name='q']"));
        aramaCubugu.sendKeys("java"+ Keys.ENTER);

        // bulunan sonuc sayisinin 100binden cok oldugunu test edin
        WebElement sonucSayiElementi= driver.findElement(By.xpath("//div[@id='result-stats']"));

        // About 1.350.000.000 results (0,43 seconds)
        String sonucYazisi= sonucSayiElementi.getText();
        String[] sonucYaziArr=sonucYazisi.split(" ");

        String sonucSayisiStr= sonucYaziArr[1]; // 1.350.000.000
        sonucSayisiStr = sonucSayisiStr.replaceAll("\\D","");

        int actualSonucSayisi= Integer.parseInt(sonucSayisiStr);
        int expectedSonucSayisi=100000;

        if (actualSonucSayisi>expectedSonucSayisi){
            System.out.println("Arama sonuc sayisi testi PASSED");
        }else {
            System.out.println("Arama sonuc sayisi testi FAILED");
        }

        driver.close();
    }
}
