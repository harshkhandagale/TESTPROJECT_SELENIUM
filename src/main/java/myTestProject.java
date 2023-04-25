// I had a problem with
// 1. ChromeOptions ops = new ChromeOptions(); ops.addArguments("--remote-allow-origins=*"); WebDriver driver = new ChromeDriver(ops);
// this above problem is reslved by adding chrome options at line 19
//2. slf4j logger binder something , that issue i resolved by adding slf4j dependency in pom.xml


import org.apache.commons.exec.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class myTestProject {
    public static void main(String[] args) throws InterruptedException {

        String email = "mayur@gmail.com";
        String password = "mayur123";

 //You can create an instance of ChromeOptions, which has convenient methods for setting ChromeDriver-specific capabilities. You can then pass the ChromeOptions object into the ChromeDriver constructor:
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(ops);

        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");

//        WebDriver driver = new ChromeDriver();

//        driver.get("http:/localhost:3000/");
        driver.get("http://localhost:3000/") ;
        driver.manage().window().maximize();

        driver.getCurrentUrl();


        Thread.sleep(3000);
        //Code to register a user
        driver.findElement(By.xpath("//a[contains(text(),'Registration')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("firstname")).sendKeys("mayur");
        driver.findElement(By.name("lastname")).sendKeys("khan");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("2345436547");
        driver.findElement(By.name("age")).sendKeys("9");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.name("confirmpassword")).sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.className("btnRegister")).click();
        Thread.sleep(5000);

        //Code to log in with registered user
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        driver.close();
    }
}
