import java.util.List;
import java.util.ArrayList;

class Student{
	private int rollNo;
	private String name;
	Student(String name, int rollNo){
		this.name = name;
		this.rollNo = rollNo;
	}
	public int getRollNo(){
		return rollNo;
	}
	public void setRollNo(int rollNo){
		this.rollNo = rollNo;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
}

interface StudentDao{
	public List<Student> getAllStudents();
	public Student getStudent(int rollNo);
	public void updateStudent(Student student);
	public void deleteStudent(Student student);
}

class StudentDaoImpl implements StudentDao{
	List<Student> students;
	public StudentDaoImpl(){
		students = new ArrayList<Student>();
		Student student1 = new Student("Robert", 0);
		Student student2 = new Student("John", 1);
		students.add(student1);
		students.add(student2);
	}
	@Override
	public void deleteStudent(Student student){
		students.remove(student.getRollNo());
		System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
	}
	@Override
	public List<Student> getAllStudents(){
		return students;
	}
	@Override
	public Student getStudent(int rollNo){
		return students.get(rollNo);
	}
	@Override
	public void updateStudent(Student student){
		students.get(student.getRollNo()).setName(student.getName());
		System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
	}
}

public class DAOPattern{
	public static void main(String[] args){
		StudentDao studentDao = new StudentDaoImpl();
		for (Student student : studentDao.getAllStudents()) {
			System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
		}
		Student student = studentDao.getAllStudents().get(0);
		student.setName("Michael");
		studentDao.updateStudent(student);
		
		studentDao.getStudent(0);
		System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
	}
}

