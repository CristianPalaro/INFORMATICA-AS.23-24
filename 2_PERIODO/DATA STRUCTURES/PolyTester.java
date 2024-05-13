public class PolyTester {
    public static void main(String[] args) {
        Polynomial p = new Polynomial(new Term(1, 5));
        p.add(new Polynomial(new Term(1, 4)));

        System.out.println(p.toString());
    }
}
