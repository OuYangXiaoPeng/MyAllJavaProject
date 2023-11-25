package InvertString;

public class InvertString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public void reverseString2(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    public static void main(String[] args) {
        InvertString s = new InvertString();
        char[] a = {'a', 'b', 'c', 'd', 'e'};

//        s.reverseString(a);
        s.reverseString2(a);

        for (char A : a){
            System.out.println(A);
        }
    }
}
