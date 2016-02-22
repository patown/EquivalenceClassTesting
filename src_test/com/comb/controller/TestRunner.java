package com.comb.controller;

import org.junit.Test;

public class TestRunner {
	@Test
	public void TestRun(){
		Runner runner=new Runner("dataset.xml");
		runner.run();
	}
}
