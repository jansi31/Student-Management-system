package projects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
class Student{
	String name;
	int rollno;
	String course;
	Student(String name,int rollno,String course){
		this.name=name;
		this.rollno=rollno;
		this.course=course;
	}
	public void display() {
		System.out.println("Name : "+name);
		System.out.println("Rollno : "+rollno);
		System.out.println("Course: "+course);
	}
	public String getname() {
		return name;
	}
	public int getroll() {
		return rollno;
	}
	public void setname(String name) {
		this.name=name;
	}
	public void setrollno(int rollno) {
		this.rollno=rollno;
	}
	public void setcourse(String course) {
		this.course=course;
	}
}
class manager{
	private List<Student> student=new ArrayList<>();
	public void addstudent(Student s) {
		student.add(s);
		System.out.println("Student added successfully...");
	}
	public void display() {
		if(student.isEmpty()) {
			System.out.println("no students list");
		}else {
		for(Student s:student) {
			s.display();
		}
		}
	}
	public void searchstudent(String name) {
		for(Student s:student) {
			if(s.getname().equals(name)) {
				s.display();
				return;
			}
		}
		System.out.println("student not found...");
	}
	public void update(String cname,String newname,int newrollno,String newcourse) {
		for(Student S:student) {
			if(S.getname().equals(cname)) {
				S.setname(newname);
				S.setrollno(newrollno);
				S.setcourse(newcourse);
				System.out.println("Student updated ");
				return;
			}
		}
	}
	public void delete(int rollno) {
		Iterator<Student> i=student.iterator();
		while(i.hasNext()) {
			if(i.next().getroll()==rollno) {
				i.remove();
				System.out.println("Student deleted..");
				return;
			}
		}
		System.out.println("Student not found`");
	}
}
public class StudentManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc=new Scanner(System.in);
       manager m=new manager();
       while(true) {
    	   System.out.println("------Student Management System");
    	   System.out.println("1.Add Student");
    	   System.out.println("2.Show all student");
    	   System.out.println("3.Search a student");
    	   System.out.println("4.Update Student");
    	   System.out.println("5.delete student");
    	   System.out.println("6.Exit");
    	   System.out.println("Enter your choice");
    	   int choice=sc.nextInt();
    	   sc.nextLine();
    	   switch(choice) {
    	   case 1:
    		   System.out.print("Enter the Student name: ");
    		   String name=sc.nextLine();
    		   System.out.print("Enter the roll no: ");
    		   int rollno=sc.nextInt();
    		   sc.nextLine();
    		   System.out.print("Enter the course name: ");
    		   String course=sc.nextLine();
    		   m.addstudent(new Student(name,rollno,course));
    		   break;
    	   case 2:
    		   m.display();
    		   break;
    	   case 3:
    		   System.out.print("Enter the name: ");
    		   String search=sc.nextLine();
    		   m.searchstudent(search);
    		   break;
    	   case 4:
    		   System.out.print("Enter the current name to update: ");
    		   String cname=sc.nextLine();
    		   System.out.print("Enter the new name to update: ");
    		   String newname=sc.nextLine();
    		   System.out.print("Enter the roll number to update: ");
    		   int newroll=sc.nextInt();
    		   sc.nextLine();
    		   System.out.print("Enter the course to update: ");
    		   String newcourse=sc.nextLine();
    		   m.update(cname,newname,newroll,newcourse);
    		   break;
    	   case 5:
    		   System.out.print("Enter the roll no to be deleted: ");
    		   int delroll=sc.nextInt();
    		   sc.nextLine();
    		   m.delete(delroll);
    		   break;
    	   case 6:
    		   return;
    		   default: 
    			   System.out.println("invalid option");
    	   }
       }
	}

}
