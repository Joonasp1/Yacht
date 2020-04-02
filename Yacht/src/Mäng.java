import java.util.Scanner;

public class Mäng {
    private Scanner scanner = new Scanner(System.in);
    private Mängija[] mängijad;
    private Täringud täringud = new Täringud();
    private String valik;
    private Skoorimine skoor = new Skoorimine();
    private int tingumusvalik;

    private int hetkeMängijaIndeks;

    public Mäng() {//Meetod küsib vajaliku info mängu jaoks

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

    public void järgmine() {//Meetod valib uueks käiguks uue mängija
        hetkeMängijaIndeks++;

        if (hetkeMängijaIndeks >= mängijad.length) {
            hetkeMängijaIndeks = 0;
        }

        käik(mängijad[hetkeMängijaIndeks]);
    }

    public void käik(Mängija mängija) {
        System.out.println(mängija.getNimi() + " käik");
        valik = "";

        System.out.println("Valige skoorimistingimus:");
        skoor.näitaTingimused();
        tingumusvalik = scanner.nextInt();

        while (täringud.getKordus() < 3 && !valik.equals("ei")){ //Tsüklist väljutakse, kui veeretatud on 3 korda või kui kasutaja sisestab "ei"
            if(valik.equals("")) täringud.veereta();
            else täringud.veereta(täringud.getTäringud(), valik);
            täringud.setKordus(täringud.getKordus() + 1);
            System.out.println(täringud.toString());
            System.out.println("Valige täringud mida uuesti veeretada (1-5 ja eraldage komadega). Kirjuta \"ei\" kui ei soovi veeretada");
            valik = scanner.next();
            System.out.println(valik);
        }

        mängija.liidaSkoor(skoor.skoori(tingumusvalik,täringud.getTäringud()));
        System.out.println(mängija.getNimi() + " Skoor on: " + mängija.getSkoor());
        täringud.setKordus(0);
        if(skoor.getTingimused().isEmpty()) kokkuvõte(mängijad);
        else järgmine();
    }

    public void kokkuvõte(Mängija[] mängijad){ //Teeb kokkuvõtte mängust ja annab teada, kes võitis
        System.out.println("Mängijate tulemused:");
        int võitskoor = -1;
        String võitjanimi = "";
        for (Mängija mängija : mängijad){
            if(võitskoor < mängija.getSkoor()){
                võitjanimi = mängija.getNimi();
                võitskoor = mängija.getSkoor();
            }
            System.out.println(mängija.getNimi() + ": " + mängija.getSkoor());
        }
        System.out.println("Võitja on " + võitjanimi + " punktisummaga " + võitskoor);

    }
}
