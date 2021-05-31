package PipelineTestHotelWeb.PipelineTestHotelWeb;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest 
{
	
	protected static WebDriver driver;
	protected WebDriverWait wait;

	
	public File getFileAsResource(String filePath) {
		Path resourceDirectory = Paths.get(filePath);
		return resourceDirectory.toFile();
	}

	@Test
	public void run() throws InterruptedException{
    
    	File file = getFileAsResource("src/main/resources/driver/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://192.168.1.72:8090/HotelWebapp-1.0-SNAPSHOT/");
		
		Select ville = new Select(driver.findElement(By.name("ville")));
		ville.selectByValue("Paris");
		WebElement chercher = driver.findElement(By.xpath("//button[contains(.,'Chercher')]"));
		chercher.click();
		
		
    }

    
}
