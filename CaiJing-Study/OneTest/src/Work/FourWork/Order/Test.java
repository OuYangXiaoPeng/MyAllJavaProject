package Work.FourWork.Order;

public class Test {
    public static void main(String[] args) {
        Restaurant t = new Teacher();
        Teacher teacher = (Teacher) t;
        teacher.order();

        Restaurant s = new Student();
        Student student = (Student) s;
        student.order();

        Restaurant d = new Doctor();
        Doctor doctor = (Doctor) d;
        doctor.order();
    }
}
