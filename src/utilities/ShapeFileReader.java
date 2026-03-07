/**
 * @Author Diego Galvis
 *
 * ShapeFileReader is a utility class used to read shape data from a text file.
 * It reads each line of the file, creates the correct Shape object based on
 * the shape type, and stores all shapes in an array.
 */

package utilities;

import shapes.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class ShapeFileReader {

    public static Shape[] read(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String first = br.readLine();
            if (first == null) throw new IllegalArgumentException("Empty file: " + filename);

            int n = Integer.parseInt(first.trim());
            Shape[] arr = new Shape[n];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null) throw new IllegalArgumentException("Expected " + n + " shapes, found only " + i);

                String[] parts = line.trim().split("\\s+");
                if (parts.length < 3) throw new IllegalArgumentException("Bad shape line: " + line);

                String type = parts[0].trim();
                double h = Double.parseDouble(parts[1]);
                double x = Double.parseDouble(parts[2]); // radius or side

                arr[i] = makeShape(type, h, x);
            }

            return arr;
        }
    }

    private static Shape makeShape(String typeRaw, double h, double x) {
        String type = typeRaw.trim().toLowerCase();

        switch (type) {
            case "cylinder": return new Cylinder(h, x);
            case "cone":     return new Cone(h, x);
            case "pyramid":  return new Pyramid(h, x);

            case "squareprism":      return new SquarePrism(h, x);
            case "triangularprism":  return new TriangularPrism(h, x);
            case "pentagonalprism":  return new PentagonalPrism(h, x);
            case "octagonalprism":   return new OctagonalPrism(h, x);

            default:
                throw new IllegalArgumentException("Unknown shape type: " + typeRaw);
        }
    }
}