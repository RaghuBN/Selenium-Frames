package FramesConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleFrames {
	@Test
	public void Frames() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\Selenium Browsers Jars\\Chrome\\Chrome 84\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("D:\\LTI Selenium Samples\\frame.html");
		
		Thread.sleep(5000);
		
		int totalnoofframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("number of frames: " + totalnoofframes);

		driver.switchTo().frame("easycalculation");
		driver.navigate().to("https://www.login.hiox.com/login?referrer=easycalculation.com");
		driver.findElement(By.id("log_email")).sendKeys("9740673180");
		driver.findElement(By.id("log_password")).sendKeys("raghubn@123");
		driver.findElement(By.xpath("//input[contains(@name,'log_submit')]")).click();

		driver.navigate().to("D:\\LTI Selenium Samples\\frame.html");
		Thread.sleep(5000); 
		
		driver.findElement(By.xpath("/html/body/a")).click();

		driver.navigate().to("https://www.selenium.dev/");
		driver.findElement(By.xpath("//a[contains(text(),'Projects')]")).click();
		Thread.sleep(5000);
		
		driver.navigate().to("D:\\LTI Selenium Samples\\frame.html");

		driver.switchTo().frame("My Store");
		driver.navigate().to("http://demo.opencart.com/");
		driver.findElement(By.name("search")).sendKeys("product");
		
		driver.findElement(By.xpath("/html/body")).click();
		Thread.sleep(5000);
		
		driver.quit();
	}
}
