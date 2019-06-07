// Copyright (c) 2019, Matthew Chalifoux.

import java.util.Formattable;
import java.util.Formatter;
import java.util.*;
import java.io.IOException;

/**
   A bank account has a balance and a mechanism for applying interest or fees at 
   the end of the month.
*/
public class BankAccount implements Formattable, Appendable
{
	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision)
    {

		System.out.println("formatter = " + formatter);
		System.out.println("flags = " + flags);
		System.out.println("width = " + width);
		System.out.println("precision = " + precision);
		
        Appendable appendable = formatter.out() ;
        
        
        String balanceString = "$" + balance ;
        
        //int cat = System.out.printf("%.2f", balance);


        for (int i = balanceString.length() ; i < width ; i++)
        balanceString = " " + balanceString ;

        try {

            //tells appendable to append balanceString to printf's string
            appendable.append(balanceString);

        }
        catch (IOException e) {
            System.exit(0);
        }
    }

	
	
	
	
   private double balance;

   /**
      Constructs a bank account with zero balance.
   */
   public BankAccount()
   {
      balance = 0;
   }

   /**
      Makes a deposit into this account.
      @param amount the amount of the deposit
   */
   public void deposit(double amount)
   {
      balance = balance + amount;
   }
   
   /**
      Makes a withdrawal from this account, or charges a penalty if
      sufficient funds are not available.
      @param amount the amount of the withdrawal
   */
   public void withdraw(double amount)
   {
      balance = balance - amount;
   }
   
   /**
      Carries out the end of month processing that is appropriate
      for this account.
   */
   public void monthEnd() 
   {
   }
   
   /**
      Gets the current balance of this bank account.
      @return the current balance
   */
   public double getBalance()
   {
      return balance;
   }

   
   @Override
   public Appendable append(CharSequence arg0) throws IOException {
   	// TODO Auto-generated method stub
   	System.out.println("HEllo");
   	return null;
   }

   @Override
   public Appendable append(char arg0) throws IOException {
   	// TODO Auto-generated method stub
   	System.out.println("HEllo");
   	return null;
   }

   @Override
   public Appendable append(CharSequence arg0, int arg1, int arg2) throws IOException {
   	// TODO Auto-generated method stub
   	System.out.println("HEllo");
   	return null;
   }
}
