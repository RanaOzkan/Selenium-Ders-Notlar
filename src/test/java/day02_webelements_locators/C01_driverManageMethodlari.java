package day02_webelements_locators;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C01_driverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver(options);

        System.out.println("Ilk size : "+driver.manage().window().getSize());
        System.out.println("Ilk position : " + driver.manage().window().getPosition());
        Thread.sleep(2000);

        // olculeri ve konumu degistirelim
        driver.manage().window().setSize(new Dimension(500,500));
        driver.manage().window().setPosition(new Point(40,100));
        System.out.println("size : "+driver.manage().window().getSize());
        System.out.println("position : " + driver.manage().window().getPosition());



        Thread.sleep(2000);
        driver.close();
    }
}
