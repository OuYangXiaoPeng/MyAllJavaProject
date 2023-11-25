package beans;

public class SecondaryHandler implements SayHandler{
    @Override
    public void saySomeThing() {
        System.out.println("我是第二个SayHandler的一种实现，完成简单的文本输出");
    }
}
