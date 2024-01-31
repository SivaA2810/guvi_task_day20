package src.D;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Practicewebdriver {
public static void main(String[] args) throws Exception {
	
//  WebDriverManager, a library that simplifies the code instead of provide
//	executable file and mention the path of the selenium jar file
	WebDriverManager.chromedriver().setup();
	
//  launching chromre browser using Webdriver Interface
	WebDriver driver = new ChromeDriver();
	
// navigate method will took us to given URL
	driver.navigate().to("https://demoblaze.com/index.html#%22");
	
// to maximize the window we can use manage method 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	List<WebElement> elements = driver.findElements(By.xpath("//a[@id='itemc']"));
	for(int i=0;i<elements.size();i++) {
		String attribute = elements.get(i).getAttribute("onclick");
		System.out.println("Attribute values - "+attribute);
		String expectelement ="byCat('notebook')";
		
		if (attribute.equals(expectelement)) {
			elements.get(i).click();
		}
	}
	driver.findElement(By.xpath("(//a[@class='hrefch'])[1]")).click();
	Thread.sleep(3000);
	driver.close();
	
}
}
