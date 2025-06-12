package classtest.Exception;

public class ExceptionDemo1 {
    public static void main(String[] args) {
//        异常捕捉
        /*
        try{

        }catch(Exception e)
         */
        try {
//            double a;
//            a = 1 / 0;
//            System.out.println(a);
            int d = 10;
            int e = 10;
            System.out.println("d+e:"+(d+e));
        } catch (ArithmeticException e) {
            System.out.println("程序出现了算术异常");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("程序出现异常");
        }finally {
            System.out.println("最后一定会执行的代码");
        }
    }
}
