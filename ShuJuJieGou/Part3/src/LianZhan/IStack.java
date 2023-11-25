package LianZhan;
/**
 * 栈的接口
 * */
public interface IStack {
    //清空
    public void clear();
    //判空
    public boolean isEmpty();
    //求长
    public int length();
    //取栈顶元素的值
    public Object peek();
    //入栈
    public void push(Object x) throws Exception;
    //出栈
    public Object pop();
    //输出（栈顶到栈底的顺序）
    public void display();
}
