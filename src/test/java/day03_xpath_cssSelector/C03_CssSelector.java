package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_CssSelector {
    public static void main(String[] args) {

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-  bir class olusturun
        //2-  https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //3-  Browseri tam sayfa yapin
        //4-  Sayfayi “refresh” yapin

        //5-  Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        driver.findElement(By.xpath("//span[@class='a-button-inner']")).click();
        String expectedIcerik="Spend less";
        String actualIcerik= driver.getTitle();

        if(actualIcerik.contains(expectedIcerik)){
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Title testi FAILED");
        }


        //6-  Gift Cards sekmesine basin
        driver.findElement(By.xpath("(//a[@tabindex='0'])[8]")).click();

        //7-  Birthday butonuna basin
        driver.findElement(By.cssSelector("a[aria-label='Birthday']")).click();

        //8-  Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).click();

        //9-  Gift card details’den 25 $’i  secin
        driver.findElement(By.cssSelector("#gc-mini-picker-amount-1"));

        //10- Urun ucretinin 25$ oldugunu test edin
        WebElement ucretElementi=driver.findElement(By.xpath("//button[@value='25']"));
        String expectedUcret="25$";
        String actualUcret=ucretElementi.getText();

        if (expectedUcret.equals(actualUcret)){
            System.out.println("ucret testi passed");
        }else {
            System.out.println("ucret testi failed"+actualUcret);
        }

        //11- Sayfayi kapatin
        driver.close();

    }
}
