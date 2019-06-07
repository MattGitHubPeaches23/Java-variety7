// Copyright (c) 2019, Matthew Chalifoux.

public class pninenineteen {
	
	public static void main(String[] args) {
		
		BankAccount test = new BankAccount() ;
		
		test.deposit(1234.54);

        //Don't understand this code
        System.out.printf("%s %10S.\n", "Balance = ", test) ;
		
        BankAccount test2 = new BankAccount() ;
		
		test2.deposit(123.5);

        //Don't understand this code
        System.out.printf("%s %10S.\n", "%.2fBalance = ", test2) ;
		
		
	}
	

}
