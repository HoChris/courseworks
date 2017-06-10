package src.peopleprog;

import java.util.ArrayList;


public class Database {
    private ArrayList<Person>people;

    public Database() {
        ArrayList<Person>people = new ArrayList<Person>();
    }

    public Database(ArrayList<Person> people) {
        this.people = people;
    }

    public void printDatabase(){
//        method should display all the info of students, faculty, and staff stored
        for (int i = 0; i <getPeople().size(); i++) {
            System.out.println(getPeople().get(i).toString());
        }
    }

    public void printDatabase(String type){
        // takes String type and displays only the type of person you want to ss i.e only displays all employees, staff, faculty or students
        for (int i = 0; i < getPeople().size(); i++) {
            if(people.get(i) instanceof Staff && people.get(i).getObType().equalsIgnoreCase(type)){
                System.out.println("\nStaff "+getPeople().get(i).toString());
            }
            else if (people.get(i) instanceof Faculty && people.get(i).getObType().equalsIgnoreCase(type)){
                System.out.println("\nFaculty "+getPeople().get(i).toString());
            }
            else if (people.get(i) instanceof Employee && people.get(i).getObType().equalsIgnoreCase(type)){
                System.out.println("\nEmployee "+getPeople().get(i).toString());
            }
            else if (people.get(i) instanceof Student && people.get(i).getObType().equalsIgnoreCase(type)){
                System.out.println("\nStudent "+getPeople().get(i).toString());
            }
            else if (people.get(i) instanceof Person && people.get(i).getObType().equalsIgnoreCase(type)){
                System.out.println("\nPeople " + getPeople().get(i).toString());
            }
            else{
//                System.out.println("something");
            }
        }

    }
    public int getNumberofPeople(){
        int totalPeople =0;
        for (int i = 0; i <getPeople().size(); i++) {
            totalPeople += people.get(i).getPeopleCount();

        }

        return totalPeople;
    }
    public int getNumberofStudents(){
        int totStud =0;
        for (int i = 0; i <getPeople().size(); i++) {
            totStud += people.get(i).getStudentsCount();
        }
        return totStud;
    }

    public int getNumberofEmployees(){
        int totEmp = 0;
        for (int i = 0; i <getPeople().size(); i++) {
            totEmp += people.get(i).getEmpCount();
        }
        return totEmp;
    }

    public int getNumberofStaff(){
        int totStaff =0;
        for (int i = 0; i <getPeople().size(); i++) {
            totStaff += people.get(i).getStaffCount();

        }
        return totStaff;
    }
    public int getNumberofFaculty(){
        int totFac =0;
        for (int i = 0; i <getPeople().size(); i++) {
            totFac += people.get(i).getFacCount();

        }
        return totFac;
    }

    public int getNumberofStudentsByClassStanding(String s){
        int numbers = 0;
//        int i =0;
//        while (i<getPeople().size()){
//
////            for (int i = 0; i <getPeople().size(); i++) {
//                //people.get(i).getClStand().equalsIgnoreCase(s); this points to nothing revise
//                people.get(i).setClStand(s);
//                if(people.get(i).getClStand().equalsIgnoreCase("freshman")){
//                    numbers += people.get(i).getFrman();
//                }
//                else if (s.equalsIgnoreCase("sophomore")){
//                    numbers += people.get(i).getSoph();                   THIS WORKS BUT WAS SOLVED WITH += instead of =....
//                }
//                else if (s.equalsIgnoreCase("junior")){
//                    numbers += people.get(i).getJun();
//                }
//                else if (s.equalsIgnoreCase("senior")){
//                    numbers += people.get(i).getSen();
//                    System.out.println("besshsh");
//                }
//                else{
//                    numbers += people.get(i).getGrads();
//                }
//            ++i;
//        }
        for (int i = 0; i <getPeople().size(); i++) {
            //people.get(i).getClStand().equalsIgnoreCase(s); this points to nothing revise
            people.get(i).setClStand(s);
                if(s.equalsIgnoreCase("freshman")){
                numbers += people.get(i).getFrman();
            }
            else if (s.equalsIgnoreCase("sophomore")){
                numbers += people.get(i).getSoph();
            }
            else if (s.equalsIgnoreCase("junior")){
                numbers += people.get(i).getJun();
            }
            else if (s.equalsIgnoreCase("senior")){
                numbers += people.get(i).getSen();
//                    System.out.println("besshsh"); checking if it access this
            }
            else{
                numbers += people.get(i).getGrads();
            }
        }
        return numbers;
    }

    public void employeesGreaterThanSalary(double salary){
        for(int i=0; i<getPeople().size();i++){
            if(people.get(i).getSalary() > salary){
                System.out.println(people.get(i).toString());
            }
        }

    }
    public void employeesEqualToSalary(double salary){
        for(int i=0; i<getPeople().size();i++){
            if(people.get(i).getSalary() == salary){
                System.out.println(people.get(i).toString());
            }
        }

    }
    public void employeesLessThanSalary(double salary){
        for(int i=0; i<getPeople().size();i++){
            if(people.get(i).getSalary() < salary && people.get(i).getSalary() > 0){
                System.out.println(people.get(i).toString());
            }
        }

    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Database{" +
                "people=" + people +
                '}';
    }
}//end class
