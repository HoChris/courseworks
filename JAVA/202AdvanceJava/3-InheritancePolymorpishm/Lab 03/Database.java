package peopleprog;

import java.util.ArrayList;


/**
 * Created by Chris on 4/22/2015.
 */
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
            if (people.get(i).equals(type)){
//                for(int j = 0; j< people.size(); j++){
                    System.out.println(getPeople().get(i).toString());
//                }

            }
        }


    }
//    public int getNumberofPeople(){
//
//        return int i;
//    }
//    public int getNumberofStudents(){
//        return int i;
//    }
//
//    public int getNumberofEmployees(){
//        return int i;
//    }
//    public int getNumberofStaff(){
//        return int i;
//    }
//    public int getNumberofFaculty(){
//        return int i;
//    }
//
//    public int getNumberofStudentsByClassStanding(String s){
//
//
//    }
//
//    public void EmployeesGreaterThanSalary(double i){
//
//
//    }
//    public void EmployeesEqualToSalary(double i){
//
//
//    }
//    public void EmployeesLessThanSalary(double i){
//
//
//    }

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
