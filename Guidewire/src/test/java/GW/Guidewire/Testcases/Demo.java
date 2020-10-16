package GW.Guidewire.Testcases;

import org.testng.annotations.Test;

import GW.Guidewire.base.baseclass;

public class Demo  {
  @Test(groups = {"regration"} )//priority =0
  public void f() {
	  System.out.println("regration suite run succesfully");
  }
  @Test(groups = {"sanity"})
  public void g() {
	  System.out.println("Sanity suite run succesfully");
  }
  @Test(groups = {"regration","sanity"})
  public void h() {
	  System.out.println("regration & sanity suite run succesfully");
  }
  
}
