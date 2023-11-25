package DuiLieDeYingYong;

import LianDuiLie.LinkQueue;

/*
 * 舞伴配对问题
 * 跳舞规则--先来后到FIFO
 * */
public class DancePartener {

    public static void main(String[] args) throws Exception {
        //1.初始化男生、女士、舞曲数
        int m = 5;
        int w = 8;
        int music = 12;
        //2.创建两个队列，男生女士分别编号入队
        LinkQueue mQ = new LinkQueue();
        for (int i = 1; i <= m; i++) {
            mQ.offer("第" + i + "号男生");
        }
        LinkQueue wQ = new LinkQueue();
        for (int i = 1; i <= w; i++) {
            wQ.offer("第" + i + "号女生");
        }
        mQ.display();
        wQ.display();
        //3.舞曲循环：
        int n = mQ.length() > wQ.length() ? wQ.length() : mQ.length();
        for (int i = 1; i <= music; i++) {
            //提示信息
            System.out.println("第" + i + "支舞曲开始:");
            //循环(配对，次数为较短队列的长度)
            for (int j = 1; j <= n; j++) {
                //从男生队列出列一人
                Object mP = mQ.poll();
                //从女士队列出列一人
                Object wP = wQ.poll();
                System.out.println(mP + "-" + wP);
                //男生归队
                mQ.offer(mP);
                //女生归队
                wQ.offer(wP);
            }
        }


    }
}
