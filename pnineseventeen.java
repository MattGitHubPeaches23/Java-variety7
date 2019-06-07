// Copyright (c) 2019, Matthew Chalifoux.
import java.util.ArrayList;
import java.util.Scanner;

public class pnineseventeen {
	
	
	public static ArrayList<Object> collectAll(ArrayList<Object> objects, Filter f){
		
		ArrayList<Object> sub = new ArrayList<Object>();
		
				
		for(int i = 0; i < objects.size(); ++i) {
			
			if(f.accept(objects.get(i))) {
				sub.add(objects.get(i));
			}
		}
		
				
		
		
		return sub;
	}

	public static void main(String[] args) {
		
		
		ShortWordFilter test = new ShortWordFilter();
		
		
		ArrayList<Object> sub = new ArrayList<Object>();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter words, when done, enter -1");
		
		String get = "";
		boolean stuck = true;
		
		while(stuck) {			
			
			get = in.next();			
			if(get.equals("-1")) {
				stuck = false;
			}
			else {
				sub.add(get);
			}
		}
		
		
		
		ArrayList<Object> sub2 = new ArrayList<Object>();
		
		sub2 = collectAll(sub,test);
		
		System.out.println(sub2);

		
		
	}
	
}

//Enter words, when done, enter -1
//list
//heaven
//two
//poppy
//pop
//seven
//four
//-1
//[list, two, pop, four]
