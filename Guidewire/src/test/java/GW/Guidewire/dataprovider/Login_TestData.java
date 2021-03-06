package GW.Guidewire.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_TestData {
  @DataProvider(name = "login")
  public Object[][] f() throws IOException {
	  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\login data.xlsx");
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sh = wb.getSheetAt(0);
	  
	  Object[][] d= new Object[1][4];
	  
	  for(int i = 1; i<=1; i++) //sh.getLastRowNum()
		  for(int j = 1; j<=4; j++) {
		 d[i-1][j-1] = sh.getRow(i).getCell(j).getStringCellValue();
	  }
	return d;	  
  }
}
