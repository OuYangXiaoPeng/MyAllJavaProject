package LianZhan;
/**
 * 结点类--构成链表的基础
 * */
public class Node {
    //2成员变量个
    public Object data;//数据域--保存元素值
    public Node next;//指针域--保存下一个结点的地址

    //3个构造方法
    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
    public Node(Object data){
        this.data = data;
        this.next = null;
    }
    public Node(){
        data = null;
        next = null;
    }

}
