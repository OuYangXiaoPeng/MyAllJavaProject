package DianLianBiaoYingYong3;

import DanLianBiao.LinkList;

public class ProPriceList extends LinkList {

    public ProPriceList() throws Exception {
        super();//调用父类构造方法创建一个空的表
    }

    public ProRecord get(String pNo) throws Exception {
        for (int i = 0; i < this.length(); i++) {
            ProRecord temp = (ProRecord) super.get(i);
            if (temp.proNo.equals(pNo))
                return temp;
        }
        throw new Exception("商品代码：" + pNo + "的商品没找到");
    }

    public void insert(ProRecord p) throws Exception {
        super.insert(this.length(), p);
    }

    public void remove(String pNo) throws Exception {
        int i;
        for (i = 0; i < this.length(); i++) {
            ProRecord temp = ( ProRecord) super.get(i);
            if (temp.proNo.equals(pNo))
                break;
        }
        if (i < length())
            super.remove(i);
        else
            throw new Exception("未找到商品代号:" + pNo + "，无法删除！");
    }

    public ProRecord indexOf2(Object obj){
        for (int i = 0; i < this.length(); i++) {
            ProRecord temp = null;
            try {
                temp = (ProRecord) super.get(i);
            } catch (Exception e) {
                System.out.println("错误！");
            }
            if (temp.proNo.equals(obj)||temp.name.equals(obj))
                return temp;
        }
        return null;
    }

    @Override
    public void display() {
        System.out.println("商品代号\t名称\t\t单价\t\t库存");
        System.out.println("-----------------------------");
        super.display();
    }
}
