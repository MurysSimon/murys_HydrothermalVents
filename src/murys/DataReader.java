package murys;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public static List<Vent> readData(String filePath) throws IOException {
        List<Point> points = new ArrayList<>();
        List<Vent> vents = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" -> ");
                String[] firstPoint = parts[0].split(",");
                String[] secondPoint = parts[1].split(",");

                int x1 = Integer.parseInt(firstPoint[0]);
                int y1 = Integer.parseInt(firstPoint[1]);
                int x2 = Integer.parseInt(secondPoint[0]);
                int y2 = Integer.parseInt(secondPoint[1]);

                Point point1 = new Point(x1, y1);
                Point point2 = new Point(x2, y2);

                Vent vent = new Vent(point1, point2);
                if(vent.isVertical() || vent.isHorizontal()) vents.add(vent);
            }
        }

        return vents;
    }
}
