package classtest.Class.Athlete;

public class Test {
    public static void main(String[] args) {
        Athlete a = new Athlete("张三", 25, "足球");
//        a.show();

        //向上转型，但还是父类的对象
        Athlete a1 = new SoccerPlayer("李四", 26, "篮球", "足球");
        SoccerPlayer s = (SoccerPlayer) a1;//向下转型
        s.show();
    }
}
