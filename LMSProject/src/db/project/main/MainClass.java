package db.project.main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import db.project.LMSdao.LMSDao;
import db.project.model.Book;
import db.project.util.DatabaseConnect;

	public class MainClass {
		private static Book[] Books;

		public static void main(String[] args) {
			String months[] = {
		            "Jan",
		            "Feb",
		            "Mar",
		            "Apr",
		            "May",
		            "Jun",
		            "Jul",
		            "Aug",
		            "Sep",
		            "Oct",
		            "Nov",
		            "Dec"
		        };
		
		Calendar calendar = Calendar.getInstance();
        
        
	    
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("*** Welcome to ITVedant Library Management System Project ***");
			System.out.println("--------------------------------------------------------------------------------");
			
			System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " 
				      + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
				
				System.out.println("\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) +
						 ":" + calendar.get(Calendar.MINUTE) + ":" +
						      calendar.get(Calendar.SECOND));
				System.out.println("--------------------------------------------------------------------------------");
			try {
			Scanner s= new Scanner(System.in);
			BufferedReader s1 = new BufferedReader (new InputStreamReader(System.in));
			LMSDao  LMSDao  = new LMSDao();
			int choice;
			
			while(true) {
				System.out.println("1. Insert New Book");
				System.out.println("2. Update Record");
				System.out.println("3. Delete Record");
				System.out.println("4. Search By ID");
				System.out.println("5. Display all Books");
				System.out.println("6. Exit");
				System.out.println("--------------------------------------------------------------------------------");
				
				
				choice = s.nextInt();
				int Id;
				String TITLE,AUTHOR,GENRE;
				
				
				if(choice == 6 )
					break;
				else
					switch(choice) {
					
					
					case 1:System.out.println("Enter ID:");
							Id= s.nextInt();
							System.out.println("Enter TITLE");
							TITLE=s1.readLine();
							System.out.println("Enter AUTHOR");
							AUTHOR=s1.readLine();
							System.out.println("Enter GENRE");
							GENRE = s1.readLine();
							boolean result = LMSDao.insertRecord(Id,TITLE, AUTHOR, GENRE);
							if(result)
								System.out.println("Inserted Successfully");
							else
								System.out.println("Not Inserted");
					
						break;
					case 2: System.out.print("Enter the ID of the Book:");
			 		 	Id = s.nextInt();
			 		 	Book b =LMSDao.searchById(Id);
			 		 	System.out.println("What do you want to update?");
			 		 	System.out.println("1. TITLE");
			 		 	System.out.println("2. AUTHOR");
			 		 	System.out.println("3. GENRE");
			 		 	int update = s.nextInt();
			 		 	switch (update) {
			 		 		case 1: System.out.println("Enter New TITLE:");
			 		 			TITLE = s1.readLine();
			 		 			b.setTITLE(TITLE);				 		 	 
						break;
			 		 		case 2: System.out.println("Enter New AUTHOR:");
			 					AUTHOR =s1.readLine();
			 					b.setAUTHOR(AUTHOR);				 		 		
		 		 		break;
			 		 		case 3: System.out.println("Enter New GENRE:");
			 					GENRE= s1.readLine();
			 					b.setGENRE(GENRE);
		 		 		break;
		 		 }
		 		result = LMSDao.updateRecord(b);
		 		if(result)
					System.out.println("Updated Successfully");
				else
					System.out.println("Not Updated");
		 			break;
					case 3: System.out.print("Enter the ID of the student:");
			 		 	Id = s.nextInt();	
			 		 	result = LMSDao.deleteRecord(Id);
			 		 	if(result)
			 		 		System.out.println("Deleted Successfully");
			 		 	else
			 		 		System.out.println("Not Deleted");
						break;
					case 4: System.out.println("Enter The Id of the Student");
							Id = s.nextInt();
							Book b1 = LMSDao.searchById(Id);
							if(b1.getId()!=0)
								System.out.println(b1);
					break;
					case 5: List<Book> Book = LMSDao.getAllRecords();
							for(Book bk :Book) {
								System.out.println(bk);
							}
						break;
					default:System.out.println("Invalid choice");
					}					
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
			

	}

