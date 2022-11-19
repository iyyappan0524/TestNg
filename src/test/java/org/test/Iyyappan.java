package org.test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iyyappan {
	WebDriver w;

	@BeforeClass
	private void clas() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();

	}

	@BeforeMethod
	private void met() {

		w.get("https://www.makemytrip.com/");
	}

	JavascriptExecutor js;

	@Test
	private void test() throws Exception {

		WebElement d = w.findElement(By.xpath("(//span[text()='Hotels'])[1]"));
		js = (JavascriptExecutor) w;
		js.executeScript("arguments[0].click()", d);
		Thread.sleep(2000);
		WebElement g = w.findElement(By.xpath("//label[@for='city']"));

		js = (JavascriptExecutor) w;
		js.executeScript("arguments[0].click()", g);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		WebElement j = w.findElement(By.xpath("(//div[text()='13'])[1]"));
		j.click();

		WebElement k = w.findElement(By.xpath("(//div[text()='14'])[2]"));
		k.click();

		WebElement l = w.findElement(By.xpath("//li[@data-cy='adults-5']"));
		l.click();
		
		WebElement g1 = w.findElement(By.xpath("(//button[@type='button'])[2]"));
		js = (JavascriptExecutor) w;
		js.executeScript("arguments[0].click()", g1);
		
		WebElement h = w.findElement(By.xpath("//button[text()='Search']"));
		h.click();
		
	}

	@AfterMethod
	private void met1() throws IOException {
		TakesScreenshot t=(TakesScreenshot) w;
		File k1 = t.getScreenshotAs(OutputType.FILE);
		
		File f=new File("C:\\Users\\ELCOT\\eclipse\\Testngframe\\ScreenShot\\iyya.png");
		
		FileUtils.copyFile(k1, f);
		
	}

	@AfterClass
	private void clas2() {
		w.close();
	}

}
