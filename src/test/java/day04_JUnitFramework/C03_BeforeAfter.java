package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_BeforeAfter {

    WebDriver driver;

    @Before
    public void setup(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("setup calisti");
    }

    @After
    public void teardown(){
        driver.close();
        System.out.println("teardown calisti");
    }

    @Test
    public void test01(){
        driver.get("https://www.wisequarter.com");
        System.out.println("test01 calisti");
    }

    @Test
    public void test02(){
        driver.get("https://www.youtube.com");
        System.out.println("test02 calisti");
    }
}
