package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropdownMenu {

    // https://www.amazon.com/ adresine gidin.
    //- Test 1
    //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //-Test 2
    //	1. Kategori menusunden Books secenegini  secin
    //	2. Arama kutusuna Java yazin ve aratin
    //	3. Bulunan sonuc sayisini yazdirin
    //	4. Sonucun Java kelimesini icerdigini test edin


    static WebDriver driver;

    @BeforeClass
    public static void setup(){

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @Ignore
    public static void teardown(){
        driver.close();
    }


    @Test

    public void test01() throws InterruptedException {
        //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        WebElement cookie = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        cookie.click();
        Thread.sleep(3000);

        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin.
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select=new Select(ddm);

        int actualoptionSayisi=select.getOptions().size();
        //select getoptions dedigimizde bütün optionlarin olduğu bir liste döndürür.
        int expectedOptionSayisi=45;
        Assert.assertEquals(expectedOptionSayisi,actualoptionSayisi);//once expected
    }
    @Test
    public void test02(){
        /*
        1. Kategori menusunden Books secenegini secin
 2. Arama kutusuna Java yazin ve aratin
 3. Bulunan sonuc sayisini yazdirin
 4. Sonucun Java kelimesini icerdigini test edin
         */
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select=new Select(ddm);
        //1. Kategori menusunden Books secenegini secin
        select.selectByVisibleText("Books");
        //2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//span[text()='\"Java\"']"));
        System.out.println(sonucYazisiElementi.getText());
        //4. Sonucun Java kelimesini icerdigini test edin
        String expectedIcerik="Java";
        String actaulIcerik=sonucYazisiElementi.getText();

        Assert.assertTrue(actaulIcerik.contains(expectedIcerik));

    }
}
