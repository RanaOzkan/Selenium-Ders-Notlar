package day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_TestBaseIlkTest extends TestBase {

    // amazona gidelim
    // nutella aratalım
    //sonuclarin nutella icerdigini test edelim

    @Test
    public void amazonTest() throws InterruptedException {

        driver.get("https://www.amazon.com/");

        WebElement cookie = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        cookie.click();


        driver.findElement(By.id("twotabsearchtextbox")).
                sendKeys("nutella"+ Keys.ENTER);

        WebElement actualSonucYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik="nutella";
        String actualSonucYazisi=actualSonucYaziElementi.getText();
        Thread.sleep(3000);

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }
}
