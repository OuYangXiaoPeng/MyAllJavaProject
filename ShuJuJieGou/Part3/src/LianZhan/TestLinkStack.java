package LianZhan;
/**
 * 链栈的测试类——创建链栈对象，初始化，各种基本操作
 * @author yhyym
 */
public class TestLinkStack {

    public static void main(String[] args) throws Exception {
        //1、创建空链栈——构造方法
        LinkStack stk = new LinkStack();
        //2、连续入栈5个偶数（0-8）——push方法
        for (int i = 0; i < 5; i++)
            stk.push(2 * i);
        //3、输出栈元素——display
        stk.display();
        //4、输出栈的长度——length
        System.out.println("栈的长度：" + stk.length());
        //5、取栈顶元素输出——peek
        System.out.println("栈顶元素：" + stk.peek());
        //6、连续出栈两次，并输出出栈的元素——pop
        System.out.println("第一次出栈元素：" + stk.pop());
        System.out.println("第二次出栈元素：" + stk.pop());
        //7、输出栈元素——display
        stk.display();
        //8、连续入栈5个计数（1-9）
        for (int i = 0; i < 5; i++)
            stk.push(2 * i + 1);
        //9、输出栈元素——display
        stk.display();
        //10、清空栈——clear
        stk.clear();
        //11、判空栈——isEmpty
        System.out.println("栈是否空：" + stk.isEmpty());

    }

}
