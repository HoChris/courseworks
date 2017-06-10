package src.peopleprog;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonTester {

    public static ArrayList<PhoneNumber>phones = new ArrayList<PhoneNumber>();
    public static void main(String[] args) {

//        Scanner input = new Scanner(System.in);
//        System.out.println("please enter the file name to import the data.");

//        FileReaderList list = new FileReaderList().getFileName(input.nextLine());
        Database db = new Database(new FileReaderList().getPeople());
        db.printDatabase();

//        Address aa = new Address(3864,"Rio Hondo Ave.","Rosemead","California",91770);
//        Address ab = new Address(7823,"Cal go Ave.","San Gab","Arizon",234500);
//        Address ac = new Address(1234,"OK Blvd.","OK city","TX",63421);
//        Address ad = new Address(678,23,"Sesame ST.","New York City","New York",78002);
//        Address ae = new Address(7823,3,"First St.","Seattle","Washington",10008);
//        Address af = new Address(1234,23,"State Street","Los Angeles","CA",90023);
//
//        PhoneNumber p = new PhoneNumber("house",626,272,1868);
//        phones.add(p);
//        PhoneNumber pa = new PhoneNumber("Cell",323,123,3456);
//        PhoneNumber pb = new PhoneNumber("Work",909,127,6453);
//        PhoneNumber pc = new PhoneNumber("Home",818,323,2351);
//        ArrayList<PhoneNumber>phones2 = new ArrayList<PhoneNumber>();
//        PhoneNumber pd = new PhoneNumber("Job",800,678,4321);
//        PhoneNumber pe = new PhoneNumber("WorkCell",675,321,5421);
//        PhoneNumber pf = new PhoneNumber("Personal Cell",268,333,5555);
//        phones2.add(pb);
//        phones2.add(pc);
//        phones2.add(pd);
//        ArrayList<PhoneNumber>phones3 = new ArrayList<PhoneNumber>();
//        phones3.add(pe);
//        phones3.add(pf);
//        phones3.add(pa);
//
//        Person a1 = new Person(aa,phones,"chris", "ho", "god@dammit.com");
//        Person a1a = new Person(ad,phones3,"jessie", "know", "99Bunny@earthlink.com");
//        Person a2 = new Employee(ae,phones2,"Abby", "Gal", "123@gmail.com",20100.,"SH-309a");
//        Person a2a = new Employee(ab,phones,"Garry", "Facts", "work@gmail.com",30000.,"ET-01");
//        Person a3 = new Faculty(ac,phones,"A", "Dell", "comisaDell@hotmail.com",19876.,"BIO-210","9am-3pm","Full time");
//        Person a3a = new Faculty(aa,phones2,"Bill", "Burr", "mmpodcast@gmail.com",60078.,"SH-309a","9am-12pm","part time");
//        Person a4 = new Staff(ad,phones,"Jesus", "Christ", "NotReal@yahoo.com",10000000.,"Cloud 9","Professional Sinner");
//        Person a4a = new Staff(ac,phones3,"Brian", "Regan", "NotReal@yahoo.com",75000.,"Broom Closet 09","Janitor");
//        Person a5 = new Student(af,phones,"Ok", "Go", "god@dammit.com","Senior");
//        Person a6 = new Student(ae,phones2,"Carol", "Smith", "Carol@dammit.com","Junior");
//        Person a7 = new Student(aa,phones,"Ok1", "Go1", "god@dammit.com","Sophomore");
//        Person a8 = new Student(ae,phones2,"Carol2", "Smith2", "Carol2@dammit.com","Freshman");
//
//      ArrayList<Person>people = new ArrayList<Person>();
//        people.add(a1);
//        people.add(a1a);
//        people.add(a2);
//        people.add(a2a);
//        people.add(a3);
//        people.add(a3a);
//        people.add(a4);
//        people.add(a4a);
//        people.add(a5);
//        people.add(a6);
//        people.add(a7);
//        people.add(a8);
//
//        Database data = new Database(people);
////        Scanner in = new Scanner(System.in);
//
//        data.printDatabase();
//        System.out.println("\n\nthe number of people  is: " + data.getNumberofPeople());// counter works for people
//        System.out.println("the number of people Employees is: " + data.getNumberofEmployees());
//        System.out.println("the number of people Students is: " + data.getNumberofStudents());
//        System.out.println("the number of people Faculty is: " + data.getNumberofFaculty());
//        System.out.println("the number of people Staff is: " + data.getNumberofStaff());
//        System.out.println("the number of freshman is: "+ data.getNumberofStudentsByClassStanding("freshman"));
//        System.out.println("the number of sophomore is: "+ data.getNumberofStudentsByClassStanding("sophomore"));
//        System.out.println("the number of juniors is: "+ data.getNumberofStudentsByClassStanding("junior"));
//        System.out.println("the number of seniors is: "+ data.getNumberofStudentsByClassStanding("senior"));
//        System.out.println("the number of Graduates is: "+ data.getNumberofStudentsByClassStanding("graduate"));
//        System.out.println("\nThe Employees that have greater then $30000 -----------------------");
//         data.employeesGreaterThanSalary(30000);
//        System.out.println("\nThe Employees that have $30000 -----------------------");
//         data.employeesEqualToSalary(30000);
//        System.out.println("\nThe Employees that have less then $30000 ------------------------");
//         data.employeesLessThanSalary(30000);
//         data.printDatabase("people");






//        System.out.println("Please enter the type your want to Look For"+
//                            "Ex. employee , faculty, staff, student, people");
//        String type = new String(in.next());
//        data.printDatabase(type);
//        Employee b1 = new Employee(a,"chris", "ho", "god@dammit.com",50000,"SH-309a");
//
//        Faculty c1 = new Faculty(a,"chris", "ho", "god@dammit.com",50000,"SH-309a","9am-3pm","Full time");
//
//        Staff c2 = new Staff(a,"chris", "ho", "god@dammit.com",50000,"SH-309a","Professional Ass Wiper");
//
//        Student c3 = new Student(a,"chris", "ho", "god@dammit.com","Senior");//works till here



        // ArrayList<Person>people = new ArrayList<>();
        //PhoneNumber ph1 = new PhoneNumber("cell",909,500,1868);


//        System.out.println(a1);


    }






}
