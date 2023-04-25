package com.example.javalaba5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;


/**
 * The type ATM.
 */
public class ATM implements Iterable<Object>, Comparable<ATM>, Iterator<Object> {
    /**
     * the amount of 100 banknotes.
     */
    int x100, /**
     * the amount of 50 banknotes.
     */
    x50, /**
     * the amount of 20 banknotes.
     */
    x20, /**
     * the amount of 10 banknotes.
     */
    x10, /**
     * the amount of 5 banknotes.
     */
    x5, /**
     * the amount of money.
     */
    account, /**
     * The ID of ATM.
     */
    ID, /**
     * The minimal amount of money that ATM can have.
     */
    minSum, /**
     * The maximal amount of money that ATM can have.
     */
    maxSum;

    /**
     * Get the amount of money that ATM has at the moment.
     *
     * @return the amount of money that ATM has at the moment
     */
    int getAccount(){return account;}

    /**
     *  Constructor without parameters that  makes new ATM.
     */
    public ATM() {
        ID =0;
        account=0;
        minSum=5;
        maxSum=2000;
        x100=0;
        x50=0;
        x20=0;
        x10=0;
        x5=0;
    }

    /**
     * Constructor with parameters that takes amounts of banknotes and makes new ATM.
     *
     * @param ID      the id of ATM
     * @param account the amount of money to add to ATM
     * @param x100    the amount of 100 banknotes to add to ATM
     * @param x50     the amount of 50 banknotes to add to ATM
     * @param x20     the amount of 20 banknotes to add to ATM
     * @param x10     the amount of 10 banknotes to add to ATM
     * @param x5      the amount of 5 banknotes to add to ATM
     */
    public ATM(int ID,int account,int x100,int x50,int x20,int x10,int x5) {
        this.ID =ID;
        this.account=account;
        this.minSum=5;
        this.maxSum=2000;
        this.x100=x100;
        this.x50=x50;
        this.x20=x20;
        this.x10=x10;
        this.x5=x5;
    }

    /**
     * Constructor with parameter that takes string and makes new ATM with data from string.
     *
     * @param input the input string with data for ATM
     */
    public ATM(String input) {

        String numberOnly= input.replaceAll("\\D+"," ");
        Character c = numberOnly.charAt(0);

        if(c.isWhitespace(' ')){
            numberOnly=numberOnly.substring(1);
        }

        int result[] = Arrays.stream(numberOnly.split(" +")).mapToInt(Integer::parseInt).toArray();
        this.ID =result[0];
        this.account=result[1];
        this.minSum=5;
        this.maxSum=2000;
        this.x100=result[2];
        this.x50=result[3];
        this.x20=result[4];
        this.x10=result[5];
        this.x5=result[6];
        };


    /**
     * Function adds new banknotes to ATM.
     *
     * @param add100 the amount of 100 banknotes that function will add
     * @param add50  the amount of 50 banknotes that function will add
     * @param add20  the amount of 20 banknotes that function will add
     * @param add10  the amount of 10 banknotes that function will add
     * @param add5   the amount of 5 banknotes that function will add
     */
    public void addMoney(int add100, int add50, int add20,int add10,int add5) {

        if(this.ID ==0)
        {
            Random random = new Random();
            this.ID =random.nextInt(10);
        }
        x100 +=add100;
        x50 +=add50;
        x20 +=add20;
        x10 +=add10;
        x5 +=add5;
        account=x100*100+x50*50+x20*20+x10*10+x5*5;

    }

    /**
     * Function checks if there is the necessary amount of money in ATM.
     *
     * @param requestCash the amount of currency units that user want to withdraw
     */
    void askMoney(int requestCash) {

            if (account < requestCash) {
                System.out.println("Not enough money in ATM");
            } else if(requestCash>maxSum){
                System.out.println("You can't have so many money");
            }else if(requestCash<minSum){
                System.out.println("ATM doesn't have such little bills");
            }else  System.out.println("Take your money");

        }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ATM");
        sb.append(" {Number: ").append(ID);
        sb.append(" Cash: ").append(account);
        sb.append(", hundred bills:").append(x100);
        sb.append(", fifty bills:").append(x50);
        sb.append(", twenty bills:").append(x20);
        sb.append(", ten bills:").append(x10);
        sb.append(", five bills:").append(x5);
        sb.append('}');
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(ATM atm) {

            if (this.getAccount() == atm.getAccount()) {
                return 0;
            } else if (this.getAccount() < atm.getAccount()) {
                return -1;
            } else {
                return 1;
            }

    }

    @Override
    public Iterator<Object> iterator() {
        resetIterator();
        return this;
    }

    private int iterator_idx = -1;

    private void resetIterator() {
        iterator_idx = -1;
    }

    @Override
    public boolean hasNext() {
        return iterator_idx < 7;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object next() {
        iterator_idx++;
        if(iterator_idx ==0) return ID;
        if(iterator_idx ==1) return account;
        if(iterator_idx ==2) return x5;
        if(iterator_idx ==3) return x10;
        if(iterator_idx ==4) return x20;
        if(iterator_idx ==5) return x50;
        if(iterator_idx ==6) return x100;
        else return null;
    }

}


