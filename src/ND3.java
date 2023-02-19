
//1. Parašyti metodą, kuris patikrina ar per parametrus paduotame žodyje yra raidžių derinių "ab".
// Prieš atliekant veiksmus patikrinti ar paduotas žodis yra tinkamas, jei ne- grąžinti 0.
// Užuomina: radus "a" raidę tikrinti ar sekanti raidė (i + 1) yra "b".

import javax.sound.sampled.Line;
import java.util.*;

public class ND3 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void main(String[] args) {
        String raides;
        String fraze;
        int ipr;                // indeksas rastos pirmos raidės
        int rl = -1;            //Raides ilgis
        int rp;                 // raidžių paieškos returnui
        Scanner sk = new Scanner(System.in);
        System.out.println("Įveskite raides kurias norite ieškoti");
        raides = sk.nextLine();
        System.out.println("Įveskite frazę kurioje norite ieškoti");
        fraze = sk.nextLine();
        ipr = rastiPirmaRaide(raides, fraze);
        rl = rastiRaidesIlgi(raides);
        // System.out.println(ipr + "  ddddddd");
        rp = RaidziuPaieska(raides, fraze, ipr);
        if (rp > 0) {
            raidziuSpalvinimas(fraze, ipr, rl);
        } else {
            System.out.println("Nieko nerasta");
        }
        //  System.err.println("NN");
    }
    static int RaidziuPaieska(String raides, String fraze, int ipr) { //grąžina 0-jei nerado ir 1 jei rado
        int b = 0;
        int rl = raides.length();
        for (int j = 0; j < rl; j++) {      //tikrinam kitas raides
            if (raides.charAt(j) != fraze.charAt(ipr)) {
                b = 0;
                break;
            }
            ipr++;
            b = 1;
        }
        return b;
    }
    static void raidziuSpalvinimas(String s, int ifr, int ils) {
        char[] ch = s.toCharArray();
        for(int j=0;j<ifr;j++){
            System.out.print(ch[j]);
        }
        for (int i = ifr; i < ils + ifr; i++) {
            //  System.out.print(ifr+"  ");
            System.out.print(ANSI_BLUE + ch[i] + ANSI_RESET);
        }
        for(int k=ils+ifr;k < s.length();k++){
            System.out.print(ch[k]);
        }
    }
    static int rastiPirmaRaide(String raides, String fraze) {
        int ri = 0;
        for (int i = 0; i < fraze.length(); i++) {
            if (raides.charAt(0) == fraze.charAt(i)) {  //ieskom pirmos ieskomos raidės frazėje
                ri = i;
                break;
            }
        }
        return ri;
    }
    static int rastiRaidesIlgi(String raides) { // nustato ieškomų raidžių ilgį
        int rl;
        rl = raides.length();
        return rl;
    }
}