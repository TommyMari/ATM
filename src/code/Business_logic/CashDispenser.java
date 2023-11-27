package code.Business_logic;
// CashDispenser.java
// Represents the cash dispenser of the ATM

public class CashDispenser 
{
   // the default initial number of bills in the cash dispenser //现金分配器中初始票据的默认数量
   private final static int INITIAL_COUNT = 500;
   
   private int count; // number of $20 bills remaining //剩余的20美元票数
   
   // no-argument CashDispenser constructor initializes count to default //无参数CashDispenser构造函数将计数初始化为默认值
   public CashDispenser()
   {
      count = INITIAL_COUNT; // set count attribute to default //将计数属性设置为默认值
   } // end CashDispenser constructor

   // simulates dispensing of specified amount of cash //模拟分配指定金额的现金
   public void dispenseCash( Euro amount )
   {

      int billsRequired = (int) (amount.getValore() / 2000); // number of $20 bills required //所需的20美元票数
      count -= billsRequired; // update the count of bills
   } // end method dispenseCash

   // indicates whether cash dispenser can dispense desired amount //指示现金分配器是否可以分配所需的金额
   public boolean isSufficientCashAvailable( Euro amount )
   {
      int billsRequired = (int) (amount.getValore() / 2000);  // number of $20 bills required

      if ( count >= billsRequired  )
         return true; // enough bills available
      else 
         return false; // not enough bills available
   } // end method isSufficientCashAvailable
} // end class CashDispenser



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