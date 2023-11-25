package LianDuiLie;

/*
 * 队列的链式存储结构实现
 * */
public class LinkQueue implements IQueue {
    //成员变量2个
    Node front, rear;

    //构造方法1个
    public LinkQueue() {
        front = null;
        rear = null;
    }

    //成员方法7个
    @Override
    public void clear() {
        //清空
        front = null;
        rear = null;
    }

    @Override
    public boolean isEmpty() {
        //判空
        return front == null || rear == null;
    }

    @Override
    public int length() {
        //返回链队列的长度
        //指针p指向栈顶结点
        Node p = front;
        //定义长度length()
        int length = 0;
        //只要p指向的结点存在，则循环：
        while (p != null) {
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
        //队首元素
        //若队列为空，则返回空
        if (isEmpty())
            return null;
            //否则，返回栈顶元素
        else
            return front.data;
    }

    @Override
    public void offer(Object x) throws Exception {
        //将数据值为x的新结点入队
        //创建数据值为x的新结点
        Node p = new Node(x);
        //若队列为空
        if (rear == null) {
            //同时修改队首、队尾指针，指向新结点p
            rear = p;
            front = p;
        }
        //否则，
        else {
            //修改原队尾结点的指针域为新结点的地址p(建立链接关系)
            rear.next = p;
            //修改队尾指针，指向新的队尾结点p
            rear = p;
        }
    }

    @Override
    public Object poll() {
        //将队列元素移除，并返回其数据值
        //若队列为空，则返回空
        if (front == null) {
            return null;
        }
        //否则：
        else {
            //暂存当前队首指针到指针变量p
            Node p = front;
            //修改队首指针，指向当前栈顶结点的后继结点
            front = front.next;
            //若当前队列只有唯一的结点，则：
            if (rear == p) {
                //同时修改队首、队尾指针，指向空值
                front = null;
                rear = null;
            }
            //返回原栈顶结点的值(p.data)
            return p.data;
        }
    }

    @Override
    public void display() {
        //输出(从队首到队尾)
        //指针p指向队首结点
        Node p = front;
        //只要p指向的结点存在，则循环：
        while (p != null) {
            //输出
            System.out.print(p.data + " ");
            //p指向下一个结点
            p = p.next;
        }
        System.out.println();
    }
}
