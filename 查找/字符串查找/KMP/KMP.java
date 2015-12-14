/**
 * Created by voidhug on 15/12/14.
 */
public class KMP {

    public static void main(String[] args) {
        String a = "bbc abcdab abcdabcdabde";
        String b = "abcdabd";
        int[] s = getNext(b);
        showList(s);
        System.out.println();
        kmpSearch(a, s, b);
    }

    public static void kmpSearch(String str, int[] next, String pattern) {
        int k = 0;
        int j = 0;
        int count = 0;
        int index = 0;

        while (k < str.length()) {
            if (j == -1 || str.charAt(k) == pattern.charAt(j)) {
                j++;
                k++;
            } else {
                j = next[j];
            }

            if (j == pattern.length()) {
                index = k - j;
                j = 0;
                k++;
                count++;
                System.out.println(index);
            }
        }

        System.out.println(count);
    }

    public static int[] getNext(String P) {
        int[] next = new int[P.length()];
        int j = 0;
        int t = next[0] = -1;

        while (j < P.length() - 1) {
            if (0 > t || P.charAt(j) == P.charAt(t)) {
                j++;
                t++;
                next[j] = t;
            } else {
                t = next[t];
            }
        }

        return(next);
    }

    public static void showList(int next[]) {
        for (int i = 0; i < next.length; i++) {
            System.out.printf("%d ", next[i]);
        }
    }


}
