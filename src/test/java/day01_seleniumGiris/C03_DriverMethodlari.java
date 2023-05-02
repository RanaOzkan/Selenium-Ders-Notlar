package day01_seleniumGiris;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethodlari {
    public static void main(String[] args) {

        //WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // gittiginiz sayfadaki title ve url'i yazdirin
        System.out.println("URL : "+driver.getCurrentUrl()); // URL : https://www.amazon.com/
        System.out.println("Baslik : "+driver.getTitle());

        // amazon anasayfaya gittiginizi test edin

        // Test expected result ile actual result'in karsilastirilmasidir
        // ornegin url amazon iceriyorsa diyebiliriz

        String expectedIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedIcerik)){ // amazon anasayfaya gittiysek
            System.out.println("Test PASSED");
        }else {//gidemediysek
            System.out.println("Test FAILED");
        }

    }
}
