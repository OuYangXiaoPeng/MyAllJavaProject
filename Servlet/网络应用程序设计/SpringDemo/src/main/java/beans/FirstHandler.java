package beans;

public class FirstHandler implements SayHandler {
    @Override
    public void saySomeThing() {
        System.out.println("我是SayHandler的一种实现，完成简单的文本输出");
    }
}
