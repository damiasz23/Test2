package drugiTydzie.poniedzialek;

/**
 * Created by RENT on 2017-07-10.
 */
public class Tablice {
    public static void main(String[] args) {

        int[] tablica = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int wynik = 0;
        for(int elem : tablica){
           //System.out.println(elem);
            wynik += elem;

        }
        System.out.println("Suma elementów w tablicy: " + wynik);

    }
}