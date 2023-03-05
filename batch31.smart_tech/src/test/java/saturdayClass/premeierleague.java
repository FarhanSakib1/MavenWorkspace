package saturdayClass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class premeierleague {

	public static void main(String[] args)  {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.premierleague.com/tables");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[5]/button[1]")).click();
		//This is code to scroll:
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		//WebElement to capture all team names
		List<WebElement> teams= driver.findElements(By.xpath("//table/tbody/tr/td[3]/a/span[2]"));
		//Write team names on new excel sheet
		HSSFWorkbook wb=new HSSFWorkbook();//Creates a new workbook object
		HSSFSheet sheet= wb.createSheet("Team Names"); // Creates a new sheet
		for(int i=0;i<teams.size();i++) {
			Row row=sheet.createRow(i);
			Cell cell= row.createCell(0);
			System.out.println(teams.get(i).getText().trim());
			cell.setCellValue(teams.get(i).getText().trim()); //writes all names inside sheet
			FileOutputStream fso =new FileOutputStream("AllTeamName.xls"); //Location of excel File
			wb.write(fso); //creates excel file
		}
		

	}

}
