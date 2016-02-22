package com.comb.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.comb.dataset.InputFileDigester;
import com.comb.dataset.InputFileFinder;
import com.comb.dataset.beans.ActionBean;
import com.comb.dataset.beans.CombDataSetBean;
import com.comb.dataset.beans.ItemBean;
import com.comb.dataset.beans.ParaBean;
import com.util.datacomb.Comb;



public class Runner {

    private List<ActionBean>  actionBeans = new ArrayList<ActionBean>();
    private List<CombDataSetBean> combDataSets= new ArrayList<CombDataSetBean>();
    private String file;
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
    public void run(){
    	for(CombDataSetBean dataSet: combDataSets){
    		System.out.println("********************************");
     		System.out.println("action = '"+dataSet.getName()+"' combtype='"+dataSet.getCombType()+"'");
    		System.out.println("VEC::"+dataSet.getListVEC());
    		System.out.println("IEC::"+dataSet.getAllIECList());
     		System.out.println("****************");
     		System.out.println("***CombResult***");
     		System.out.println("****************");
     		System.out.println(Comb.genResultSet(dataSet).toString());
    		System.out.println("********************************");
    	}
    }
	}
