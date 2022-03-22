package com.project.phase1FSD;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import com.project.phase1FSD.UserDetails;
import com.project.phase1FSD.fileView;

public class FileProcess {
	
	private static Scanner input;
	private static Scanner readDBFile;
	private static UserDetails UDetails;
	private static PrintWriter collectData;
	static String DirectoryPath;
	static File FileCreation;
		
	public static void dirCreation() {
		DirectoryPath = System.getProperty("user.dir");
		FileCreation = new File(DirectoryPath+"/Database");
		if(!FileCreation.exists()) 
			FileCreation.mkdirs();
		System.out.println("File Path " + DirectoryPath);
	}

	public static void greetMessage() throws InterruptedException {
		System.out.println("||-------------------------------------||");
		System.out.println("||*********************************||");
		System.out.println("||     WELCOME TO LOCKEDME.APP     ||");
		System.out.println("||     DEVELOPER : KASHINATH.M.J   ||");
		System.out.println("||*********************************||");
		System.out.println("||-------------------------------------||");
	    }

	public static void signUp() throws IOException {
			
			System.out.println("==========================================");
			System.out.println("*       WELCOME TO REGISTRATION PAGE	    *");
			System.out.println("*   Sit Back - Relax - Save your Passocde	*");
			System.out.println("==========================================");
		try {	
			System.out.println("User, Kindly Provide your Creds!");
			System.out.print("Enter your Username: ");
			String userID = input.next();
			UDetails.setUserName(userID);//
			
			System.out.print("Enter your Password : ");
			String passCode = input.next();
			UDetails.setPassword(passCode);
			
			System.out.println("Congrats! User registered successfully");
			
			collectData.println(UDetails.getUserName());
			collectData.println(UDetails.getPassword());
			
			collectData.close();
			mainMenu();
		   }catch(Exception e) {
			   signUp();
		   }
		   }
	
	public static void signIn() throws Exception {
			System.out.println("*============================================*");
			System.out.println("*            WELCOME TO LOGIN PAGE           *");
			System.out.println("=============================================*");
		try {	
			System.out.println(" Kindly, Provide the Creds to Logon");
			System.out.print("\n Enter Username : ");
			String inname = input.next();
			boolean found = false;
			while(readDBFile.hasNext() && !found) {
				if(readDBFile.next().equals(inname)) {
					System.out.print(" Enter Password : ");
					String inpassCode = input.next();
					if(readDBFile.next().equals(inpassCode)) {
						System.out.println("      User In!     \n");
						found = true;
	                dirCreation();
	                showMenu();
					}
				}
				}if(!found) {
					System.out.println("User not Found");
					System.out.println("\n 3.exit ");
					Scanner sc = new Scanner(System.in);
					int chance = sc.nextInt();
					switch(chance) {
					
					case 3:{ break; }
					default:{ System.out.println("Invalid Data"); 
					mainMenu(); 
					
					}
					}
				}
		}catch (Exception e) {
			
			mainMenu();
		}
	}

	public static void mainMenu() throws  Exception {
		System.out.println("*             Here We GO!!              *");
		System.out.println("==========================================");
		System.out.println("*         WELCOME TO MAIN MENU	        *");
		System.out.println("==========================================");
		
		System.out.println("\nSelect an option from below \n 1-> Sign up\n 2-> Sign in\n 3-> Exit");
	try {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your Choice : ");
		int Option = sc.nextInt();
		
		switch(Option) {
		case 1:{ signUp(); }
		
		case 2:{ signIn(); }
		
		case 3:{ exitScreen();
				System.exit(1);}
		
		default:{ System.out.println("Invalid Data, Try Again!"); mainMenu(); }
		}
		}catch(Exception e) {
			System.out.println("Invalid Data, Please Try Again");
			mainMenu();
		}	
	    }
	
	public static void showMenu() throws Exception {
		System.out.println(" ");
		System.out.println("The Locker with Creds!");
		Thread.sleep(1000);
		System.out.println("==========================================");
		System.out.println("*        ENTERED INTO LOCKEDME.APP 	     *");
		System.out.println("==========================================");
		System.out.println(" ");
		System.out.println("\n1-> List Files in DirectoryPath \n2-> Add, Search or Delete File in the DirectoryPath \n3 ->Show All Files\n4-> Exit");
		try {
		System.out.print("Enter your Choice : ");
		Scanner sc = new Scanner(System.in);
		int option1 = sc.nextInt();
		switch(option1) {
		case 1:{ listFiles(); }
		try {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("\n1-> Return to Locker\n2-> Exit");
		System.out.print("Enter your Choice : ");
		int op = sc1.nextInt();
		switch(op) {
		case 1 :{ showMenu(); }
		case 2 :{ break; }
		default:{ System.out.println("Invalid Data"); showMenu();}
		}
		}catch(Exception e) {
			System.out.println("Invalid Data"); showMenu();
		}
		case 2:{ showOperations(); }
		
		case 4: { exitScreen();
			   System.exit(option1); }
		case 3 : {
			fileView.ascendingOrder();
			showMenu();

		}
		default:{ System.out.println("Invalid Input"); showMenu();}
		}}catch(Exception e) {
			showMenu();
		}
		
	}
	public static void exitScreen() {
		System.out.println("*============================================*");
		System.out.println("*                  THANK YOU                 *");
		System.out.println("*                VISIT US AGAIN!             *");
		System.out.println("=============================================*");
		System.out.println("\n");	
		}

	public static void listFiles() {
	try {
		if(FileCreation.list().length==0) {
			System.out.println("Folder is empty");
		}else {
		System.out.println("\nThe Files Available in " + DirectoryPath + " are : ");
		String[] lists = FileCreation.list();
		Arrays.sort(lists);
		for(String view : lists) {
			System.out.println(view);
		}
		}
	}catch(Exception e) {
		e.getMessage();
	}
	}
	
	public static void showOperations() throws IOException {
		System.out.println("\n1.Add New File\n2.Delete Existing File\n3.Search File\n4.Return to Locker");
		try {	
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your Choice : ");
		int option3 = sc.nextInt();
		
		switch(option3) {
		case 1:{ System.out.println("Enter File Name : ");
		Scanner sc2 = new Scanner(System.in);
		String Name = sc2.next().trim().toLowerCase(); 
		addFile(Name);
		showMenu();
		break;
		}
			case 2:{ System.out.println("Enter File Name to Delete : ");
			Scanner sc4 = new Scanner(System.in);
			String name2 = sc4.next().trim();
			deleteFile(name2);
			showMenu();
			break;
			}
			case 3:{System.out.println("Enter the File Name to Check Status : ");
			Scanner sc5 = new Scanner(System.in);
			String sc7 = sc5.next().trim();
			searchFile(sc7);
			showMenu();
			break;
			}
			case 4:{ showMenu();}
			default:{ System.out.println("Invalid Input");	}
			showOperations();
			break;
		}
	}catch(Exception e) {
		System.out.println("Invalid Input");
		showOperations();
	}
	}
	
	public static void addFile(String name) throws IOException {
		
		File filec = new File(FileCreation+"/"+name);
		String list1[] = FileCreation.list();
		for(String namecheck : list1) {
			if(name.equalsIgnoreCase(namecheck)) {
				System.out.println("File already exists in the folder");
			return ;
			}
		}
		filec.createNewFile();
		boolean res = filec.createNewFile();
		if(!res) System.out.println("File Created Successfully");	
	}
	
	public static void deleteFile(String name) {
		File file = new File(FileCreation+"/"+name);
		String[] list = FileCreation.list();
		for(String view1 : list) {
			if(name.equals(view1) && file.delete()) {
				System.out.println("File Deleted Successfully");
				return ;
			}
		}
		System.out.println("File Not Found");
	}
	
	public static void searchFile(String Name) {
		new File(FileCreation+"/"+Name); 
		String[] list = FileCreation.list();
		for(String str : list) {
			if(Name.equals(str)) {
				System.out.println("File Found");
				return ;
			}
		}
		System.out.println("File Not Found");
	} 
	
	
	public static void fileSupport() throws IOException{
		File file = new File("MainSrc.txt");
		file.createNewFile();
		try {	
			input = new Scanner(System.in);
			readDBFile = new Scanner(file);
			file.createNewFile();
			collectData = new PrintWriter(new FileWriter(file,true));
			UDetails = new UserDetails();
		}catch(Exception e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}
	    }
        }