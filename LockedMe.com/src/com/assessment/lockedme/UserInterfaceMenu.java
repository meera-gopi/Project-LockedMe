package com.assessment.lockedme;


import java.util.Scanner;


public class UserInterfaceMenu {

	Scanner sc = new Scanner(System.in);	
	
	protected void welcomeScreen() {
		System.out.println("\n********* Welcome to LOCKEDME.COM  ********");
		System.out.println("\n....................................................................................................");
		System.out.println("Application Type : Prototype");
		System.out.println("Developed by      : Meera Gopi");
		lineSeperator();	
		System.out.println("LockedMe.com - Virtual key for Your Repositories.This application helps you to add or delete \nspecific files"
				+ "from your application.This application also allows you to search a specific file for \nits presence or give you the "
				+ "list of all files in the location specified in ascending order.\nSelect the operation you want to perform from the main menu.\n");
		
		lineSeperator();
	}
	
	
	//Method for Welcome Screen and Main Menu and user input collection
	protected int mainMenu() {
		
					
		System.out.println("\nMain Menu");
		System.out.println("*********\n");
		System.out.println("1. Retrieve file names.\n");
		System.out.println("2. Business Level Operations\n");
		System.out.println("3. Close the application\n");
		System.out.println();
		System.out.print("Please enter your choice here - ");
		try {
			int main_choice = Integer.parseInt(sc.nextLine());
			if(!(main_choice==1||main_choice==2||main_choice==3)) {
				System.out.println("\nInvalid choice\n");
				businessUserOptions();
			}
			lineSeperator();
			return main_choice;
		} catch (NumberFormatException e) {
			System.out.println("\n"+e+" -- Expected input is a number between 1 and 3, including both the numbers.");
			lineSeperator();
			return -1;
		}
		
	}
	//Method for Business Operations Menu and user input collection	
	protected int businessUserOptions() {
		
		System.out.println("\nBusiness Level Operations available to your account are listed in Operations Menu");
		lineSeperator();
		System.out.println("Operations Menu");
		System.out.println("***************\n");
		System.out.println("1. Create File\n");
		System.out.println("2. Delete File\n");
		System.out.println("3. Search File\n");
		System.out.println("4. Go back to the Main Menu\n");
		lineSeperator();
		System.out.print("\nPlease enter the action you want to perform here : ");
		try {
			int choice = Integer.parseInt(sc.nextLine());
			if(!(choice==1||choice==2||choice==3||choice==4)) {
				System.out.println("\nInvalid choice\n");
				businessUserOptions();
			}
			
			System.out.println("\nWhen you chhose any operations other than going back to the main menu, the system will ask for a path(File location excluding filename)"
					+ " and file name.\nPlease make sure the entered path is accurately pointing to the folder associated to your account."
					+ "\n The entered file name will be used for the selected actions....");
			lineSeperator();
			return choice;
		} catch (NumberFormatException e) {
			System.out.println("\n"+e+"  -- Expected input is a number between 1 and 4, including both the numbers.");	
			lineSeperator();
			return -1;
		}
	}
	
	protected void lineSeperator() {
		System.out.println("....................................................................................................\n");
	}

	//getting the path
	protected String getFolderPath() throws Exception {		
		System.out.print("Please enter the path - ");
		String location = sc.nextLine();
		String[] s = location.split(" ");
		if (s.length>1 || s.length<1) {
			System.out.println("\nEntered path is invalid.Please Enter valid folder path");
			lineSeperator();
			getFolderPath();}
		lineSeperator();
		return location;
	}

	//getting file name
	protected String getFileName() {
		System.out.print("\nPlease enter the file Name - ");
		String filename = sc.nextLine();
		lineSeperator();
		return filename;
	}

	//Initialize the BusinessLevelOperations class with user provided data
	protected BusinessLevelOperations getDetails(int choice) throws Exception {		
		if (choice == 1 || choice == 2 || choice == 3) {
			String location = getFolderPath();
			String filename = getFileName();
			BusinessLevelOperations blo = new BusinessLevelOperations(location,filename);			
			return blo;
		} else {
			
			BusinessLevelOperations blo = new BusinessLevelOperations();
			return blo;}		
	}

	//Entering data to newly created file if choose to
	protected String enterData() {
		lineSeperator();
		System.out.println("Please enter (Y/N) according to your wish to enter any data to the new file.\n");		
		System.out.print("Please enter your choice - ");
		char dataEntry = sc.nextLine().charAt(0);
		if (dataEntry == 'Y' || dataEntry == 'y') {
			System.out.print("\nPlease enter the information that you want to add to the file in a single line after the symbol '-' in the console .Press enter once completed the entry.");
			System.out.print("\n-");
			String info = sc.nextLine();
			lineSeperator();
			return info;
		}

		else {
			return null;
		}
	}

	//Exit screen message
	protected void exitScreen() {
		sc.close();
		System.out.println("\n\n          Thank you for visiting LockedMe.com          ");
		System.exit(0);		
	}
}
