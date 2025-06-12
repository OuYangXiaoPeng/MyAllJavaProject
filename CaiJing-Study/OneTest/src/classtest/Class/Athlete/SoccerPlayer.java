package classtest.Class.Athlete;

public class SoccerPlayer extends Athlete {
    String club;

    public SoccerPlayer() {
    }

    public SoccerPlayer(String name, int age, String major, String club) {
        super(name, age, major);
        this.club = club;
    }

    @Override
    public void show() {
        System.out.println("名字:" + name + "，年龄:" + age +
                "，专业:" + major + "，部门:" + club);
    }

}
