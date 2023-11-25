package LianZhan;
/**
 * 栈的链式存储结构的实现--链栈
 **/
public class LinkStack implements IStack{
    //1个成员变量--指向栈顶结点
    Node top;

    //1构造方法--创建一个空链栈
    public LinkStack(){
        top = null;
    }

    //成员方法7个
    @Override
    public void clear() {
        //清空
        top = null;
    }

    @Override
    public boolean isEmpty() {
        //判空
        return top == null;
    }

    @Override
    public int length() {
        //返回链栈的长度
        //指针p指向栈顶结点
        Node p =top;
        //定义长度length()
        int length = 0;
        //只要p指向的结点存在，则循环：
        while(p!=null) {
            //长度+1
            length++;
            //p后移1位
            p = p.next;
        }
        //返回长度
        return length;
    }

    @Override
    public Object peek() {
        //取栈顶值(top.data)
        //若栈为空，则返回空
        if(isEmpty())
            return null;
        //否则，返回栈顶元素
        else
            return top.data;
    }

    @Override
    public void push(Object x) throws Exception {
        //将数据值为x的新结点入栈
        //创建数据值为x的新结点
        Node p = new Node(x);
        //将新结点指针域(p.next)设置为原栈顶结点的地址(top)
        p.next = top;
        //修改栈顶指针top，指向新结点p
        top = p;

    }

    @Override
    public Object pop() {
        //将栈顶元素移除，并返回其数据值
        //若栈为空，则返回空
        if(isEmpty()){
            return null;
        }
        //否则：
        else {
           //暂存当前栈顶指针top到指针变量p
            Node p = top;
           //修改栈顶指针，指向当前栈顶结点的后继结点
            top = top.next;
           //返回原栈顶结点的值(p.data)
            return p.data;
        }
    }


    @Override
    public void display() {
        //输出（栈顶到栈底的顺序）
        //指针p指向栈顶结点
        Node p = top;
        //只要p指向的结点存在，则循环：
        while(p!=null) {
            //输出
            System.out.print(p.data + " ");
            //p指向下一个结点
            p = p.next;
        }
        System.out.println();
    }
}
