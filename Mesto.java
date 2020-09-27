package logika;

public class Mesto {

    private String nazev;
    private double souradniceX;
    private double souradniceY;

    public Mesto(String nazev, double souradniceX, double souradniceY) {
        this.nazev = nazev;
        this.souradniceX = souradniceX;
        this.souradniceY = souradniceY;
    }

    @Override
    public String toString() {
        return nazev;
    }

    public double getSouradniceX() {
        return souradniceX;
    }

    public double getSouradniceY() {
        return souradniceY;
    }
}
