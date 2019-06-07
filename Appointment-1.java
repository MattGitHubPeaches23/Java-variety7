
// Copyright (c) 2019, Matthew Chalifoux.
public class Appointment {
	private String description;
	private int year;
	private int month;
	private int day; 
	private String typ;

	public Appointment() {
		
	}
	
	public Appointment(String des,int yr,int mt, int dy, String typ) {
		description = "" + des;
		year = yr;
		month = mt;
		day = dy;
		this.typ = typ;
	}
	

	public void display() {
		System.out.println("Description = " + description);
	}
	
	public boolean occursOn(int a, int b , int c) {
		
		if(0 == year && 0 == month && 0 != day) {
			if(c == day) {
				return true;
			}			
		}
		else if(0 == year && 0 == month && 0 == day) {
			return true;
		}
		else if(a == year && b == month && c == day) {
			return true;
		}
		
		
		return false;
	}
	 
	public String toString() {
		
		String sub;
		//System.out.println("description = " + description);
		sub =  "" + description + ";" + year + ";" + month + ";" + day + ";" + typ;
		
		return sub;
	}
	
	
}
