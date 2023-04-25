package com.example.javalaba5;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Test.
 */
public class Test {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        ATM atm1 = new ATM("Number 6 Cash:1000 bills:10,0,0,0,0");
        ATM atm2 = new ATM();
        ATM atm3=new ATM(3,1500,10,10,0,0,0);


        List<ATM> list=new ArrayList<>();
        list.add(atm1);
        list.add(atm2);
        list.add(atm3);

        ATM atm4=new ATM(list.get(0).toString());

        System.out.print(atm1);
        System.out.print(atm2);
        System.out.print(atm3);
        System.out.print(atm4);

        atm1.addMoney(10, 10, 10,10,10);
        atm2.addMoney(10, 10, 10,10,10);

        atm1.askMoney(1250);

        System.out.print(atm1.compareTo(atm2)+"\n");

        list.sort(ATM::compareTo);

        for (ATM atm : list) {
            System.out.print("Number: ");
                System.out.print(atm.ID +" ");
            System.out.print("Cash: ");
                System.out.print(atm.account+" ");
            System.out.println();
        }

    }
}
