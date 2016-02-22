package com.comb.dataset.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.util.DataUtils;
import com.util.datacomb.CombType;



public class CombDataSetBean {
    //private List<ParaBean> paraBeans ; //as a map with method/class/paraBean
    private ParaBean paraBean;
    private List<List> iecList;
    private String name;
    private CombType combType;
    private Map<String,Map<String, List>> iecMap = new HashMap<String, Map<String,List>>();
    private Map<String, List> vecMap = new HashMap<>();
    private List<List<String>> allIECList = new ArrayList<List<String>>();
    public CombDataSetBean(ParaBean paraBean,String combType){
    	this.paraBean=paraBean;
    	this.combType=setCombType(combType);
     	setVECMap();
     	setIECMap();
     	setAllIECList();
    }
    public void genComb(String combType){
    //	return DataComb.genResultSet(parameterInputValues, combType);
    }
    private void setIECMap(){
    	HashMap<String, List> mapIEC= paraBean.getIECParas();
    	HashMap<String, List> mapVEC= paraBean.getVECParas();
    	 for (String key : mapIEC.keySet()) {
    	       HashMap<String, List> temp= (HashMap<String, List>) mapVEC.clone();//valid EC 
    	    		   //	   System.out.println("key= '"+ key + "' and value= " + temp.get(key));
    		   if(temp.containsKey(key)){ // one parameter using invalid EC 
    		   		temp.remove(key);
    		   		temp.put(key, mapIEC.get(key));
    		   //	  System.out.println("key= '"+ key + "' and value= " + temp.get(key));
    		   	} else {
    		   			temp.clear(); //key mismatch, clear this map
    		   		}    	
    		   	iecMap.put(key,temp); //add to the map list.
    		   //	temp.clear();
    	 	}	 
    	}
    
    private void setVECMap(){
    	vecMap= paraBean.getVECParas();
    	}
    
    public  Map<String, List> getListIEC(String key){
    	 		return iecMap.get(key);
    		  }
    public  Map<String, Map<String, List>> getMapIEC(){
 		return iecMap;
	  }
    public  List  getListVEC(){
    	return DataUtils.genListFromMap(vecMap);
    }	
    
    
    
    public List<List<String>> getAllIECList() {
		return allIECList;
	}
	public void setAllIECList() {
		this.allIECList = DataUtils.genListFromMap(paraBean.getIECParas());
	}
	public  String getName(){
    	return paraBean.getName();
    }	
    public CombType getCombType(){
    	return combType;
    }
	/**
	 * 
	 * @param String comType 	WEAK_NORNAMAL("0"),STRONG_NORNAMAL("1"),WEAK_ROBUST("2"),STRONG_ROBUST("3");
	 * @return CombType
	 */
	private CombType setCombType(String combType){
		switch (combType){
		case "0": 
		return CombType.WEAK_NORNAMAL;

		case "1": 
		return CombType.STRONG_NORNAMAL;

		case "2": 
		return CombType.WEAK_ROBUST;

		case "3": 
		return CombType.STRONG_ROBUST;
		default : 
		return null;
		}
	}
    
}
