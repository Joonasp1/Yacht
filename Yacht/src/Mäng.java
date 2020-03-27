import java.util.Scanner;

public class Mäng {
    private Scanner scanner = new Scanner(System.in);
    private Mängija[] mängijad;
    private Täringud täringud = new Täringud();
    private String valik;
    private Skoorimine skoor = new Skoorimine();

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

        täringud.veereta();
        System.out.println(täringud.toString());
        System.out.println("Valige täringud mida uuesti veeretada (1-5 ja eraldage tühikuga). Kirjuta \"ei\" kui ei soovi veeretada");
        valik = scanner.next();
        while (täringud.getKordus() < 3 && !valik.equals("ei")){ //Probleemne koht
            täringud.veereta(täringud.getTäringud(), valik);
            System.out.println(täringud.toString());
            System.out.println("Valige täringud mida uuesti veeretada (1-5 ja eraldage tühikuga). Kirjuta \"ei\" kui ei soovi veeretada");
            valik = scanner.next();
        }

        System.out.println("Valige skoorimistingimus:");
        skoor.näitaTingimused();
        System.out.println(täringud.toString());
        täringud.setKordus(0);
        System.out.print("Käigu lõpp. Vajutage, et jätkata. ");
        scanner.nextLine();
        järgmine();
    }
}
