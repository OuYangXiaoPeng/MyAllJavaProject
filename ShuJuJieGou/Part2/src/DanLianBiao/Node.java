package DanLianBiao;
/*
结点类
每个结点类就是一个元素的结点内存映象，
 */
public class Node {
//    2个成员变量
    Object data;//数据域
    Node next;//指针域

    public Node(){
        this(null,null);
    }

    public Node(Object data){
        this(data,null);
    }

    public Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }
}
