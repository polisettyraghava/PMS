package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class New_Test {

	public static void main(String[] args) throws IOException
	{
     
		WebDriver driver= new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		WebElement searchbox = driver.findElement(By.id("sb_ifc0"));
		
		
	try {
		FileInputStream file = new FileInputStream("C:\\Projects\\Com.Validations\\src\\com\\ExcelTestDataFiles\\new test.xlsx");
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			Cell resultCell = sheet.getRow(i).getCell(3);
			String keyword = sheet.getRow(i).getCell(2).getStringCellValue();
			searchbox.clear();
			searchbox.sendKeys("hello selenium");
			searchbox.submit();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			
			String searchText=searchbox.getAttribute("value");
			
			if(searchText.equals(keyword)) {
				System.out.println("search is successful");
				resultCell.setCellValue("pass");
				
			}
			else
			{
				System.out.println("search is not successful");
				resultCell.setCellValue("FAIL");
			}
		}
		
		workbook.close();
		file.close();
	FileOutputStream file1= new FileOutputStream("C:\\Projects\\Com.Validations\\src\\com\\ExcelTestDataFiles\\new test.xlsx");
	workbook.write(file1);
	file1.close();
}
catch (FileNotFoundException e) {
e.printStackTrace();

}catch (IOException ioe) {
	ioe.printStackTrace();
}	
		
		
		
		
	}

}
