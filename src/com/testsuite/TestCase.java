package com.testsuite;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
	private String testSuite;
	private String caseName;
	private Integer caseID;
	private List<TestStep> testSteps= new ArrayList<>();
	public String getCaseName() {
		return caseName;
	}
	public Integer getCaseID() {
		return caseID;
	}
	public List<TestStep> getTestSteps() {
		return testSteps;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public void setCaseID(Integer caseID) {
		this.caseID = caseID;
	}
	public void setTestSteps(List<TestStep> testSteps) {
		this.testSteps = testSteps;
	}
	public void addTestStep(TestStep testStep) {
		this.testSteps.add(testStep);
	}
	
}
