package MoneyTime;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Main Class
 Create two arrays or arraylists of money objects (add the objects in an unsorted order)
 Create two arrays or arraylists of time objects (add the objects in an unsorted order)
 Use the sorting methods from Collections or Arrays to sort all four lists.
 Display Each list before and after being sorted.
 Take each pair of lists and add the corresponding elements together and display the results.
 I.E. Take both Money lists and add together both elements at index 0, index 1, index 2, etc...
 Do the same for the Time lists.
 Take each pair of lists and subtract the corresponding elements, and display the results.
 I.E. Take both Money lists and subtract both elements at index 0, index 1, index 2, etc...
 Do the same for the Time lists.
 */
public class Main implements Calculable<Main>{

    private ArrayList<Money> newMoney=new ArrayList<Money>();
    private ArrayList<Money> oldMoney=new ArrayList<Money>();
    private ArrayList<Time> newTime=new ArrayList<Time>();
    private ArrayList<Time> oldTime =new ArrayList<Time>();

    public Main(){

        Money a1=new Money("1.00");
        Money a2=new Money("2.00");
        Money a3=new Money("10.00");
        Money a4=new Money("3.00");

        Money b1=new Money(".99");
        Money b2=new Money(".75");
        Money b3=new Money("1.25");
        Money b4=new Money("20.20");
//        ArrayList<Money> oldMoney = new ArrayList<Money>();
        oldMoney.add(a1);
        oldMoney.add(b1);
        oldMoney.add(a4);
        oldMoney.add(b2);

        newMoney.add(a2);
        newMoney.add(a3);
        newMoney.add(b3);
        newMoney.add(b4);

        Time c1 = new Time(1,2,3);
        Time c2 = new Time(5,23,43);
        Time c3 = new Time(23,59,59);
        Time c4 = new Time(14,65,76);

        Time z1 = new Time(5,40,43);
        Time z2 = new Time(2,23,59);
        Time z3 = new Time(4,30,64);
        Time z4 = new Time(12,23,46);

        newTime.add(z3);
        newTime.add(c2);
        newTime.add(c1);
        newTime.add(z2);

        oldTime.add(z1);
        oldTime.add(c3);
        oldTime.add(c4);
        oldTime.add(z4);

    }


    @Override
    public String toString() {
        return "Main{" +
                "\nnewMoney=" + newMoney +
                "\noldMoney=" + oldMoney +
                "\nnewTime=" + newTime +
                "\noldTime=" + oldTime +
                '}';
    }
    //displays lists
    public void displayLists(){
        for(Money x : newMoney){
            System.out.println(x);
        }
        System.out.println();
        for(Money x : oldMoney){
            System.out.println(x);
        }
        System.out.println();
        for(Time x : oldTime){
            System.out.println(x);
        }
        System.out.println();
        for(Time x : newTime){
            System.out.println(x);
        }

    }
    //sorting method
    public void sortingArrays(){
        Collections.sort(newMoney);
        Collections.sort(oldMoney);
        Collections.sort(newTime);
        Collections.sort(oldTime);

    }
    @Override
    public Main add(Main o) {
        Main nemMain = new Main();
        //cant figure out
        for (Money x: this.newMoney){
             nemMain.setNewMoney(x + o);
        }



        return null;
    }

    @Override
    public Main subtract(Main o) {
        return null;
    }


    public ArrayList<Money> getOldMoney() {
        return oldMoney;
    }
    public void setOldMoney(ArrayList<Money> oldMoney) {
        this.oldMoney = oldMoney;
    }

    public ArrayList<Time> getNewTime() {
        return newTime;
    }
    public void setNewTime(ArrayList<Time> newTime) {
        this.newTime = newTime;
    }

    public ArrayList<Time> getOldTime() {
        return oldTime;
    }
    public void setOldTime(ArrayList<Time> oldTime) {
        this.oldTime = oldTime;
    }

    public ArrayList<Money> getNewMoney() {
        return newMoney;
    }
    public void setNewMoney(ArrayList<Money> newMoney) {
        this.newMoney = newMoney;
    }
}//end main
