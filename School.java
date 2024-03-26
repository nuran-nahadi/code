import java.util.*;
import java.util.stream.StreamSupport;
import java.util.Collections;
import java.util.List;
class Student{
    String name;
    int roll;
    String email;
    Major maj;
    Optional op;
    double CGPA;
    Student(String n,int r,String e){
        name = n;
        roll = r;
        email = e;
    }
    public void setCourses(Major m,Optional o){
        maj = m;
        op = o;
    }
    public double getCGPA(){
        return CGPA = (maj.getWGPA()+op.getWGPA())/10.5;
    }
    public int getRoll(){return roll;}
}
// class CGPAComparator implements Comparator<Student>{

//     @Override
//     public int compare(Student a, Student b){
//         return Double.compare(a.getCGPA(), b.getCGPA());
//     }
// }
class Major{
    private double credit = 3;
    private double WGPA=0;
    private Courses[] majcourses = new Courses[3];

    public void addCourse(int x,Student s,int cc)
    {
        if(cc>2)  return;
        switch (x) {
            case 1:
                majcourses[cc] = new ArtificialIntelligence();
                ArtificialIntelligence.enrolled.enrolledstudents.add(s);
                break;
            case 2:
                majcourses[cc] = new Security();
                Security.enrolled.enrolledstudents.add(s);
                break;
            case 3:
                majcourses[cc] = new OperationResearch();
                OperationResearch.enrolled.enrolledstudents.add(s);
                break;
            case 4:
                majcourses[cc] = new Networking();
                Networking.enrolled.enrolledstudents.add(s);
                break;
            case 5:
                majcourses[cc] = new EmbeddedSystems();
                EmbeddedSystems.enrolled.enrolledstudents.add(s);               
                break;    
            default:
            System.out.println("Invalid Choice");
            addCourse(x, s, cc);
                break;
        }
        addCourse(x, s, cc+1);
    }
    public void setWGPA(){
        for (int i = 0; i < majcourses.length; i++) {
            WGPA += majcourses[i].getGPA() * credit;
        }
    }
    public double getWGPA() {return WGPA;}
}
class Optional{
    private double credit = 1.5;
    private Courses opcourse;
    private double WGPA;
    public void addCourse(int x,Student s)
    {
        switch (x) {
            case 1:
            opcourse = new ArtificialIntelligence();
            ArtificialIntelligence.enrolled.enrolledstudents.add(s);
            ArtificialIntelligence.enrolled.ranked.add(s);
                break;
            case 2:
            opcourse = new Security();
            Security.enrolled.enrolledstudents.add(s);
            Security.enrolled.ranked.add(s);
                break;
            case 3:
            opcourse = new OperationResearch();
            OperationResearch.enrolled.enrolledstudents.add(s);
            OperationResearch.enrolled.ranked.add(s);
                break;
            case 4:
            opcourse = new Networking();
            Networking.enrolled.enrolledstudents.add(s);
            Networking.enrolled.ranked.add(s);
                break;
            case 5:
            opcourse = new EmbeddedSystems();
            EmbeddedSystems.enrolled.enrolledstudents.add(s);
            EmbeddedSystems.enrolled.ranked.add(s);            
                break;    
            default:
            System.out.println("Invalid Choice");
                break;
        }
    }
    public double getWGPA(){
        WGPA = opcourse.getGPA() * credit;
        return WGPA;
    }
}

abstract class Courses{
    private double GPA;
    EvaluationSystem ev;
    static Enrolled enrolled;
    public void setGPA() {
        if (ev.getMarks()>=80 && ev.getMarks()<=100) {
            GPA = 4.00;
        }
        else if (ev.getMarks()<80 && ev.getMarks() >=75) {
            GPA = 3.75;
        }
        else if (ev.getMarks()<75 && ev.getMarks() >= 70) {
            GPA = 3.50;
        }
        else if(ev.getMarks()<70 && ev.getMarks() >=65){
            GPA = 3.25;
        }
        else if (ev.getMarks()<65 && ev.getMarks() >=60) {
            GPA = 3.00;
        }
        else if (ev.getMarks()<60 && ev.getMarks() >= 55) {
            GPA = 2.75;
        }
        else if (ev.getMarks()<55 && ev.getMarks() >= 50) {
            GPA = 2.50;
        }
        else if (ev.getMarks()<50 && ev.getMarks() >= 45) {
            GPA = 2.25;
        }
        else if (ev.getMarks()<45 && ev.getMarks() >= 40) {
            GPA = 2.00;
        }
        else GPA = 0.00;
    }
    public double getGPA(){return GPA;}   
}

class EvaluationSystem extends Courses{
    Midterm mid;
    RegularAssessment ra;
    Final finals;
    private double obtainedMarks;
    public void setMarks(){
        obtainedMarks = mid.getResult()+ra.getResult()+finals.getResult();
    }
    public double getMarks(){return obtainedMarks;}
}
class Midterm{
    private double totalmid = 0;
    private double midmarks = 0;
    Midterm(double m){
        totalmid = m;
    }
    public void updateResult(double r){midmarks = r;}
    public double getResult(){return midmarks;}
}
class RegularAssessment{
    private double totalAssignment;
    private double totalAttendance;
    private double assignmentMarks;
    private double attendanceMarks;

    RegularAssessment(double x)
    {
        totalAssignment = x;
        totalAttendance = 0;
    }
    RegularAssessment(double x,double y)
    {
        totalAssignment = x;
        totalAttendance = y;
    }
    public void updateResult(double p){
        assignmentMarks = p;
        attendanceMarks = 0;
    }
    public void updateResult(double p, double q){
        assignmentMarks = p;
        attendanceMarks = q;
    }
    public double getResult(){return assignmentMarks+attendanceMarks;}
}
class Final{
    private double totalFinal;
    private double finalMarks;

    Final(double x){
        totalFinal = x;
    }
    public void updateResult(double x){
        finalMarks = x;
    }
    public double getResult(){return finalMarks;}
}

class Enrolled{
    List<Student> enrolledstudents;
    List<Student> ranked;
    
    
}
class ArtificialIntelligence extends Courses{

}
class Security extends Courses{

}
class OperationResearch extends Courses{

}
class Networking extends Courses{

}
class EmbeddedSystems extends Courses{

}
class GPArank{
    List<Student> students;
    for(int i=0;i < students.size();i++){
        for (int j = 0; j < students.size(); j++) {
            if (students.get(j).CGPA > students.get(j+1).CGPA) {
                Student temp = students.get(j);
            }
        }
    }
}
public class School {
    public static void main(String[] args) {
        //Student[] allStudents = new Student[100];
        List<Student> allstudents;
    }
}
