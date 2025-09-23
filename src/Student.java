public class Student {
    String firstName;
    String lastName;
    int studentID;
    double gpa;

    Student(String firstName, String lastName, int studentID, double gpa){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.gpa = gpa;
    }

    String getStudentName(){
        return firstName + " " + lastName;
    }

    String getStudentInfo(){
        return  "First Name: "+ firstName + " \n" +
                "Last Name: " + lastName + " \n" +
                "Student ID: " + studentID + " \n" +
                "GPA: " + gpa ;
    }

    public double getStudentGPA (){
        return gpa;
    }

    int getStudentID (){
        return studentID;
    }
}
