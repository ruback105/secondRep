package lv.delfi.firstProj;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MainPart extends driver{
	public static WebElement elem;
	public static  int i = 0;
	public static String temp;
	
	public void openTasty() {
		driver.get("https://www.delfi.lv");
		try {
			driver.findElement(By.id("cookiePolicyAccept")).click();
		} catch (Exception e) {
		}
		driver.findElement(By.xpath("//a[contains(@href, 'delfi.lv/tasty')]")).click();
		elem = driver.findElement(By.xpath("//a[@class='d-block bg-white text-secondary p-3'][3]"));
		driver.get(elem.getAttribute("href"));
	}
	
	public void findRec() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(
				By.xpath("//div[@class='position-absolute z-index-1  w-100 p-4 pt-5 headline__inner__title']")));
		elem = driver.findElement(By.xpath("//a[@class='text-white']"));
		driver.get(elem.getAttribute("href"));
	}
	
	public void findIng() {
		temp = driver.findElement(By.xpath("//h1[@class = 'text-size-22 text-size-md-30 d-inline']")).getText();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//div[@class='ingredients']")));
	}
	
	public void Search() throws InterruptedException {
		i = 0;
		ArrayList<WebElement> links = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//a[@itemprop='recipeIngredient']"));
		int size = links.size();
		String[] linking = new String[size];
		for (WebElement aaa : links) {
			linking[i] = aaa.getAttribute("href");
			i++;
		}
		i = 0;
		for (WebElement link : links) {
			driver.get(linking[i]);
			if (driver.getPageSource().contains(temp.trim()))
				System.out.println(linking[i] + " pass");
			else
				System.out.println(linking[i] + " fail");
			i++;
		}
	}
	
	
	
}
