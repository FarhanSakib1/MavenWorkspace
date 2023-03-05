package saturdayClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().window().maximize();
		// Switch Window Example
		// Store and Print the name of the First window on the console
		String swHandle = driver.getWindowHandle();
		System.out.println("This is first window: " + swHandle);
		// Click on the Button "New Message Window"
		driver.findElement(By.id("openwindow")).click();
		// Store and Print the name of all the windows open
		Set<String> swHandles = driver.getWindowHandles();
		System.out.println("Old window plus new window names: " + swHandles);
		System.out.println("Window title before change: " + driver.getTitle());
		// Pass a window handle to the other window
		for (String handle1 : swHandles) {
			System.out.println("Changing window: " + handle1);
			driver.switchTo().window(handle1);
		}
		System.out.println("Window title after change: " + driver.getTitle());
		// Close new window
		driver.close();
		// Go back to old window
		driver.switchTo().window(swHandle);
	}

}
