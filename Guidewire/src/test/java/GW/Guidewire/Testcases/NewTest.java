package GW.Guidewire.Testcases;

import org.testng.annotations.Test;

import GW.Guidewire.base.baseclass;

public class NewTest extends baseclass {
  @Test
  public void f() {
	  test = report.createTest("new test");
	  driver.get("http://localhost:4949/");
	  
  }
}
