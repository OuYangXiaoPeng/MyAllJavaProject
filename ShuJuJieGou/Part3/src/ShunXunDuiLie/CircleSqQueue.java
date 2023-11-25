package ShunXunDuiLie;
/**
 * 队列的顺序存储结构--循环顺序队列
 * */
public class CircleSqQueue implements IQueue {

    //3个成员变量
    private int front;
    private int rear;
    private Object[] queueElem;

    //构造方法--创建一个指定的空队列
    public CircleSqQueue(int maxSize) {
        this.queueElem = new Object[maxSize];
        front = 0;
        rear = 0;
    }

    @Override
    public void clear() {
        //清空
        queueElem = null;
        front =0;
        rear = 0;
    }

    @Override
    public boolean isEmpty() {
        //判空
        return front == rear;
    }

    @Override
    public int length() {
        //求长
        return (rear - front + queueElem.length) % queueElem.length;
    }

    @Override
    public Object peek() {
        //取队首元素的值
        if (isEmpty())
            return null;
        else
            return queueElem[front];
    }

    @Override
    public void offer(Object x) throws Exception {
        //入队
        //若队列已满(front在rear的前面一个单位，rear循环+1等于front)，则抛出异常
        if(front == (rear + 1) % queueElem.length) {
            throw new Exception("满队列，无法添加" + x);
        }
        //否则：
        else {
            //元素x存储在队尾
            queueElem[rear]  = x;
            //队尾指针+1
            rear = (rear + 1) % queueElem.length;
        }
    }

    @Override
    public Object poll() {
        //出队
        //若队为空，则提示
        if(isEmpty())
            return "队列为空！";
        //否则：
        else {
            //将当前队首元素暂存
            Object value = queueElem[front];
            //修改队首指针front+1
            front = (front + 1) % queueElem.length;
            //返回原队首元素
            return value;
        }
    }

    @Override
    public void display() {
        //输出队列(按队首到队尾)
        if (!isEmpty()) {
            for (int i = front; i != rear; i = (i + 1) % queueElem.length) {
                System.out.print(queueElem[i] + " ");
            }
            System.out.println();
        }
        else
            System.out.println("队列为空！");
    }
}
