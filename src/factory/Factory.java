package factory;

import java.util.*;

// object holding a triplet of panels matching the volume and cost of production
class BoxInfo {
    int cost;
    ArrayList<int[]> panels;

    // setting lowest cost to max int
    BoxInfo() {
        this.cost = 2_147_483_647;
    }
}

public class Factory {
    private List<int[]> set;
    private int volume;

    // writing input values on start
    public Factory(List<int[]> set, int volume) {
        this.set = set;
        this.volume = volume;
    }

    // checking panel's length
    private void checkPanelValidity(int[] panel) {
        if (panel.length != 2) {
            throw new IllegalArgumentException("Panel size " + Arrays.toString(panel) + " is invalid.");
        }
        if (panel[0] < 1 || panel[1] < 1) {
            throw new IllegalArgumentException("Panel size " + Arrays.toString(panel) + " is invalid.");
        }
    }

    // comparing two panels
    private boolean compareTwoPanels(int[] panel1, int[] panel2) {
        checkPanelValidity(panel1);
        checkPanelValidity(panel2);
        return panel1[0] == panel2[0] && panel1[1] == panel2[1] || panel1[0] == panel2[1] && panel1[1] == panel2[0];
    }

    // removing duplicate values from the panel list
    private void removeDoubles() {
        for (int i = 0; i < this.set.size(); i++) {
            for (int j = i + 1; j < this.set.size(); j++) {
                if (compareTwoPanels(this.set.get(i), this.set.get(j))) {
                    this.set.remove(j);
                    j--;
                }
            }
        }
    }

    // checking if panel triplet is valid and making up a box and return its volume if it is, -1 in all other cases
    private int checkTripletValidity(int[] panel1, int[] panel2, int[] panel3) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (panel1[i] == panel2[j]) {
                    if (panel1[1 - i] == panel3[0] && panel2[1 - j] == panel3[1]) {
                        return panel1[i] * panel1[1 - i] * panel3[1];
                    } else if (panel1[1 - i] == panel3[1] && panel2[1 - j] == panel3[0]) {
                        return panel1[i] * panel1[1 - i] * panel3[0];
                    }
                }
            }
        }
        return -1;
    }

    // find valid triplets, put them in a BoxInfo object
    private ArrayList<int[]> findLowestValidTriplet() {
        BoxInfo boxInfo = new BoxInfo();
        for (int i = 0; i < this.set.size(); i++) {
            for (int j = i; j < this.set.size(); j++) {
                for (int k = j; k < this.set.size(); k++) {
                    int result = checkTripletValidity(this.set.get(i), this.set.get(j), this.set.get(k));
                    if (result == this.volume) {
                        int cost = this.set.get(i)[0] * this.set.get(i)[1] + this.set.get(j)[0] * this.set.get(j)[1] +
                                this.set.get(k)[0] * this.set.get(k)[1];
                        if (cost < boxInfo.cost) {
                            // creating ArrayList to put into BoxInfo object
                            ArrayList<int[]> validTriplet = new ArrayList<>();
                            validTriplet.add(this.set.get(i));
                            validTriplet.add(this.set.get(j));
                            validTriplet.add(this.set.get(k));
                            boxInfo.panels = validTriplet;
                            boxInfo.cost = cost;
                        }

                    }
                }
            }
        }

        // checking if costMap is empty or null
        if (boxInfo.panels != null && !boxInfo.panels.isEmpty()) {
            return boxInfo.panels;
        }
        return new ArrayList<>();
    }

    // public getter
    public ArrayList<int[]> getResult() {
        removeDoubles();
        return findLowestValidTriplet();
    }
}