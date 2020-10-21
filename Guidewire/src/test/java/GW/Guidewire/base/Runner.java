package GW.Guidewire.base;

import org.testng.TestNG;

import GW.Guidewire.Testcases.Tc1_Login;
import GW.Guidewire.Testcases.Tc2_Batchprocess;




@SuppressWarnings("unused")
public class Runner {
	static TestNG testNG;

  public static void main(String []args) {
	  
	  testNG = new TestNG();
	  testNG.setTestClasses(new Class[] {Tc1_Login.class,Tc2_Batchprocess.class});
	  testNG.run();
  }
}
