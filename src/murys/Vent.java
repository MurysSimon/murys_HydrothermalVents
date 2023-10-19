package murys;

public class Vent {
    private Point start;
    private Point end;

    public Vent(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.switchPos();
    }

    // Metody pro kontrolu zda je ventilace vertikální a nebo horizontální
    public boolean isVertical(){
        return start.getX() == end.getX();
    }

    public boolean isHorizontal(){
        return start.getY() == end.getY();
    }

    // Metoda pro prohození bodů v případě kdy je startovní pozice větší hodnoty než koncová
    public void switchPos(){
        if(start.getX() > end.getX() || start.getY() > end.getY()){
            Point temp = this.start;
            this.start = this.end;
            this.end = temp;
        }
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Vent{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
