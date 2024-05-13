public class Ricorsion {
    public static int fibo(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibo(n - 1) + fibo(n - 2);
    }

    public static boolean isCrescent(int[] a, int pos){
        if(pos == 0) return true;
        return a[pos] >= a[pos - 1] && isCrescent(a, pos - 1);
    }

    public static boolean isPalindrome(String s, int pos){
        if(s.length() / 2 == pos) return true;
        return s.charAt(pos) == s.charAt(s.length() - pos - 1) && isPalindrome(s, pos + 1);
    }

    public static int molt(int a, int b){
        if(a == 0||b == 0) return 0;
        
        return a + molt(a, b - 1);
    }

    public static int power(int a, int b){
        if(b == 0) return 1;
        return a * power(a, b - 1);
    }

    

    public static void main(String[] args) {
        int[] a = {4 ,5 ,6 ,7};
        String s = "anna";

        System.out.println(fibo(7));
        System.out.println(isCrescent(a, a.length - 1));
        System.out.println(isPalindrome(s, 0));
        System.out.println(molt(5, 2));
        System.out.println(power(5, 2));
    }
}
