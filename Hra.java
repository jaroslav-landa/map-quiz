package logika;

import java.util.Observable;

public class Hra extends Observable {

    private double skore = 0;
    private int pocetOdehranychKol = 0;
    private Mesto aktualni;
    private SeznamMest mesta;

    public Hra() {
        zalozSeznamMest();
    }

    public void vynulujVsechno() {
        System.out.println("nová hra byla spuštěna");
        pocetOdehranychKol = 0;
        skore = 0;
        mesta.zamichej();
        setChanged();
        notifyObservers();
    }

    public void zalozSeznamMest() {
        mesta = new SeznamMest();
        Mesto praha = new Mesto("Praha", 287, 200);
        mesta.vlozMesto(praha);
        Mesto brno = new Mesto ("Brno", 522, 345);
        mesta.vlozMesto(brno);
        Mesto ostrava = new Mesto ("Ostrava", 703, 238);
        mesta.vlozMesto(ostrava);
        Mesto plzen = new Mesto ("Plzeň", 172, 254);
        mesta.vlozMesto(plzen);
        Mesto liberec = new Mesto ("Liberec", 348, 81);
        mesta.vlozMesto(liberec);
        Mesto olomouc = new Mesto ("Olomouc", 603, 281);
        mesta.vlozMesto(olomouc);
        Mesto usti = new Mesto ("Ústní nad Labem", 254, 100);
        mesta.vlozMesto(usti);
        Mesto hradec = new Mesto ("Hradec Králové", 432, 172);
        mesta.vlozMesto(hradec);
        Mesto budejovice = new Mesto ("České Budějovice", 287, 383);
        mesta.vlozMesto(budejovice);
        Mesto pardubice = new Mesto ("Pardubice", 427, 206);
        mesta.vlozMesto(pardubice);
    }

    public void hrajKolo() {
        if (pocetOdehranychKol + 1 != mesta.getSize()) {
            aktualni = mesta.vratMesto(pocetOdehranychKol++);
            System.out.println(aktualni);
        }
        else {
            System.out.println(skore);
        }
        setChanged();
        notifyObservers();
    }

    public void prepocitejSkore(double kliknutoX, double kliknutoY) {
        double vzdalenostX = Math.abs(aktualni.getSouradniceX() - kliknutoX);
        double vzdalenostY = Math.abs(aktualni.getSouradniceY() - kliknutoY);
        double bodyX = 1/vzdalenostX;
        double bodyY = 1/vzdalenostY;
        skore = skore + bodyX + bodyY;
        setChanged();
        notifyObservers();
    }

    public double getSkore() {
        return skore;
    }

    public Mesto getAktualni() {
        return aktualni;
    }
}
