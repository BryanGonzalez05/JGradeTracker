import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       ArrayList<Student> school = new ArrayList<>();

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
            input = input.toLowerCase();
            switch(input){
                case "1":
                    while(true) {
                        String fn;
                        String ln;
                        int id;
                        double gpa;

                        System.out.println("Enter Students First Name");
                        input = scanner.nextLine();

                        while(!input.matches("[a-zA-Z]+")) {
                            System.out.println("Invalid First Name!");
                            input = scanner.nextLine();
                        }

                        fn = input;
                        System.out.println("Enter Students Last Name");
                        input = scanner.nextLine();

                        while(!input.matches("[a-zA-Z]+")){
                            System.out.println("Invalid Last Name!");
                            input = scanner.nextLine();
                        }

                        ln = input;
                        System.out.println("Enter Students ID");
                        input = scanner.nextLine();

                        //fix this
                        while(!input.matches("\\d+") && (input.length() != 8 && checkID(Integer.parseInt(input), school)) ){
                            System.out.println("Error! Invalid Student ID");
                            input = scanner.nextLine();
                        }

                        id = Integer.parseInt(input);
                        System.out.println("Enter Students GPA");
                        input = scanner.nextLine();

                        if(input.length() != 3 && !input.matches("[0-4](\\.\\d{1,2})?") && Double.parseDouble(input) < 0.0 && Double.parseDouble(input) > 4.0 ) {
                            System.out.println("Error! Invalid GPA");
                            input = scanner.nextLine();
                        }
                        gpa = Double.parseDouble(input);

                        Student ns = new Student(fn,ln,id,gpa);
                        System.out.println("New Student added");
                    }
                case"2":

                case"3":

                case"4":

                case"5":
                case"exit":
                    System.out.println("Exiting Program");
                    return;
                default:
                    System.out.println("Input error! " + input + " is not a option");
                }
           }
       }

    public static boolean checkID (int id, ArrayList<Student> list) {
        for (Student s : list) {
            if (id == s.getStudentID()) {
                System.out.println("Error! Student ID already used!");
                return false;
            }
        }
        return true;
    }
}
