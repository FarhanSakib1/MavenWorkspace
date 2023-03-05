package saturdayClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompareExcel {

	public static void main(String[] args) throws Throwable {
		//WebDriver is an interface of Selenium API. driver is an object and chrome driver is the class. Using this code selenium is driving the chrome browser.
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.premierleague.com/tables");
		driver.manage().window().maximize();
		//This is the code for Selenium Implicit Wait. One condition, wait for DOM to load.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//This is to remove the pop up.
		driver.findElement(By.xpath("(//*[@style='background-color:#37003c;'])[1]")).click();
		//This is to remove the ad.
		driver.findElement(By.xpath("/html/body/main/div[1]/nav/a[2]")).click();
		//This code is for scroll down 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		//web element to capture all team names 
		List<WebElement> teams= driver.findElements(By.xpath("//table/tbody/tr/td[3]/a/span[2]"));
		
		ArrayList<String> webTeams = new ArrayList<String>();
		ArrayList<String> exlTeams = new ArrayList<String>();
		ArrayList<String> unMatchTeams = new ArrayList<String>();
		for(WebElement team: teams) {
			webTeams.add(team.getText().trim());
		}
		System.out.println(webTeams);
		FileInputStream fis= new FileInputStream(new File("AllTeamName.xls"));
		HSSFWorkbook wb= new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			exlTeams.add(sheet.getRow(i).getCell(0).getStringCellValue());
		}
		System.out.println(exlTeams);
		wb.close();
		
		for(String unMatch: webTeams) {
			if(!exlTeams.contains(unMatch)) {
				unMatchTeams.add(unMatch);
			}
		}
			System.out.println(unMatchTeams);
	}

}
