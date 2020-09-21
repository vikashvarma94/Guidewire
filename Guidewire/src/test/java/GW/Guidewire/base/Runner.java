package GW.Guidewire.base;

import org.testng.TestNG;

import GW.Guidewire.Testcases.Tc1_login;
import GW.Guidewire.Testcases.Tc2_login;




@SuppressWarnings("unused")
public class Runner {
	static TestNG testNG;

  public static void main(String []args) {
	  
	  testNG = new TestNG();
	  testNG.setTestClasses(new Class[] {Tc1_login.class,Tc2_login.class});
	  testNG.run();
  }
}
