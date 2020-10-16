package GW.Guidewire.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Newperson_TestData {
	  @DataProvider(name = "New person")
	  public Object[][] f() throws IOException {
		  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\New person data.xlsx");
		  XSSFWorkbook wb = new XSSFWorkbook(fis);
		  XSSFSheet sh = wb.getSheetAt(0);
		  
		  Object[][] d= new Object[3][4];
		  
		  for(int i = 1; i<=3; i++) 
			  for(int j = 1; j<=4; j++) {
			 d[i-1][j-1] = sh.getRow(i).getCell(j).getStringCellValue();
		  }
		return d;	  
	  }
	}
