package src.peopleprog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Chris on 4/28/2015.
 */
public class FileReaderList {
    public  ArrayList<Person>people;
    public  ArrayList<PhoneNumber>fromCvsPhones;
    private String fileName;
    public FileReaderList(){
            sortObj();
        }

    public void sortObj() {

        ArrayList<PhoneNumber>fromCvsPhones = new ArrayList<PhoneNumber>();
        ArrayList<Person>people= new ArrayList<Person>();
        File input = new File("E:\\Users\\Chris\\Dropbox\\Dropbox\\EcWorkspace\\LAB3PERSON\\src\\peopleprog\\TestData1.csv");
//        File input = new File(getFileName());


        try {
            Scanner read = new Scanner(input);

            while (read.hasNext()) {
                String nextLine = read.nextLine();
                String[] tokens = nextLine.split(",");
//                System.out.println("hi");
                if (tokens[0].equalsIgnoreCase("faculty")) {
                    Person p = new Faculty(tokens);
                    people.add(p);
                } else if (tokens[0].equalsIgnoreCase("staff")) {
                    Person p = new Staff(tokens);
                    people.add(p);
                } else if (tokens[0].equalsIgnoreCase("employee")) {
                    Person p = new Employee(tokens);
                    people.add(p);
                } else if (tokens[0].equalsIgnoreCase("student")) {
                    Person p = new Student(tokens);
                    people.add(p);
                } else if (tokens[0].equalsIgnoreCase("person")) {
                    Person p = new Person(tokens);
                    people.add(p);
                } else if (tokens[0].equalsIgnoreCase("PhoneNumber")) {
//                    need a way to pass this to the last person object
//                    System.out.println("hello");
//                    PhoneNumber numbphone = new PhoneNumber(tokens);
//                    fromCvsPhones.add(numbphone);
//
//                    int i = people.size();
//                    people.get(i-1).setAllPhones(fromCvsPhones);
//                    Person o = new Person(people.get(i-1));
//                    people.remove(people.get(i-1));
//                    people.add(i-1,o);

                }
//                people.add(p);

            }//end while
            this.people = people;
            read.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");

        }
    }//end sortobj
    public ArrayList<Person>getPeople(){return this.people;}

    public ArrayList<PhoneNumber>getFromCvsPhones(){return this.fromCvsPhones;}

    public void setFromCvsPhones(ArrayList<PhoneNumber> fromCvsPhones) {
        this.fromCvsPhones = fromCvsPhones;
    }
    //    public
//    public void setFilename(String fileName){
//        this.setFilename() = fileName;
//    }
//    public String getFileName(){return this.fileName;}
}//end of FileReaderList

/* what i need is a method in Person to take and outside phone array list from file reader maybe and add it to the
previous last item from the arraylist of Person objects
 */