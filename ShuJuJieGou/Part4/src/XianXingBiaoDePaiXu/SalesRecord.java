package XianXingBiaoDePaiXu;

/**
 * ��Ʒ���ۼ�¼��--�Զ������
 */
public class SalesRecord implements Comparable {
    //��Ա����4��--��������š����ۡ�����
    int id;
    String name;
    int num;
    int price;

    //���췽2��
    public SalesRecord() {
    }

    public SalesRecord(int id, String name, int num, int price) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        //����������ǿתΪSaleRecord����
        SalesRecord s = (SalesRecord) o;
        //ͨ�������Ĳ�����ʾ��������Ĺ�ϵ
        return this.price - s.price;
    }
}
