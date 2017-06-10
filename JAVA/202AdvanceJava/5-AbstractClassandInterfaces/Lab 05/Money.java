package MoneyTime;

import java.math.BigDecimal;



public class Money implements Calculable<Money>,Comparable<Money>{
//    private String amountIn;
    private BigDecimal amountIn;
    private BigDecimal storage;
    private BigDecimal totalMoneyVal;

    public Money(){
        this.totalMoneyVal = null;
        this.storage = null;
        this.amountIn = null;
    }

    //stores values to fields to use compare later
    public Money(String inAmountin){
        amountIn = new BigDecimal(inAmountin).setScale(2,
                BigDecimal.ROUND_HALF_EVEN);
        totalMoneyVal= amountIn;

        this.storage = amountIn;
    }
    //copy constructor
    public Money(Money old){
        this.amountIn = old.amountIn;
        this.totalMoneyVal = old.totalMoneyVal;
        this.storage = old.storage;
    }

    //add
    @Override
    public Money add(Money o) {
        Money newMoney = new Money();
        BigDecimal a1 = this.storage.add(o.storage).setScale(2,
                BigDecimal.ROUND_HALF_EVEN);
        newMoney.setStorage(a1);
        return newMoney;
    }

    @Override
    public Money subtract(Money o) {
        Money newMoney = new Money();
        BigDecimal a1 = this.amountIn.
                subtract(o.amountIn);
        newMoney.setStorage(a1);
        return newMoney;
    }

    @Override
    public int compareTo(Money o) {
        if (getTotalMoneyVal().floatValue() > o.getTotalMoneyVal().floatValue())
            return 1;
        else if(getTotalMoneyVal().floatValue() < o.getTotalMoneyVal().floatValue())
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "Money Values: " + getTotalMoneyVal();
    }

    public BigDecimal getTotalMoneyVal(){return totalMoneyVal;}

    public void setStorage(BigDecimal storage) {
        this.storage = storage;
    }
}//end money
