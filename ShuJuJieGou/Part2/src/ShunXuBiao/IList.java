package ShunXuBiao;
//线性表的抽象数据类型描述--8个操作
public interface IList {
//    1.清空
    public void clear();
//    2.判空
    public boolean isEmpty();
//    3.求长
    public int length();
//    4.取值
    public Object get(int i)throws Exception;
//    5.插入
    public void insert(int i,Object x)throws Exception;
//    6.删除
    public void remove(int i)throws Exception;
//    7.查找
    public int indexOf(Object x);
//    8.输出
    public void display();

}
