package com.Task17.Answers;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Snapdeal_Site {
	WebDriver driver=null;
	public static void main(String[] args) {

		// Initialize the WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();//maximize the Browser window

		// Navigate to the SnapDeal webSite
		driver.get("https://www.snapdeal.com/");

		// Locate the Sign In button and click on sign button
		driver.findElement(By.xpath("//div[@class='accountInner']")).click();

		//click on Login Button
		driver.findElement(By.xpath("//span[@class='accountBtn btn rippleWhite']")).click();

		//Switch to iFrame
		WebElement wb=driver.findElement(By.xpath("//*[@id=\"loginIframe\"]"));
		driver.switchTo().frame(wb);

		//Locate the Email id field and Enter a valid email id 
		driver.findElement(By.id("userName")).sendKeys("seshanth2346@gmail.com");

		//click on the Continue Button
		driver.findElement(By.xpath("//button[@id='checkUser']")).click();

		//locate the mobile number field and Enter a mobile number
		driver.findElement(By.id("j_number")).sendKeys("9876543210");

		//Locate the Name field and Enter the name 
		driver.findElement(By.id("j_name")).sendKeys("jhonny");

		//Locate the dob file and clears the text in the field 
		driver.findElement(By.id("j_dob")).clear();

		//Locates the dob field and Enter the Date
		driver.findElement(By.id("j_dob")).sendKeys("01/01/1998");

		//Locate the Password field and type password
		driver.findElement(By.id("j_password")).sendKeys("testpassword");

		//Locate the continue Button and clicks the continue button
		driver.findElement(By.xpath("//button[@id='userSignup']")).click();


		// Verify if login was successful (you can change the condition based on the actual SnapDeal webSite)
		boolean isLoggedIn = driver.findElement(By.xpath("//input[@name='keyword']")).isDisplayed();


		// Print the verification message
		if (isLoggedIn) {
			System.out.println("Login successful!");
		} 
		else {
			System.out.println("Login failed!");
		}

		// Close the browser
		driver.quit();
	}
}