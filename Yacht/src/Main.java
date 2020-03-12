public class Main {

    public static void main(String[] args) {
        Täringud t1 = new Täringud();
        t1.veereta();
        for (int arv : t1.getTäringud()) {
            System.out.println(arv);
        }
    }

}
