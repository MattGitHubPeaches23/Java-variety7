// Copyright (c) 2019, Matthew Chalifoux.

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class pninetwentythree {
	
	public static void loadOneTime(ArrayList<OneTime> her) {
		
		try {
			File inputFile = new File("/home/jamal/pninetwentythreetextfile");
			
			Scanner in = new Scanner(inputFile);
			
			String type = "";
			
			type = "OneTime";
			while(in.hasNextLine()) {
				String sub = in.nextLine();
				
				if(sub.contains(type)) {
					//System.out.println("Declare");						
					String [] here = new String[5];
					Scanner another = new Scanner(sub);
					another.useDelimiter(";");
					for(int i = 0; i < 5; ++i) {
						
						here[i] = another.next();
					}
					int t = Integer.parseInt(here[1]);
					int t2 = Integer.parseInt(here[2]);
					int t3 = Integer.parseInt(here[3]);
					OneTime sb = new OneTime(here[0],t,t2,t3);
					
					her.add(sb);
					

					another.close();
				}
			}
			in.close();
			
		}
		
		catch(FileNotFoundException tt) {
			
		}
		
	}
	
	public static void loadMonthly(ArrayList<Monthly> her) {
		
		try {
			File inputFile = new File("/home/jamal/pninetwentythreetextfile");
			
			Scanner in = new Scanner(inputFile);
			
			String type = "";
			
			type = "Monthly";
			while(in.hasNextLine()) {
				String sub = in.nextLine();
				
				if(sub.contains(type)) {
					//System.out.println("Declare");						
					String [] here = new String[5];
					Scanner another = new Scanner(sub);
					another.useDelimiter(";");
					for(int i = 0; i < 5; ++i) {
						
						here[i] = another.next();
					}
					int t = Integer.parseInt(here[3]);
					Monthly sb = new Monthly(here[0],t);
					
					her.add(sb);
					

					another.close();
				}
			}
			in.close();
			
		}
		
		catch(FileNotFoundException tt) {
			
		}
		
	}
	
	public static void loadDaily(ArrayList<Daily> her) {
		
		try {
			File inputFile = new File("/home/jamal/pninetwentythreetextfile");
			
			Scanner in = new Scanner(inputFile);
			
			String type = "";
			
			type = "Daily";
			while(in.hasNextLine()) {
				String sub = in.nextLine();
				
				if(sub.contains(type)) {
					//System.out.println("Declare");						
					String [] here = new String[5];
					Scanner another = new Scanner(sub);
					another.useDelimiter(";");
					for(int i = 0; i < 5; ++i) {
						
						here[i] = another.next();
					}
					Daily sb = new Daily(here[0]);
					
					her.add(sb);
					

					another.close();
				}
			}
			in.close();
			
		}
		
		catch(FileNotFoundException tt) {
			
		}
			
	}
	
	public static void save(Appointment test, PrintWriter out) {
		
		String line = test.toString();
		System.out.println("line = " + line);		
		out.print(line+"\n");		
		out.close();
		
	}
	
	public static void userEntersData(Appointment [] test, int []size) {
		try {
			boolean finish = false;
			//new FileWriter(fail, true)
			
			
			while(!finish) {
				
				PrintWriter out = new PrintWriter(new FileWriter("/home/jamal/pninetwentythreetextfile",true));
				
				System.out.println("What type of Appointment would you like to add and save to file?\n"
						+ "Add a daily appointment? (1)\n" +
						"Add a monthly appointment?(2)\n"
						+ "Add a one time appointment? (3)\n"
						+ "Load Appointment type from file (4) \n"
						+ "Quit (5)");
				
				Scanner in = new Scanner(System.in);
				
				int type = in.nextInt();
				
				
				if(1 == type) {
					System.out.println("Write a description of the appointment.");
					in.nextLine();
					String description = in.nextLine();
					Daily sub = new Daily(description);
					test[size[0]] = sub;
					save(test[size[0]], out);
					++size[0];
				}
				else if(2 == type) {
					System.out.println("Write a description of the appointment.");
					in.nextLine();
					String description = in.nextLine();
					System.out.println("Enter day of month of appointment.");
					int day = in.nextInt();
					Monthly sub = new Monthly(description,day);
					test[size[0]] = sub;
					save(test[size[0]], out);
					++size[0];
				}
				else if(3 == type) {
					System.out.println("Write a description of the appointment.");
					in.nextLine();
					String description = in.nextLine();
					System.out.println("Enter day of month of appointment.");
					int day = in.nextInt();
					System.out.println("Enter month(1-12) of appointment.");
					int month = in.nextInt();
					System.out.println("Enter year of appointment.");
					int year = in.nextInt();
					OneTime sub = new OneTime(description,year,month,day);
					test[size[0]] = sub;
					save(test[size[0]], out);
					++size[0];
				}
				else if(4 == type){
					System.out.println("What type of appointment would you like to pull up?\n"
							+ "Daily Appointments (1)\n"
							+ "Monthly Appointments (2)\n"
							+ "One Time Appointments (3)\n");
					Scanner get = new Scanner(System.in);
					
					int choice = get.nextInt();
					
					if(1 == choice) {
						ArrayList<Daily> her = new ArrayList<Daily>();
						loadDaily(her);
						System.out.println(her);
					}
					else if(2 == choice) {
						ArrayList<Monthly> her = new ArrayList<Monthly>();
						loadMonthly(her);
						System.out.println(her);
					}
					else if(3 == choice) {
						ArrayList<OneTime> her = new ArrayList<OneTime>();
						loadOneTime(her);
						System.out.println(her);
					}
								
					
					
				}
				else {
					finish = true;
				}		
				
			}
		}
		
		catch(IOException exception) {
			
		}
		
	}

	public static void main(String[] args) {
		
		OneTime one = new OneTime("Doctor", 2018,11,3);
		//one.display();
		
		Daily day = new Daily("Massage");
		//day.display();
		
		Monthly month = new Monthly("Foot", 5);
		//month.display();
		
		
		Appointment [] test = new Appointment[10];
		test[0] = one;
		test[1] = day;
		test[2] = month;
		
		
		
		int []size = new int[2];
		size[0] = 3;
		
		
		
		userEntersData(test,size);
		
		

		
		
	}
	
}

//What type of Appointment would you like to add and save to file?
//Add a daily appointment? (1)
//Add a monthly appointment?(2)
//Add a one time appointment? (3)
//Load Appointment type from file (4) 
//Quit (5)
//1
//Write a description of the appointment.
//foot
//line = foot;0;0;0;Daily
//What type of Appointment would you like to add and save to file?
//Add a daily appointment? (1)
//Add a monthly appointment?(2)
//Add a one time appointment? (3)
//Load Appointment type from file (4) 
//Quit (5)
//1
//Write a description of the appointment.
//foot bone
//line = foot bone;0;0;0;Daily
//What type of Appointment would you like to add and save to file?
//Add a daily appointment? (1)
//Add a monthly appointment?(2)
//Add a one time appointment? (3)
//Load Appointment type from file (4) 
//Quit (5)
//2
//Write a description of the appointment.
//mind
//Enter day of month of appointment.
//13
//line = mind;0;0;13;Monthly
//What type of Appointment would you like to add and save to file?
//Add a daily appointment? (1)
//Add a monthly appointment?(2)
//Add a one time appointment? (3)
//Load Appointment type from file (4) 
//Quit (5)
//2
//Write a description of the appointment.
//mental problems
//Enter day of month of appointment.
//14
//line = mental problems;0;0;14;Monthly
//What type of Appointment would you like to add and save to file?
//Add a daily appointment? (1)
//Add a monthly appointment?(2)
//Add a one time appointment? (3)
//Load Appointment type from file (4) 
//Quit (5)
//3
//Write a description of the appointment.
//teeth
//Enter day of month of appointment.
//6
//Enter month(1-12) of appointment.
//9
//Enter year of appointment.
//2019
//line = teeth;2019;9;6;OneTime
//What type of Appointment would you like to add and save to file?
//Add a daily appointment? (1)
//Add a monthly appointment?(2)
//Add a one time appointment? (3)
//Load Appointment type from file (4) 
//Quit (5)
//3
//Write a description of the appointment.
//root canal
//Enter day of month of appointment.
//1
//Enter month(1-12) of appointment.
//3
//Enter year of appointment.
//2020
//line = root canal;2020;3;1;OneTime
//What type of Appointment would you like to add and save to file?
//Add a daily appointment? (1)
//Add a monthly appointment?(2)
//Add a one time appointment? (3)
//Load Appointment type from file (4) 
//Quit (5)
//4
//What type of appointment would you like to pull up?
//Daily Appointments (1)
//Monthly Appointments (2)
//One Time Appointments (3)
//
//1
//[foot;0;0;0;Daily, foot bone;0;0;0;Daily]
//What type of Appointment would you like to add and save to file?
//Add a daily appointment? (1)
//Add a monthly appointment?(2)
//Add a one time appointment? (3)
//Load Appointment type from file (4) 
//Quit (5)
//4
//What type of appointment would you like to pull up?
//Daily Appointments (1)
//Monthly Appointments (2)
//One Time Appointments (3)
//
//2
//[mind;0;0;13;Monthly, mental problems;0;0;14;Monthly]
//What type of Appointment would you like to add and save to file?
//Add a daily appointment? (1)
//Add a monthly appointment?(2)
//Add a one time appointment? (3)
//Load Appointment type from file (4) 
//Quit (5)
//4
//What type of appointment would you like to pull up?
//Daily Appointments (1)
//Monthly Appointments (2)
//One Time Appointments (3)
//
//3
//[teeth;2019;9;6;OneTime, root canal;2020;3;1;OneTime]
//What type of Appointment would you like to add and save to file?
//Add a daily appointment? (1)
//Add a monthly appointment?(2)
//Add a one time appointment? (3)
//Load Appointment type from file (4) 
//Quit (5)
//5
