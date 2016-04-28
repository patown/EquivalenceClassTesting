package com.testsuite;

public class TestStep { 
	private String stepName;
	private Integer stepID;
	private String command;
	private  String inputData;
	private String expectedData;
	private String backupString;
	public String getStepName() {
		return stepName;
	}
	public Integer getStepID() {
		return stepID;
	}
	public String getCommand() {
		return command;
	}
	public String getInputData() {
		return inputData;
	}
	public String getExpectedData() {
		return expectedData;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	public void setStepID(Integer stepID) {
		this.stepID = stepID;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public void setInputData(String inputData) {
		this.inputData = inputData;
	}
	public void setExpectedData(String expectedData) {
		this.expectedData = expectedData;
	}

	
}
