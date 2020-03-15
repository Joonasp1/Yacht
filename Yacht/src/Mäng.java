import java.util.Scanner;

public class Mäng {
    private Scanner scanner = new Scanner(System.in);
    private Mängija[] mängijad;

    private int hetkeMängijaIndeks;

    public Mäng() {

        System.out.print("Mitme mängijaga soovite mängida? ");
        int mängijateArv = scanner.nextInt();
        mängijad = new Mängija[mängijateArv];
        for (int i = 0; i < mängijateArv; i++) {
            System.out.println("Mängija " + (i + 1) + " nimi: ");
            String nimi = scanner.next();
            Mängija mängija = new Mängija(nimi);
            mängijad[i] = mängija;
        }

        järgmine();

    }

    public void järgmine() {
        hetkeMängijaIndeks++;

        if (hetkeMängijaIndeks >= mängijad.length) {
            hetkeMängijaIndeks = 0;
        }

        käik(mängijad[hetkeMängijaIndeks]);
    }

    public void käik(Mängija mängija) {
        System.out.println(mängija.getNimi() + " käik");

        System.out.print("Käigu lõpp. Vajutage, et jätkata. ");
        scanner.nextLine();
        järgmine();
    }
}
