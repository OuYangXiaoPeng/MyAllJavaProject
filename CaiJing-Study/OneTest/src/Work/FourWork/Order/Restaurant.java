package Work.FourWork.Order;

public class Restaurant {
    public void order(){
        System.out.println("默认菜单");
    }
}

class Teacher extends Restaurant {
    public void order(){
        System.out.println("老师点了香辣肉丝");
    }
}

class Student extends Restaurant {
    public void order(){
        System.out.println("学生点了火腿炒面");
    }
}

class Doctor extends Restaurant {
    public void order(){
        System.out.println("医生点了麻辣香锅");
    }
}