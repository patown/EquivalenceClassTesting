package com.comb.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.comb.dataset.InputFileDigester;
import com.comb.dataset.InputFileFinder;
import com.comb.dataset.beans.ActionBean;
import com.comb.dataset.beans.CombDataSetBean;
import com.comb.dataset.beans.ItemBean;
import com.comb.dataset.beans.ParaBean;
import com.testsuite.TestCase;
import com.testsuite.TestStep;
import com.testsuite.TestSuite;
import com.util.datacomb.Comb;



public class Runner {

    private List<ActionBean>  actionBeans = new ArrayList<ActionBean>();
    private List<CombDataSetBean> combDataSets= new ArrayList<CombDataSetBean>();
    private String file;
    private TestSuite testSuite= new TestSuite();
    public Runner(String file){
    	this.file = file;
    	initializeDataSet(file);
    	doComb();
		System.out.println("********************************\n"+
		"WEAK_NORNAMAL(\"0\") ,"
		+ "STRONG_NORNAMAL(\"1\"),"
		+ " WEAK_ROBUST(\"2\"),"
		+ "STRONG_ROBUST(\"3\")");
		System.out.println("********************************");
		run();
    }
    
    private  void initializeDataSet(String file) {
        try {
            // Read in any input parameters, if an input file is found
            InputStream in = InputFileFinder.getInputFileAsStream(file);
            if (in != null) { // Found an input file for this test
                InputFileDigester digester = new InputFileDigester(in);
                actionBeans = digester.getActionBeans();
            } else {
            	System.out.println("Input file now found:"+file);
            }
            
        } catch (Exception e) {
           e.printStackTrace();
        }

    }
    
    private void doComb(){
    	for(ActionBean bean:actionBeans){
//    		System.out.println("****************");
//    		System.out.println("Now combining '"+bean.getName()+"'  combType("+bean.getComb()+")");
    		List<ItemBean> itemBeans =bean.getItemBeans() ;
    		ParaBean paraBean=new ParaBean(bean.getName());
    		HashMap<String, List> vECParas = new HashMap<>();	
    		HashMap<String, List> iECParas = new HashMap<>();	
    		for(ItemBean itemBean:itemBeans){
    			String itemName=itemBean.getName();
//        		System.out.println("Now using paramter :");
//        		System.out.println("VEC paramters:");
//        		System.out.println("IEC paramters :"+itemBean.getIECList());
        		vECParas.put(itemName, itemBean.getVECList());
        		iECParas.put(itemName, itemBean.getIECList());
    	}
    		paraBean.setIECParas(iECParas).setVECParas(vECParas);
    		CombDataSetBean combDataSet = new CombDataSetBean(paraBean,bean.getComb());
    		combDataSets.add(combDataSet);
    }
    	
    }	
    public List<CombDataSetBean> getDataSet(){
    	return  combDataSets;
    }
    public void run(){
    	List<TestCase> testCases=new ArrayList<>();
    	for(CombDataSetBean dataSet: combDataSets){
//    		System.out.println("********************************");
//     		System.out.println("action = '"+dataSet.getName()+"' combtype='"+dataSet.getCombType()+"'");
//    		System.out.println("VEC::"+dataSet.getListVEC());
//    		System.out.println("IEC::"+dataSet.getAllIECList());
//     		System.out.println("****************");
//     		System.out.println("***CombResult***");
//     		System.out.println("****************");
     		//System.out.println(Comb.genResultSet(dataSet).toString());
     		
     		//exec(Comb.genResultSet(dataSet),dataSet.getName()+"."+dataSet.getCombType());
     		testCases.addAll(setTestCases(Comb.genResultSet(dataSet),dataSet.getName(),dataSet.getCombType().toString()));
     		System.out.println("********************************");
  	}
    	testSuite.setTestCases(testCases);
    }

    public TestSuite getTestSuite(){
    	return testSuite;
    }
    private void exec(Set<List<String>> datas,String prefix){
    	int num=0;
    	 for (Iterator iter = datas.iterator(); iter.hasNext();) {
    		 List<String> list =(List<String>) iter.next();
    		  System.out.println(prefix+"."+num+"::"+list.toString());
    		  num++;
    		 }

    }
    private  List<TestCase> setTestCases(Set<List<String>> datas,String command,String prefix){
        List<TestCase> testCases= new ArrayList<>();
    	int num=0;
    	 for (Iterator iter = datas.iterator(); iter.hasNext();) {
    		 List<String> list =(List<String>) iter.next();
    		 TestCase testCase=new TestCase();
    		 TestStep testStep=new TestStep();
    		 testStep.setCommand(command);
    		 testStep.setStepID(1);
    		 testStep.setInputData(list.toString());
    		 testCase.addTestStep(testStep);
    		 testCase.setCaseName(command+"."+prefix+"."+num);
    		 testCases.add(testCase);
    		  num++;
    		 }
    	 return testCases;
    }
    
	}
