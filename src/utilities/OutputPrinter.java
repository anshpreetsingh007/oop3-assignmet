package utilities;

import shapes.Shape;

public class OutputPrinter {

    public static void printSample(Shape[] arr) {
        if (arr.length == 0) {
            System.out.println("(no shapes)");
            return;
        }

        System.out.println(formatLine(0, arr[0]));

        for (int i = 999; i < arr.length; i += 1000) {
            System.out.println(formatLine(i, arr[i]));
        }

        if (arr.length > 1) {
            System.out.println(formatLine(arr.length - 1, arr[arr.length - 1]));
        }
    }

    private static String formatLine(int idx, Shape s) {
        String metricLabel;
        double metricValue;

        switch (Shape.getCompareType()) {
            case BASE_AREA:
                metricLabel = "baseArea";
                metricValue = s.calcBaseArea();
                break;
            case VOLUME:
                metricLabel = "volume";
                metricValue = s.calcVolume();
                break;
            default:
                metricLabel = "height";
                metricValue = s.getHeight();
                break;
        }

        return String.format("%d: %s %s=%.6f",
                idx,
                s.getClass().getSimpleName(),
                metricLabel,
                metricValue
        );
    }
}