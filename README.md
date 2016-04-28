Automatically gen comb result for given Equivalence Class Testing

0£© weak normal 
1) strong normal 
2) weak robust 
3) strong robust

**************************************************
Below is the usage example:

package com.comb.controller;

import org.junit.Test;

public class TestRunner { 
@Test 
public void TestRun()
{ 
	Runner runner=new Runner("dataset.xml"); 
	runner.run(); 
}
}
**************************************************
Data-driven feature is added using Junit @Parameters. Please check class:

com.comb.controller.TestRunnerParam 
**************************************************
This project is based on the following project:

https://github.com/ernestocid/datacomb