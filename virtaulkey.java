package virtual;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class virtual1 {
	  public static void main(String[] args) throws  InputMismatchException, IOException {
		
	        System.out.println("\t *****\n");
	        System.out.println("\tWelcome to The Application Lockedme.com \n");
	        System.out.println("\tDeveloper Priyavardhan");
	        System.out.println("\t *****\n");
	        Mainmenu();
			}
	    private static void Mainmenu() throws IOException {
	    	try {
	        String[] arr = {"1. Retrieving the file names in an ascending order",
	                "2. Business-level operations",
	                "3. Close the application"
	        };
	        System.out.println(" MAIN MENU");
	        int[] a = {1, 2, 3};
	        int len = a.length;
	        for(int i=0; i<len;i++){
	            System.out.println(arr[i]);
	            // display the all the Strings mentioned in the String array
	        }
	        
	        System.out.println("\nEnter your choice:\t");
	        Scanner sc = new Scanner(System.in);
	        int  options =  sc.nextInt();
	        
	                switch (options){
	                case 1:
	                	System.out.println("Names of the Files :\n");
	                	sortFile();
	                	System.out.print("\n");
	                	Mainmenu();
	                	break;
	                	
	                case 2:
	                	BusinessOperations();
	                	break;
	  			   
	  			   case 3:{
	  				   System.out.println("Closing your application \nThank you!");
	  				   break;
	  			   }
	  			   default :{
	  				   System.out.println("Entered option is incorrect \n"
	  				   		+ "Please choose the Correct Option");
	  				 System.out.print("\n");
	                	Mainmenu();
	                	break;
	  			   }
	                }   
	    }
	    	  catch(InputMismatchException e1) {
					System.out.println("please enter valid input");
					Mainmenu();
	    	  }}
	    
	    public static void sortFile() {
			File file=new File("C:\\temp\\");
			File[] Main=file.listFiles();
			for(File f: Main) {
				if(f.isFile())
					System.out.print(f.getName());
				System.out.print("\n");
			}
			
		}
	    public static void BusinessOperations() throws IOException {
	    	
	    	
			String[] arr1 = {"1. Add a user specified file to the application",
               "2. Delete a user specified file from the application",
               "3. Search a user specified file from the application",
               "4. Close the operations return to main menu" };
			int[] b = {1, 2, 3, 4};
			int len1 = b.length;
			for(int i=0; i<len1;i++){
				System.out.println(arr1[i]);
           // display the all the Strings mentioned in the String array
				}
			try {
			System.out.println("\nSelect your option :\t");
			Scanner s = new Scanner(System.in);
			int  option =  s.nextInt();
			
			
			switch(option) {
			case 1:{
				Creatingfile();
				System.out.print("\n");
		   		BusinessOperations();
		   		break;
		   		}
			case 2:{
				deleteFile();
				System.out.print("\n");
				BusinessOperations();
				break;
				}
			case 3:{
				searchFile();
				System.out.print("\n");
				BusinessOperations();
				break;
				}
			case 4:{
				System.out.println("Exit from the BLO menu");
				System.out.print("\n");
				Mainmenu();
				break;
				}
			default:{
				System.out.println("Entered option is incorrect \n"
						+ " Please Select Correct option");
				System.out.print("\n");
				BusinessOperations();
				} 
				}	
			}	
	    	catch( InputMismatchException e1) {
	    		System.out.println("select  valid option");
	    		BusinessOperations();
	    	}
  	
	    }
	    	
	    public static void Creatingfile() throws InputMismatchException, IOException {
			try {
	    	System.out.println("Enter how many file you want to create ? ");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			for(int i=0;i<n;i++) {
			System.out.println("Enter the filename :");
			Scanner sc1=new Scanner(System.in);
			String filename=sc1.next();
		    File file=new File("C:\\temp\\"+filename+".txt");
		    try {
		    	if(file.createNewFile()) {
					System.out.println("File has been created  Successfully ");
						
				}
				else {
					System.out.println("File already exists ");
					}
		    }
		   
		    catch(IOException e) {
				System.out.println("Error in creating file");
				
			}
		}
			
			}
			catch(InputMismatchException e1) {
				System.out.println("Please enter a valid input");
			}
	    }
			
			
	    
	
		public static void deleteFile()  {
	
			System.out.println("Enter the filename that you want to delete");
			Scanner sc=new Scanner(System.in);
			String deletefile=sc.next();
			File file=new File("C:\\temp\\"+deletefile+".txt");
		
			boolean present = file.exists();
			if(present==true) {
				file.delete();
				System.out.println(deletefile+" is deleted");}
			else {
	    	System.out.println(deletefile+" is not found"); }
		}
		
		public static void searchFile(){
			
				System.out.println("Enter the filename that you want to search");
				Scanner sc=new Scanner(System.in);
				String search=sc.next();
				File file=new File("C:\\temp\\"+search+".txt");
				try {
					FileReader Search=new FileReader(file);
					System.out.println("File is found in the directory list  ");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("File not found");
				}
			}
}
			
