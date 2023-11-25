package SQList;

//顺序表存储结构的实现，
public class SqList implements IList {

    public SqList() {}

    //成员变量
    Object[] listElem;//线性表元素数组
    int curLen;        //当前元素的总数

    //构造方法--指定容量的空的顺序表
    public SqList(int maxSize) {
        listElem = new Object[maxSize];
        curLen = 0;
    }

    //成员方法
    @Override
    public void clear() {
        //清空
        curLen = 0;
    }

    @Override
    public boolean isEmpty() {
        //判断当前表是否为空
        return curLen == 0;
    }

    @Override
    public int length() {
        //返回当前表长
        return curLen;
    }

    @Override
    public Object get(int i) throws Exception {
        //取顺序表第i号元素的值，返回
        //若参数i不在合法范围[0..curLen-1]，则抛出异常
        if (i < 0 || i > curLen - 1)
            throw new Exception("第" + i + "号元素不存在!");
        return listElem[i];
    }

    @Override
    public void insert(int i, Object x) throws Exception {
        //插入
        if (i < 0 || i > curLen)
            throw new Exception("第" + i + "号元素不存在!");
        if (curLen >= listElem.length)
            throw new Exception("超出储存！");
        for (int j = curLen; j > i; j--) {
            listElem[j] = listElem[j - 1];//后移
        }
        listElem[i] = x; //插入
        curLen++;
    }

    @Override
    public void remove(int i) throws Exception {
        //删除
        if (i < 0 || i > curLen - 1)
            throw new Exception("第" + i + "号元素不存在!");
        if (curLen <= 0)
            throw new Exception("超出储存！");

        for (int j = i; j < curLen - 1; j++) {
            listElem[j] = listElem[j + 1];//后移
        }
        curLen--;
    }

    @Override
    public int indexOf(Object x) {
        for (int j = 0; j < curLen; j++) {
            if (listElem[j].equals(x))
                return j;
        }
        return -1;
    }

    @Override
    public void display() {
        //输出所有值
        for (int i = 0; i < curLen; i++) {
            System.out.print(listElem[i]);
        }
        System.out.println();
    }
}
