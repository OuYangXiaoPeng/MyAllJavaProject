package LianShi2;


public class StuRec2 {

    String stuNo;
    String Name;
    int score;
    StuRec2 next;

    public StuRec2() {
    }

    public StuRec2(String stuNo, String Name, int score, StuRec2 next) {
        this.Name = Name;
        this.stuNo = stuNo;
        this.score = score;
        this.next = next;
    }

}
