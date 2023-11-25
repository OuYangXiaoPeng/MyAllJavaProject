package ShunXunDuiLie;

import LianDuiLie.LinkQueue;

public class TestSqQueue {

    public static void main(String[] args) throws Exception {
        //创建队列，入队5个偶数
        CircleSqQueue myQueue = new CircleSqQueue(20);
        for (int i = 0; i < 5; i++) {
            myQueue.offer(i*2);
        }
        //输出
        myQueue.display();
        //长度
        System.out.println("队列的长度为:"+myQueue.length());
        //移除2次
        System.out.println("第一次出队:"+myQueue.poll());
        System.out.println("第二次出队:"+myQueue.poll());
        //输出
        myQueue.display();
        //队首元素
        System.out.println("队首元素为:"+ myQueue.peek());
        //入队5个奇数
        for (int i = 0; i < 5; i++) {
            myQueue.offer(2*i+1);
        }
        //输出
        myQueue.display();
        //清空
        System.out.println("队列的长度为:"+myQueue.length());
//        while (!myQueue.isEmpty()) {
//            System.out.println("连续出队:"+myQueue.poll());
//        }
//        for (;!myQueue.isEmpty();) {
//            System.out.println("连续出队:"+myQueue.poll());
//        }
        int len = myQueue.length();
        for (int i = 1; i <= len; i++) {
            System.out.println("第"+i+"个出队:"+myQueue.poll());
        }
//        myQueue.clear();
        System.out.println("清空后:");
        //判空
        System.out.println("是否为空:"+ myQueue.isEmpty());
    }
}
