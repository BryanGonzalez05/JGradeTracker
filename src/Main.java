import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       List<Student> school = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
       while(true){
            System.out.println("*****************************");
            System.out.println("Add new student [1]");
            System.out.println("All Students [2]");
            System.out.println("Student GPA [3]");
            System.out.println("Remove Student [4]");
            System.out.println("Exit [5]");
            System.out.println("*****************************");

            String input = scanner.nextLine();
            input = input.toLowerCase().trim();

            switch(input){
                case "1":
                    System.out.println();
                    while(true) {
                        String fn;
                        String ln;
                        int id;
                        double gpa = -1;

                        System.out.println("Enter: Exit. To exit Student adder");
                        System.out.println("Enter Students First Name");
                        input = scanner.nextLine().trim();

                        if(input.equalsIgnoreCase("exit")){
                            System.out.println();
                            break;
                        }

                        while(!input.matches("[a-zA-Z]+")) {
                            System.out.println("Invalid First Name!");
                            input = scanner.nextLine().trim();
                        }

                        fn = input;
                        System.out.println("Enter Students Last Name");
                        input = scanner.nextLine().trim();

                        if(input.equalsIgnoreCase("exit")){
                            System.out.println();
                            break;
                        }

                        while(!input.matches("[a-zA-Z]+")){
                            System.out.println("Invalid Last Name!");
                            input = scanner.nextLine().trim();
                        }

                        ln = input;
                        boolean stillActive = true;
                        System.out.println("Enter Students ID");
                        input = scanner.nextLine().trim();

                        if(input.equalsIgnoreCase("exit")){
                            System.out.println();
                            break;
                        }

                        //check student id
                        while(stillActive){
                            if(input.equalsIgnoreCase("exit")){
                                stillActive = false;
                            }
                            else if(!input.matches("\\d{8}")) {
                                System.out.println("Error! Invalid Student ID");
                                input = scanner.nextLine().trim();
                            }
                            else if(input.length() != 8) {
                                System.out.println("Error! Invalid Student ID");
                                input = scanner.nextLine().trim();
                                }
                            else if(!checkID(Integer.parseInt(input), school)){
                                input = scanner.nextLine().trim();
                                    }
                                    else {
                                        break;
                            }
                        }

                        if(!stillActive){
                            System.out.println();
                            break;
                        }

                        id = Integer.parseInt(input);
                        System.out.println("Enter Students GPA");
                        input = scanner.nextLine().trim();

                        if(input.equalsIgnoreCase("exit")){
                            System.out.println();
                            break;
                        }

                        //check student gpa
                        while(stillActive){
                            if(input.equalsIgnoreCase("exit")){
                                stillActive = false;
                            }
                            else if(!input.matches("[0-4](\\.\\d{1,2})?")){
                                System.out.println("Error! Invalid GPA");
                                input = scanner.nextLine().trim();
                            }
                            else  if(Double.parseDouble(input) > 4.0){
                                gpa = 4.0;
                                break;
                            }
                            else{
                                gpa = Double.parseDouble(input);
                                break;
                            }
                        }

                        if(!stillActive){
                            System.out.println();
                            break;
                        }
                        else{
                            Student ns = new Student(fn,ln,id,gpa);
                            school.add(ns);
                            System.out.println("New Student added\n");
                        }
                    }
                    break;

                case"2":
                    System.out.println();
                    if(school.isEmpty()){
                        System.out.println("There are no students added");
                    }
                    else{
                        for(Student s: school){
                            System.out.println(s.getStudentInfo() + "\n");
                        }
                    }
                    break;

                case"3":
                        System.out.println();
                        if (school.isEmpty()){
                            System.out.println("There are no GPA's");
                            break;
                        }
                        boolean istrue = true;
                        while(istrue){
                        System.out.println("*****************************");
                        System.out.println("Show all GPA [1]");
                        System.out.println("Show top 5 highest GPA [2]");
                        System.out.println("Show 3.0 or higher [3]");
                        System.out.println("Show top 5 Lowest GPA [4]");
                        System.out.println("Show 2.9 or lower [5]");
                        System.out.println("Exit [6]");
                        System.out.println("*****************************");
                        input = scanner.nextLine().trim();

                        switch(input.toLowerCase()) {
                            case "1":
                                System.out.println();
                                for (Student s : school) {
                                    System.out.println(s.getStudentID() + " : " + s.getStudentGPA());
                                }
                                break;

                            case "2":
                                //sorts the students in decending order
                                //to sort from accending order (Lowest to highest) swap s2 with s1
                                List<Student> sortHighest= new ArrayList<>(school);
                                sortHighest.sort((s1, s2) -> Double.compare(s2.gpa, s1.gpa));

                                List<Student> top5 = new ArrayList<>(sortHighest.subList(0, Math.min(5, sortHighest.size())));

                                System.out.println();
                                for(Student s : top5){
                                    System.out.println(s.getStudentID() + " : " + s.getStudentGPA());
                                }
                                break;

                            case"3":
                                System.out.println();
                                for(Student s : school){
                                    if(s.getStudentGPA() >= 3.0){
                                        System.out.println(s.getStudentID() + " : " + s.getStudentGPA());
                                    }
                                }
                                break;

                            case"4" :
                                System.out.println();
                                List<Student> sortLowest = new ArrayList<>(school);

                                sortLowest.sort((s1,s2) -> Double.compare(s1.getStudentGPA(), s2.getStudentGPA()));
                                List<Student> bottom5 = new ArrayList<>(sortLowest.subList(0, Math.min(5, sortLowest.size())));

                                for(Student s : bottom5){
                                    System.out.println(s.getStudentID() + " : " + s.getStudentGPA());
                                }
                                break;

                            case "5":
                                System.out.println();
                                for(Student s : school){
                                    if(s.getStudentGPA() < 3.0){
                                        System.out.println(s.getStudentID() + " : " + s.getStudentGPA());
                                    }
                                }
                                break;

                            case "6":
                            case "exit":
                                istrue = false;
                                System.out.println();
                                break;
                            }
                        }
                    break;

                case"4":
                        System.out.println();
                        if(school.isEmpty()){
                            System.out.println("There are no students. \n");
                            break;
                        }
                         while(true) {
                            boolean notFound = true;
                            if (school.isEmpty()) {
                                System.out.println("There are no students left. \n");
                                break;
                            } else {

                                System.out.println("Enter exit to exit");
                                System.out.println("Students ID");
                                input = scanner.nextLine();

                                if (input.equalsIgnoreCase("exit")) {
                                    break;
                                } else {

                                    for (Student s : school) {
                                        if (input.equals(String.valueOf(s.getStudentID()))) {
                                            notFound = false;
                                            System.out.println("Student: " + s.getStudentName() + ", ID: " + s.getStudentID() + " has been removed! \n");
                                            school.remove(s);
                                            break;
                                        }
                                    }
                                    if(notFound) {
                                        System.out.println(input + " does not exist! \n");
                                    }
                                }
                            }
                        }
                    break;

                case"5":
                case"exit":
                    System.out.println("Exiting Program");
                    scanner.close();
                    return;
                default:
                    System.out.println("Input error! " + input + " is not a option");
                }
           }

    }

    public static boolean checkID (int id, List<Student> list) {
        for (Student s : list) {
            if (id == s.getStudentID()) {
                System.out.println("Error! Student ID already used!");
                return false;
            }
        }
        return true;
    }
}
