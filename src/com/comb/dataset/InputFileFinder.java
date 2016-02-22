package com.comb.dataset;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class InputFileFinder {

    public static InputStream getInputFileAsStream(String file) {

    	File myFile = new File(file); 

    	InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(myFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return inputStream;
//        ClassLoader classLoader = InputFileFinder.class.getClassLoader();
//        return classLoader.getResourceAsStream(file);
    }

}
