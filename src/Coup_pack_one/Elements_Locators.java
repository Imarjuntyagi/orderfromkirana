package Coup_pack_one;

import java.sql.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;

public class Elements_Locators {

	By pincode = By.xpath("//input[@name='pincode']");
	By dropdownarea = By.xpath("//select[@class='select_city_custom']");
	By storename = By.xpath("//a[contains(text(),'Hyperlocal')]");

}
