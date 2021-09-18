package com.assessment.lockedme;

public class LockedMeDotCom {
	public static void main(String[] args) throws Exception{
		int main_choice, choice;
		UserInterfaceMenu ui = new UserInterfaceMenu();
		LockedLoop locked = new LockedLoop();
		// Main menu Loop
		ui.welcomeScreen();
		while (locked.isLocked()) {
			main_choice = ui.mainMenu();
			if (main_choice<0) {
				main_choice = ui.mainMenu();
			}
			switch (main_choice) {

			case 1:// Getting a sorted list of files in location specified by user
				String location = ui.getFolderPath();
				RetrieveFiles.retrieveFiles(location);
				ui.lineSeperator();
				break;
			case 2:// User can access Business Level operations through this case
					// Business Level Operation Loop
				while (locked.isBloLoop()) {
					choice = ui.businessUserOptions();	
					if(choice<0) {
						choice = ui.businessUserOptions();
					}
					BusinessLevelOperations blo = ui.getDetails(choice);					
					switch (choice) {
					case 1:// Create file
						if(blo.existingFile()) {	
							ui.lineSeperator();
							blo = ui.getDetails(choice);							
							}						
						String data = ui.enterData();
						blo.setData(data);						
						blo.createFile();
						ui.lineSeperator();
						break;
					case 2:// delete file
						try {
							blo.deleteFile();							
						} catch (Exception e) {							
							System.out.println(e);
						}
						ui.lineSeperator();
						break;
					case 3:// search file
						blo.searchFile();
						ui.lineSeperator();
						break;
					case 4:// go back to main menu
						locked.setBloLoop(false);
						ui.lineSeperator();
						break;
					}
				}
				break;
			case 3:
				ui.exitScreen();				
				break;
			}
		}

	}

}
