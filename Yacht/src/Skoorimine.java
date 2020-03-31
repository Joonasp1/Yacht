import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Skoorimine {

    private List<String> tingimused = new ArrayList<String>(Arrays.asList
            ("1. Ühed", "2. Kahed", "3. Kolmed", "4. Neljad", "5. Viied", "6. Kuued", "7. Maja", "8. Nelik", "9. 1-2-3-4-5", "10. 2-3-4-5-6", "11. Täringute summa", "12. Yacht\n"));



    public void näitaTingimused(){
        for (String tingimus : tingimused){
                System.out.println(tingimus);
            }
    }

    public int skoori(int valik, int[] täringud){
        int skoor = 0;
        int[] numbrid = new int[]{1,2,3,4,5,6};
        int[] sorttäring = täringud.clone();
        Arrays.sort(sorttäring);

        switch(valik){
            case 1:
                for (int num : täringud){
                    if(num == 1) skoor++;
                }
                tingimused.remove("1. Ühed");
                break;
            case 2:
                for (int num : täringud){
                    if(num == 2) skoor+= 2;
                }
                tingimused.remove("2. Kahed");
                break;
            case 3:
                for (int num : täringud){
                    if(num == 3) skoor+= 3;
                }
                tingimused.remove("3. Kolmed");
                break;
            case 4:
                for (int num : täringud){
                    if(num == 4) skoor+= 4;
                }
                tingimused.remove("4. Neljad");
                break;
            case 5:
                for (int num : täringud){
                    if(num == 5) skoor+= 5;
                }
                tingimused.remove("5. Viied");
                break;
            case 6:
                for (int num : täringud){
                    if(num == 6) skoor+= 6;
                }
                tingimused.remove("6. Kuued");
                break;
            case 7:
                int palju = 0;
                int praegune = 0;
                int[] unique = IntStream.of(täringud).distinct().toArray();
                for(int i = 0; i < 2; i++) {
                    praegune = unique[i];
                    for (int num : täringud) {
                        if (num == praegune){
                            skoor += num;
                            palju++;
                        }
                    }
                }
                if(palju != 5) skoor = 0;
                tingimused.remove("7. Maja");
                break;
            case 8:
                for(int num : numbrid){
                    int mitu = 0;
                    for(int täring : täringud){
                        if(num == täring) mitu++;
                    }
                    if(mitu >= 4){
                        skoor += mitu * num;
                        break;
                    }
                }
                tingimused.remove("8. Nelik");
                break;
            case 9:
                if(sorttäring[0] == 1 && sorttäring[1] == 2 && sorttäring[2] == 3 && sorttäring[3] == 4 && sorttäring[4] == 5)
                    skoor += 30;
                tingimused.remove("9. 1-2-3-4-5");
                break;
            case 10:
                if(sorttäring[0] == 2 && sorttäring[1] == 3 && sorttäring[2] == 4 && sorttäring[3] == 5 && sorttäring[4] == 6)
                    skoor += 30;
                tingimused.remove("10. 2-3-4-5-6");
                break;
            case 11:
                for (int num:täringud)
                    skoor += num;
                tingimused.remove("11. Täringute summa");
                break;
            case 12:
                boolean sama = true;
                int num = täringud[0];
                for(int tar : täringud){
                    if(tar != num){
                        sama = false;
                        break;
                    }
                }
                if(sama) skoor += 50;
                tingimused.remove("12. Yacht");
                break;
        }

        return skoor;
    }
}
