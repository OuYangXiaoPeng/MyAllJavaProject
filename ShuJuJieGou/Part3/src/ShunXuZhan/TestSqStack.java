package ShunXuZhan;
/*
*顺序栈测试类
* */

public class TestSqStack {

    public static void main(String[] args) throws Exception {
        //创建一个长度为10的空顺序栈
        SqStack myStack = new SqStack(10);
        //1.加入5个元素
        String [] str = {"Jim","Jess","Jill","Jane","Joe"};
        for (int i = 0; i < str.length; i++) {
            myStack.push(str[i]);
        }

        myStack.display();
        //插入
        System.out.println("插入tom:");
        myStack.insert(2,"tom");
        myStack.display();
        //2.输出长度
        System.out.println("栈的长度为:"+myStack.length());
        //3.栈顶元素
        System.out.println(myStack.peek() +"是在栈顶位置的元素");
        //4.加入元素"Mike"
        myStack.push("Mike");
        System.out.println("加入'Mike':");
        myStack.display();
        //5.弹出栈顶元素
        System.out.println("弹出栈顶元素:");
        myStack.pop();
        myStack.display();
        //6.清空
        myStack.clear();
        System.out.println("清空后:");
        //7.判断是否为空
        System.out.println("是否为空:"+myStack.isEmpty() );
    }
}