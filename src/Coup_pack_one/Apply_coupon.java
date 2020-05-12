package Coup_pack_one;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Apply_coupon extends Elements_Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/home/arjun/Downloads/Selenium/chromedriver2/chromedriver_linux64 (1)/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Elements_Locators obj=new Elements_Locators();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.mykirana.com/");
		driver.manage().window().maximize();
		driver.findElement(obj.pincode).sendKeys("110030");
		Select drop = new Select(driver.findElement(obj.dropdownarea));
		drop.selectByVisibleText("Sultanpur");
		driver.findElement(By.xpath("//input[@id='store_submit']")).click();
		driver.findElement(obj.storename).click();
		
		//driver.findElement(By.xpath("/html/body/section/section[2]/div/div/div/nav/div/div/div/div/div/ul/div/div/li[1]/a/span")).click();// FOR GROCERY AND STAPLES
		
		driver.findElement(By.xpath("/html/body/section/section[2]/div/div/div/nav/div/div/div/div/div/ul/div/div/li[2]/a/span")).click();// FOR GROCERY AND STAPLES

		

		
		
		Thread.sleep(3000);
		System.out.println("Now we are going to add product in our cart");
		
		try {
			driver.findElement(By.xpath("//button[contains(text(),'I understand')]")).click();
		}

		catch (Exception e) {
			System.out.println("I understand not found");
		}
		
		for (int i = 0; i < 3; i++) {
			
			String product_name="Bombay Shaving Company Beard Care Starter kit";

			try {
				driver.findElement(By.xpath(
						"//a[contains(text(),'"+product_name+"')]//parent::h3//parent::div[@class='namebox']//parent::div[@class='warp-info option_value_length']//following-sibling::div[@class='product-action']//div[@class='cart']//div[@class='quantity-adder']//following-sibling::input[@value='Add To Bag']"))
						.click();
			}

			catch (Exception e) {
				System.out.println(product_name+" is not available");

			}
Thread.sleep(2000);
		}
		driver.findElement(By.xpath("//div[@id='cart']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'View Cart')]")).click();

//Now click on Apply Coupon
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//div[@class='coupon']")).click();

//Enter credentials
		driver.findElement(By.xpath("//a[@class='button coupon_code_box_inner']")).click();

		driver.findElement(By.xpath("//input[@name='login_mobile']")).sendKeys("7830414114");
		driver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		Thread.sleep(5000);
		System.out.println("Waiting to enter coupon code");

		//driver.findElement(By.xpath("//div[@class='coupon']")).click();

		//driver.findElement(By.xpath("//input[@placeholder='Enter Coupon Code']")).sendKeys("Mykirana100");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@class='coupon_add_inner']//input[@id='button-checkout-coupon' and @type='submit']")).click();

//		try {
//			String successmessage = driver.findElement(By.xpath("//div[@class='success']")).getText();
//			System.out.println(successmessage);
//		}
//
//		catch (Exception e) {
//			String Fmessage = driver.findElement(By.xpath("//div[@class='warning']")).getText();
//			System.out.println(Fmessage);
//		}
		driver.findElement(By.xpath("//a[@class='button coupon_code_box_inner']")).click();

		driver.findElement(By.xpath("//input[@value='Deliver Here']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div/div/div/div[1]/div[4]/div[2]/div/div[5]/div[1]/div[2]/ul/li[1]/input")).click();

		driver.findElement(By.xpath("//a[@id='place_order_ex']")).click();
		String orderid = driver.findElement(By.xpath("//div[@id='order-place-last-step']//p")).getText();
		System.out.println("Your order id is " + orderid);

	}

}


//try {
//driver.findElement(By.xpath(
//		"//a[contains(text(),'Sampurn Organic Whole Moong Dal')]//parent::h3//parent::div[@class='namebox']//parent::div[@class='warp-info option_value_length']//following-sibling::div[@class='product-action']//div[@class='cart']//div[@class='quantity-adder']//following-sibling::input[@value='Add To Bag']"))
//		.click();
//}
//
//catch (Exception e) {
//System.out.println("Sampurn Organic Whole Moong Dal is not available");
//}
