package peli;

import java.util.ArrayList;

public class Peli {

    private String pelaaja1;
    private String pelaaja2;

    public void Ammu(int x, int y) {

    }

    public static void Ammu(Laivue vihollisenLaivue, int x, int y) {
        vihollisenLaivue.yritaAmpuaLaivueeseen(x, y);
    }
}
