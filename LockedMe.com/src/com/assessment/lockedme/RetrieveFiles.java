package com.assessment.lockedme;

import java.io.File;
import java.util.Arrays;

public class RetrieveFiles {

	static void retrieveFiles(String location) throws Exception

	{

		String[] directoryFiles;
		try {
			File paths = new File(location);
			directoryFiles = paths.list();
			Arrays.parallelSort(directoryFiles);			
			System.out.println("List of files in the above given location is :\n");		

		for (String x : directoryFiles)
			System.out.println(x);
		
	}
	catch (Exception e) {
		
		System.out.println("Invalid folder location specified.");
		System.out.println("\nPlease select the option again and then enter a valid path.");
	}
	}

}
