package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_XpathText {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add Element\"]")).click();

        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton= driver.findElement(By.xpath("//button[text()=\"Delete\"]"));

        if (deleteButton.isDisplayed()){
            System.out.println("delete button testi PASSED");
        } else {
            System.out.println("delete button testi FAILED");
        }

        //4- Delete tusuna basin
        deleteButton.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement=driver.findElement(By.xpath("//h3[text()=\"Add/Remove Elements\"]"));

        if (addRemoveElement.isDisplayed()){
            System.out.println("add remove button testi PASSED");
        } else {
            System.out.println("add remove  testi FAILED");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
