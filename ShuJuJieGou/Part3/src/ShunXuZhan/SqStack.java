package ShunXuZhan;
/*
 *栈的顺序存储结构的实现
 * */
public class SqStack implements IStack {
    //2个成员变量
    private Object [] stackElem;
    private int top;

    //构造方法1个
    public SqStack(int maxSize) {
        stackElem = new Object[maxSize];
        top = 0;
    }

    //7个成员方法
    @Override
    public void clear() {
        //清空
        top = 0;
    }

    @Override
    public boolean isEmpty() {
        //判空
        return top == 0;
    }

    @Override
    public int length() {
        //求长
        return top;
    }

    @Override
    public Object peek() {
        //取栈顶元素的值
        return stackElem[top-1];
    }

    @Override
    public void push(Object x) throws Exception {
    //入栈
        if(top == stackElem.length)
            throw new Exception("栈已满！");
        else{
            stackElem[top] = x;
            top++;
        }

    }

    @Override
    public Object pop() {
        //出栈
        if (top == 0)
            return null;
        top = top - 1;
        return stackElem[top];
    }

    public void insert(int n,Object x) throws Exception {
        //插入
        SqStack stack = new SqStack(n+1);
        for(int i = 0; i < n; i++){
            stack.push(this.peek());
            this.pop();
        }
        this.push(x);
        for(int i = 0; i < n; i++){
            this.push(stack.peek());
            stack.pop();
        }
    }

    public void display() {
        //输出
        if (top == 0){
            System.out.println("栈为空！");
            return;
        }
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(stackElem[i].toString() + " ");
        }
        System.out.println();
    }
}
