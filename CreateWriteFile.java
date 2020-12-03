//Creating Deleting and Writing file at one.

import java.util.*;
import java.io.*;

class CreateWriteFile{
	public static void main(String[] args){
		Scanner intInput = new Scanner(System.in);
		Scanner userInput = new Scanner(System.in);
		int choice = 0;
		String fileName;
		String Temp;
		int exitView=0;
		System.out.println("Creating, Deleting and Writing File.");
		do{
			System.out.println("Select Your prefrence from one below.");
			System.out.println("1. Create a File.");
			System.out.println("2. Write a File.");
			System.out.println("3. Delete a File.");
			System.out.println("4. Get File Information.");
			System.out.println("5. Read the file.");
			System.out.println("6. Exit from a program.");
			choice = intInput.nextInt();
			switch(choice){
				case 1:
				System.out.println("Write a file name with extension.");
				fileName = userInput.nextLine();
				try{
					File createFile = new File(fileName);
					if(createFile.createNewFile()){
						System.out.println("Your File Created : " + createFile.getName());
					}else{
						System.out.println("File already exist.");
					}
				}catch(IOException e){
					System.out.println("An error Occured.");
					e.printStackTrace();
				}
				
				
				
				
				break;
				
				case 2:
				System.out.println("Enter file Name you want to write on.");
				fileName = userInput.nextLine();
				try{
					File tempFileObj = new File(fileName);
					if(tempFileObj.exists()){
							FileWriter writeFile = new FileWriter(fileName);
							System.out.println("Write a data you want on a file : " + fileName);
							Temp = userInput.nextLine();
							writeFile.write(Temp);
							writeFile.close();
							System.out.println("Successfuly Write to the file : " + fileName);
						}else{
							System.out.println("File Does't Exists.");
						}
				}catch(IOException e){
					System.out.println("An Error Occured.");
					e.printStackTrace();
				}
				
				
				
				break;
				
				case 3: 
				System.out.println("Enter file Name you want to delete with extension.");
				fileName = userInput.nextLine();
				File deleteFile = new File(fileName);
				if(deleteFile.delete()){
					System.out.println("Your file is deleted.");
				}else{
					System.out.println("Failed to delete the file.");
				}
				
				
				break;
				
				case 4:
				System.out.println("Enter File Name whose Information you want.");
				fileName = userInput.nextLine();
				File tempFileObj = new File(fileName);
				if(tempFileObj.exists()){
					System.out.println("File Name : " + tempFileObj.getName());
					System.out.println("Absolute path : " + tempFileObj.getAbsolutePath());
					System.out.println("File is Readable or not : " + tempFileObj.canRead());
					System.out.println("File is Writable or not : " + tempFileObj.canWrite());
					System.out.println("File size in Bytes : " + tempFileObj.length());
				}else{
					System.out.println("File Does't Exists, Plese Enter Correct name of file with extension.");
				}
				
				
				break;
				
				case 5:
				System.out.println("Enter file name whose Data You want to read");
				fileName = userInput.nextLine();
				File tempFileObj2 = new File(fileName);
				if(tempFileObj2.exists()){
					try{
						if(tempFileObj2.canRead()){
							Scanner fileReading = new Scanner(tempFileObj2);
							while(fileReading.hasNextLine()){
								System.out.println(fileReading.nextLine());
							}	
						}else{
							System.out.println("File can\'t be Read.");
						}
					}catch(FileNotFoundException e){
						System.out.println("An error Occured.");
						e.printStackTrace();
					}
				}else{
					System.out.println("File Name Does\'t exist, Be sure to provide file name with extension.");
				}
				
				
				break;
				
				case 6: 
				System.out.println("\n Exiting From the program......");
				break;
				
				default : 
				System.out.println("Wrong Input please try again.");
			}
			
			
		}while(choice != 6);
		
	}
}