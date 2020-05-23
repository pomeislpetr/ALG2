package pkg11_recursion;

/**
 *
 * @author Pomeisl Petr
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(fac(4));
        System.out.println(facR(4));
        int[] a = {23, 45, 21, 34};
        System.out.println(fm(a, 4));
        System.out.println(fm1(a, 0, 3));
    }

    //factorial iterativne 4! = 1 * 2 * 3 * 4 = 24
    public static int fac(int n) {
        int fac = 1;
        for (int i = 2; i <= n; i++) {
            fac = fac * i;
        }
        return fac;
    }

    //factorial rekurzivne
    public static int facR(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * facR(n - 1);
        }
    }

    /*
    facR(4) = 24
    4 * facR(3) = 4 * 6 = 24
      3 * facR(2) = 3 * 2 = 6
        2 * facR(1) = 2 *1 = 2
          1
     */
 /*
    mystery(3, 11) = 33
    mystery(6, 5) + 3 = 30 + 3 = 33
        mystery(12, 2) + 6 = 24 + 6 = 30
            mystery(24, 1) = 24
                mystery(48, 0) + 24 = 24
                    0
     */
    public static int fm(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        return Math.max(a[n - 1], fm(a, n - 1));
    }
    
    /*
    {21, 54, 21, 34}
    fm(a, 4) = 45
    max(34, fm(a, 3)) = 45
            max(21, fm(a, 2)) = 45
                    max(54, fm(a, 1)) = 45
                            23
    */
    
    public static int fm1(int[] a, int from, int to){
        if(from >= to){
            return a[from];
        }
        int half = (from+to)/2;
        int left = fm1(a, from, half);
        int right = fm1(a, half+1, to);
        if(left >= right){
            return left;
        }else{
            return right;
        }
    }
    
    /*
    {21, 54, 21, 34}
    fm1(a, 1, 3) = 
        half = 3 / 2 = 1
        left = fm1(a, 0, 1) = 45
               half = 1 / 2 = 0
               left = fm1(a, 0, 0) = 23
                      a[0] = 23
               right = fm1(a, 1, 1) = 45
                       a[1] = 45
               45 //45 > 23
        right = fm1(a, 2, 3) = 34
                half = 5 / 2 = 2
                left = fm1(a, 2, 2) = 21
                       a[2] = 21
                right = fm1(a, 3, 3) = 34
                        a[3] = 34
                34 //34 > 21
        45 //45 > 34
    */
}
