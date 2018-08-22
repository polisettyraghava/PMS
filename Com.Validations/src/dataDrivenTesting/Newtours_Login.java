package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Newtours_Login 
{
	FirefoxDriver driver;
    @BeforeTest
	public void setup() {
    	driver = new FirefoxDriver();
    	driver.get("http://newtours.demoaut.com");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test(priority=0)
    public void Register() {
    	driver.findElement(By.linkText("REGISTER")).click();
    }
    
    @Test(priority=1)
    public void NewRegister() throws IOException {
    	FileInputStream file = new FileInputStream("C:\\Projects\\Com.Validations\\src\\com\\ExcelTestDataFiles\\UserRegistrationTestData.xlsx");
        XSSFWorkbook workBook = new XSSFWorkbook(file);
        XSSFSheet sheet = workBook.getSheet("Sheet1");
        
        int RowCount = sheet.getLastRowNum();
        for(int i=1;i<=RowCount;i++) 
        {
          Row r = sheet.getRow(i);
          driver.findElement(By.name("firstName")).sendKeys(r.getCell(0).getStringCellValue());
          driver.findElement(By.name("lastName")).sendKeys(r.getCell(1).getStringCellValue());
          
          double d= r.getCell(2).getNumericCellValue();
          long x = (long)d;
          String phoneNumber = Long.toString(x);
          
          driver.findElement(By.name("phone")).sendKeys(phoneNumber);
          driver.findElement(By.id("userName")).sendKeys(r.getCell(3).getStringCellValue());
          driver.findElement(By.name("address1")).sendKeys(r.getCell(4).getStringCellValue());
          driver.findElement(By.name("city")).sendKeys(r.getCell(5).getStringCellValue());
          driver.findElement(By.name("state")).sendKeys(r.getCell(6).getStringCellValue());
          
          double p = r.getCell(7).getNumericCellValue();
          long y=(long)p;
          String postalcode = Long.toString(y);
          
          
          driver.findElement(By.name("postalCode")).sendKeys(postalcode);
          driver.findElement(By.name("country")).sendKeys(r.getCell(8).getStringCellValue());
          driver.findElement(By.id("email")).sendKeys(r.getCell(9).getStringCellValue());
          driver.findElement(By.name("password")).sendKeys(r.getCell(10).getStringCellValue());
          driver.findElement(By.name("confirmPassword")).sendKeys(r.getCell(11).getStringCellValue());
          driver.findElement(By.name("register")).click();
           String expected_username=r.getCell(9).getStringCellValue();
           String Actual_Result = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
           
           if(Actual_Result.contains(expected_username))
           {
        	   System.out.println("register_Successful");
        	   r.createCell(12).setCellValue("register successful");
           }
           else
           {
        	   System.out.println("Register_Failure");
        	   r.createCell(12).setCellValue("register_Failed");
           }
        
           FileOutputStream file1= new FileOutputStream("C:\\Projects\\Com.Validations\\src\\com\\ResultData\\NewTours_Result.xlsx");
           workBook.write(file1);
      driver.navigate().back();  
      
        }
    }
    @AfterTest
    public void teardown()
    {
    	driver.close();
    }
    
    
    }
    

