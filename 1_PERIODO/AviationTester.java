public class AviationTester {
    public static void main(String[] args) {
        Aeromotore a = new Aeromotore("45982", 500);
        Glider g = new Glider("kjhasd", 50);
        Jet j = new Jet("oiweeyi", 740, 4);

        System.out.println(a.morePowerful(j));
        System.out.println(g.morePowerful(j));
    }
}
