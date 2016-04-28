package com.testsuite;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
	private String suiteName;
	private Integer suiteID;
	private List<TestCase> testCases= new ArrayList<>();
	public String getSuiteName() {
		return suiteName;
	}
	public Integer getSuiteID() {
		return suiteID;
	}
	public List<TestCase> getTestCases() {
		return testCases;
	}
	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}
	public void setSuiteID(Integer suiteID) {
		this.suiteID = suiteID;
	}
	public void setTestCases(List<TestCase> testCases) {
		this.testCases = testCases;
	}
	public void addTestCase(TestCase testCase) {
		this.testCases.add(testCase);
	}
}
