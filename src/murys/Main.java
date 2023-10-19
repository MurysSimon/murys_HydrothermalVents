package murys;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.getVents();
        grid.fillGridWithZeroes();
        grid.fillGridWithVents();
        grid.printResult();
    }
}