package logika;

import java.util.ArrayList;

public class SeznamMest {

    private ArrayList<Mesto> mesta;

    public SeznamMest() {
        mesta = new ArrayList<>();
    }

    public void vlozMesto(Mesto mesto) {
        mesta.add(mesto);
    }

    public Mesto vratMesto(int index) {
        return mesta.get(index);
    }

    public int getSize() {
        return mesta.size();
    }

    public void zamichej() {
        java.util.Collections.shuffle(mesta);
    }
}
