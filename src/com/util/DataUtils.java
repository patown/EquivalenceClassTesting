package com.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataUtils {
	public static List genListFromMap(Map map){
		List list = new ArrayList();
		 list.addAll(map.values());
		 return list;
	}
}
