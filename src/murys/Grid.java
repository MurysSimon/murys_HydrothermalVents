package murys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static murys.DataReader.readData;

public class Grid {
    List<Vent> listOfVents = new ArrayList<>();
    ArrayList<ArrayList<Integer>> gridOfVents = new ArrayList<>();
    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;
    int numberOfContacts = 0;

    public Grid() {
    }

    public void getVents() {
        try {
            listOfVents = readData("src\\murys\\input.txt");
            for (Vent vent : listOfVents) {
                //System.out.println(vent);
                maxX = Math.max(maxX, Math.max(vent.getStart().getX(), vent.getEnd().getX()));
                maxY = Math.max(maxY, Math.max(vent.getStart().getY(), vent.getEnd().getY()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillGridWithZeroes() {
        for (int j = 0; j <= maxY; j++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int k = 0; k <= maxX; k++) {
                row.add(0);
            }
            gridOfVents.add(row);
        }
    }

    public void printGrid() {
        for (ArrayList<Integer> row : gridOfVents) {
            for (Integer value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public void fillGridWithVents(){
        int startX, startY, endX, endY;

        for (Vent vent: listOfVents) {
            startX = vent.getStart().getX();
            startY = vent.getStart().getY();
            endX = vent.getEnd().getX();
            endY = vent.getEnd().getY();

            for (int y = startY; y <= endY; y++) {
                for (int x = startX; x <= endX; x++) {
                    if(gridOfVents.get(y).get(x) > 0){
                        gridOfVents.get(y).set(x, gridOfVents.get(y).get(x)+1);
                        numberOfContacts++;
                    }
                    else gridOfVents.get(y).set(x, 1);
                }
            }
        }
    }

    public int numberOfPointContacts(){
        int number = 0;
        for (ArrayList<Integer> row : gridOfVents) {
            for (Integer value : row) {
                if(value > 1) number++;
            }
        }
        return number;
    }

    public void printResult(){
        System.out.println("Celkové množství překřížení je: " + numberOfContacts);
        System.out.println("Celkové množství jednotlivých bodů kde dochází k dotekům je: " + numberOfPointContacts());
    }
}
