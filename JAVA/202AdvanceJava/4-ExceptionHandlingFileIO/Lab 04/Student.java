package src.peopleprog;

import java.util.ArrayList;

/**
 * a student has a class standing (freshman, sophomore, junior, senior, or graduate)
 * Created by Chris on 4/22/2015.
 */
public class Student extends Person {
    private String classS;


    public Student() {
        this.classS = "freshman";

    }

    public Student(String classS) {
        this.classS = classS;
    }

    public Student(Address inAddress,ArrayList<PhoneNumber> pNum, String inFirstName, String inLastName, String inEmailAdd, String classS) {
        super(inAddress,pNum, inFirstName, inLastName, inEmailAdd);
        this.classS = classS;
//        int i =0;
        super.setStudentsCount();
        super.setObType("Student");
        if(classS.equalsIgnoreCase("freshman")){
//            cnt +=1;
            super.setFrman();
//            super.setClStand("freshman");
        }
        else if(classS.equalsIgnoreCase("sophomore")){
//            cnt +=1;
            super.setSoph();
//            super.setClStand("Sophomore");
        }
        else if(classS.equalsIgnoreCase("junior")){
//            cnt +=1;
            super.setJun();
//            super.setClStand("Junior");
        }
        else if(classS.equalsIgnoreCase("senior")){
//            cnt +=1;
            super.setSen();
//            super.setClStand("Senior");
        }
        else if(classS.equalsIgnoreCase("graduate")) {
//            cnt +=1;
            super.setGrads();
//            super.setClStand("Graduate");
        }
        else {

        }

    }
    public Student(String[] intokens) {
        super(intokens);
        this.classS = intokens[10];
        super.setStudentsCount();
        super.setObType("Student");
        if(classS.equalsIgnoreCase("freshman")){
            super.setFrman();
        }
        else if(classS.equalsIgnoreCase("sophomore")){
            super.setSoph();
        }
        else if(classS.equalsIgnoreCase("junior")){
            super.setJun();
        }
        else if(classS.equalsIgnoreCase("senior")){
            super.setSen();

        }
        else if(classS.equalsIgnoreCase("graduate")) {
            super.setGrads();
        }
        else {
        }

    }

    public String getClassS() {
        return classS;
    }

    public void setClassS(String classS) {
        this.classS = classS;
    }

    @Override
    public String toString(){
        return super.toString() + "\nClass Standing:\t\t" + getClassS();
    }

}
