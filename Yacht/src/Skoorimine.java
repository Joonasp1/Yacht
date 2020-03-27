import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skoorimine {

    private List<String> tingimused = new ArrayList<String>(Arrays.asList
            ("Ühed", "Kahed", "Kolmed", "Neljad", "Viied", "Kuued", "Maja", "Nelik", "1-2-3-4-5", "2-3-4-5-6", "Täringute summa", "Yacht\n"));



    public void näitaTingimused(){
        for (String tingimus : tingimused){
            if(tingimus != null){ // Pärast tingimuse valimist eemaldatakse tingimus listist, ehk muudetakse null-iks
                System.out.println(tingimused.indexOf(tingimus) + 1 + ". " + tingimus);
            }
        }
    }

    public int skoori(int valik, int[] täringud){
        int skoor = 0;
        switch(valik){ //Case-id ühest kuni kaheteistkümneni
            case 1:
                for (int num : täringud){
                    if(num == 1) skoor++;
                }
        }

        return skoor;
    }
}
