package com.util.map;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MapUtil {
	
	public static Map getValue(Object thisObj)  
	  {  
	    Map map = new HashMap();  
	    Class c;  
	    try  
	    {  
	      c = Class.forName(thisObj.getClass().getName());  
	      Method[] m = c.getMethods();  
	      for (int i = 0; i < m.length; i++)  
	      {  
	        String method = m[i].getName();  
	   //     System.out.println(method);
	        if (method.startsWith("get") && method.compareTo("getClass") !=0)  
	        {  
	          try{  
	          Object value = m[i].invoke(thisObj);  
	          if (value != null)  
	          {  
	            String key=method.substring(3);  
	         //  System.out.print("\nkey is ::"+key+"\n");
	            key=key.substring(0,1).toLowerCase()+key.substring(1);  
	            map.put(key, value);  
	          }  
	          }catch (Exception e) {  
	            // TODO: handle exception  
	            System.out.println("error:"+method);  
	          }  
	        }  
	      }  
	    }  
	    catch (Exception e)  
	    {  
	      // TODO: handle exception  
	      e.printStackTrace();  
	    }  
	    return map;  
	  }  

}
