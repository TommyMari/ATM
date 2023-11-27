package code.Business_logic;
// Account.java
// Represents a bank account

public class Account 
{
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private Euro availableBalance; // funds available for withdrawal 可提取资金
   private Euro totalBalance; // funds available + pending deposits 可用资金+待定存款

   // Account constructor initializes attributes //初始化属性
   public Account( int theAccountNumber, int thePIN,
      Euro theAvailableBalance, Euro theTotalBalance )
   {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;
   } // end Account constructor  //结束账户构造函数


   // determines whether a user-specified PIN matches PIN in Account //确定用户指定的PIN是否与帐户中的PIN匹配
   public boolean validatePIN( int userPIN )
   {
      if ( userPIN == pin )
         return true;
      else
         return false;
   } // end method validatePIN
   
   // returns available balance //返回可用余额
   public Euro getAvailableBalance()
   {
      return availableBalance;
   } // end getAvailableBalance

   // returns the total balance //返回总余额
   public Euro getTotalBalance()
   {
      return totalBalance;
   } // end method getTotalBalance

   // credits an amount to the account //将金额存入帐户
   public void credit( Euro amount )
   {
      totalBalance.somma(amount);// add to total balance //添加到总余额
   } // end method credit

   // debits an amount from the account
   public void debit( Euro amount )
   {
      availableBalance.sottrai(amount); // subtract from available balance //从可用余额中扣除
      totalBalance.sottrai(amount); // subtract from total balance //从总余额中扣除
   } // end method debit

   // returns account number
   public int getAccountNumber()
   {
      return accountNumber;  
   } // end method getAccountNumber
} // end class Account


/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/