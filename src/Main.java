public class Main {

    public static void main(String[] args) {
//        System.out.println(gcd(49, 22));
        int i[] = ExtendedEuclidean.extendedEuclidean(240, 46);
        for (int x : i) {
            System.out.println(x);
        }
    }
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
