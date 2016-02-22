package com.util.datacomb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import main.AllCombinations;
import main.EachChoice;
import main.Pairwise;


public class DataComb {
	
	private static Map<String,Integer> counter = new HashMap<String, Integer>();
	private  int totalReqs=0;
	private  int totalCall=0;
	
	public  int getTotalReqs(){
		return totalReqs;
	}
	public  int gettotalCall(){
		return totalCall;
	}
	public enum combType {
		AllComb("0"),EachChoice("1"),Pairwise("2");
		private String type;
		private combType(String type){
			this.type=type;
		}
		public String toString(){
			return type;
		}
	}


	
	public Set<List<String>>  genResultSet(List<List<String>> parameterInputValues){
		Set<List<String>> expectedResults = new HashSet<List<String>>();
		
		AllCombinations allComb = new AllCombinations(parameterInputValues);
		expectedResults=allComb.getCombinations();
		return expectedResults;
	}
	
	public static Set<List<String>>  genResultSet(List<List<String>> parameterInputValues,combType type){
		Set<List<String>> expectedResults = new HashSet<List<String>>();
		switch (type){
		case AllComb: //AllComb
		AllCombinations allComb = new AllCombinations(parameterInputValues);
		expectedResults=allComb.getCombinations();	
		break;
		case EachChoice: //EachChoice
		EachChoice eachChoice = new EachChoice(parameterInputValues);
		expectedResults=eachChoice.getCombinations();
		break;
		case Pairwise: //Pairwise
		Pairwise pairwise = new Pairwise(parameterInputValues);
		expectedResults=pairwise.getCombinations();
		break;	
		default : 
		}
		
		return expectedResults;
	}
	

	
	public static Map<String, String> genMap(List<String> dataBuffer,List<String> para){
		Map<String, String> bufferMap= new HashMap<>();
	     if (dataBuffer.size()==para.size()){
	    	 for(int i=0;i<para.size();i++)
	    		 bufferMap.put(para.get(i),dataBuffer.get(i));  
	        }  	
	     return bufferMap;
	}
	
	public static Set<Map<String, String>> genResultSet(List<List<String>> parameterInputValues,combType type,List<String> para){
		Set<List<String>> expectedResults=genResultSet(parameterInputValues, type);
		Set<Map<String, String>> mapset= new HashSet<Map<String,String>>();
	    Iterator result = expectedResults.iterator();
	        while(result.hasNext()){
	        	Map<String, String> map=  	genMap((List<String>) result.next(),para);
	        	mapset.add(map);
	        }  
	     return mapset;
	}
	

	private  void setCounter(String errorMsg) {
		if ( counter.containsKey(errorMsg)){
			System.out.println("\n value::"+counter.get(errorMsg));
			counter.put(errorMsg,counter.get(errorMsg).intValue()+1) ;
		} else {
			if(errorMsg !=null){
				counter.put(errorMsg, 1) ;//new error added.
			}
		}
	}
	
	
	public  Map<String,Integer> getCounter(){
		return counter;
	}
}
