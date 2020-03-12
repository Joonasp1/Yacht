import java.util.ArrayList;

public class Täringud {

    private int[] täringud = new int[5];

    public int[] getTäringud() {
        return täringud;
    }

    public int[] veereta(){
        for (int i = 0; i < täringud.length; i++) {
            int arv =(int)(Math.round(Math.random()*5+1));
            täringud[i] = arv;
        }
        return täringud;
    }


}
