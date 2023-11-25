package LianDuiLie;
/**
 * 队列的接口
 * */
public interface IQueue {
    //清空
    public void clear();
    //判空
    public boolean isEmpty();
    //求长
    public int length();
    //取队首元素的值
    public Object peek();
    //入队
    public void offer(Object x) throws Exception;
    //出队
    public Object poll();
    //输出（队首到队尾的顺序）
    public void display();
}
