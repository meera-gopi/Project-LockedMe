package com.assessment.lockedme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BusinessLevelOperations {

	private String folderPath,filename, data;
	private Path path;

	//Constructor with no parameters
    public BusinessLevelOperations() {
		super();
	}

    //Constructor with field names
	public BusinessLevelOperations(String folderPath,String filename)  {
		super();
		this.folderPath = folderPath.trim();
		this.filename = filename.trim();		
		path = Paths.get(this.folderPath, this.filename);
	}

	@Override
	public String toString() {
		return "BusinessLevelOperations [folderPath=" + folderPath + "\nfilename=" + filename + "\npath=" + path + "]";
	}

	// setter for data
	public void setData(String data) {
		this.data = data;		
	}
	
// Check if the filename entered exist already for creating new file			
	protected boolean existingFile() {
	if(Files.exists(path)) {
		
			System.out.println("\nFile with the same name already exists. Please reenter the folder and filename deails.\n");			
			
		}	
		return (Files.exists(path));
	}

	//Create file
	protected void createFile() throws Exception {

		if (!(Files.exists(path))) {
			if (data == null)
				Files.createFile(path);
			else
				Files.write(path, data.getBytes(), StandardOpenOption.CREATE);
			
			System.out.println( "Successfully created the file "+filename + "\n");

		} else {
			throw new IOException("File with the same name already exists"+ "\n");
		}

	}

	
	//Delete file
	protected void deleteFile() throws IOException {

		
			if (Files.deleteIfExists(path)) {
				System.out.println("\nFile is deleted from the location");}
			
		
	else{
		System.out.println();
		throw new IOException("\nFile entered doesn't exist in the location"
				+ "\nPlease make sure if the enterd file name is correct and is entered with correct extension");
		}
	}

	//Search file
	protected void searchFile() throws IOException, NoSuchFileException {

		if (Files.exists(path))
			System.out.println("File is present in the location");
		else {
			System.out.println("File doesn't exist in the specified location");
		}
		
	}
}