package com.comb.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.testsuite.TestCase;
import com.testsuite.TestStep;
import com.testsuite.TestSuite;
@RunWith(Parameterized.class)
public class TestRunnerParam {
	private TestCase testCase;
	private static int num=1;
//	public SuiteRunner(){
//	}
	public TestRunnerParam(String suiteName,TestCase testCase){
		this.testCase=testCase;
	}
	@Parameters(name="{0}")
	public static Object[][] getTestCases(){
		Runner runner=new Runner("dataset.xml");
		TestSuite suite=runner.getTestSuite();
		List<TestCase> cases=suite.getTestCases();
		Integer num=cases.size();
		Object [][] test= new Object[num][2];
		for(int i=0;i<num;i++){
			test[i][0]=cases.get(i).getCaseName();
			test[i][1]=cases.get(i);
		}
		return test;
		
	}
	@Test
	public void runTest(){
		List<TestStep> steps = testCase.getTestSteps();
		System.out.println("**************Running No."+num+" Test Cases******************");
	//	System.out.println(steps.size());
		System.out.println(testCase.getCaseName());
		for(TestStep step:steps){
			System.out.println(step.getCommand()+"::"+step.getInputData());
		}
		num++;
	}
	
	
}
