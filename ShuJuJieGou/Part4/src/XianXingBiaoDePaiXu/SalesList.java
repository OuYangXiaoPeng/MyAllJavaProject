package XianXingBiaoDePaiXu;

/**
 * ���ۼ�¼����
 */
public class SalesList {
    //���ۼ�¼��������������㷨
    public static void sort(SalesRecord[] r) {
        for (int i = 0; i < r.length - 1; i++) {
            for (int j = 0; j < r.length - 1; j++) {
                if (r[j].compareTo(r[j + 1]) > 0) {
                    SalesRecord temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
        }
    }

    //�����ʾ
    public static void display(SalesRecord[] r){
        System.out.println("���\t����\t����\t����");
        System.out.println("-----------------------------------");
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i].id+"\t"+r[i].name+"\t"+r[i].num+"\t"+r[i].price);
        }
    }

    public static void main(String[] args) {
        //1������ͼ�����ۼ�¼����ʼ��8�����ۼ�¼
        SalesRecord[] sales=new SalesRecord[8];
        sales[0]=new SalesRecord(101,"C���Ա��",112,33);
        sales[1]=new SalesRecord(103,"΢��ԭ��",156,46);
        sales[2]=new SalesRecord(102,"�ߵ���ѧ",287,36);
        sales[3]=new SalesRecord(105,"Java���",343,40);
        sales[4]=new SalesRecord(108,"���ݽṹ",331,25);
        sales[5]=new SalesRecord(104,"��е��ͼ",289,42);
        sales[6]=new SalesRecord(107,"��������",223,30);
        sales[7]=new SalesRecord(106,"רҵӢ��",118,37);
        //2����ʾ����ǰ�ı��
        System.out.println("����ǰ��");
        display(sales);
        //3������
        sort(sales);
        //4����ʾ�����ı��
        System.out.println("�����������");
        display(sales);

    }
}
