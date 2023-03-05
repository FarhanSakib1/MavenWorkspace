package saturdayClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PLTest {

	public static void main(String[] args)throws InterruptedException, IOException {
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
		//write all team name inside new excel sheet
		@SuppressWarnings("resource")
		HSSFWorkbook wb=new HSSFWorkbook(); 									//create a new workbook object
		HSSFSheet sheet = wb.createSheet("Team Names");							//create a new sheet inside a workbook 
		//Starting for loop to identify row and columns in excel. connected to line 35.
		for(int i=0;i<teams.size();i++) {
			//Creates the first row in the excel sheet created.
			Row row =sheet.createRow(i);
			//Creates the first column in the excel sheet.
			Cell cell=row.createCell(0);
			//Captures webelement name and prints it into console.trim will remove space before and after a web text
			System.out.println(teams.get(i).getText().trim());
			cell.setCellValue(teams.get(i).getText().trim()); //write all name inside sheet 
			FileOutputStream fso =new FileOutputStream("AllTeamName1.xls");			//location of excel file inside project
			wb.write(fso);															//create excel file with all names 
			
		}
		
		
		
	}

}