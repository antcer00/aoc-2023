package org.example.day15;

import java.util.ArrayList;
import java.util.List;

public class Part2 extends Day15 {

    public static void main(String[] args) {
        Part2 part2 = new Part2();
        List<String> lines = part2.getLines();
        List<String> stringValues = part2.parseValues(lines.get(0));
        List<Box> boxes = part2.initBoxes();
        for (String lensMove : stringValues) {
            part2.executeStep(lensMove, boxes);
        }
        System.out.print(part2.computeTotalFocusingPower(boxes));
    }

    private List<Box> initBoxes() {
        List<Box> boxes = new ArrayList<>(256);
        for (int i = 0; i < 256; i++) {
            boxes.add(new Box());
        }
        return boxes;
    }

    private void executeStep(String lensMove, List<Box> boxes) {
        if (lensMove.contains("=")) {
            String[] split = lensMove.split("=");
            addLens(split[0], Integer.parseInt(split[1]), boxes);
        } else if (lensMove.contains("-")) {
            String[] split = lensMove.split("-");
            removeLens(split[0], boxes);
        }
    }
    
    private void addLens(String label, int focalLength , List<Box> boxes) {
        int boxIndex = hashString(label);
        if (boxes.get(boxIndex).getLenses().contains(new Lens(label))) {
            boxes.get(boxIndex).getLenses().set(boxes.get(boxIndex).getLenses().indexOf(new Lens(label)), new Lens(label, focalLength));
        } else {
            boxes.get(boxIndex).getLenses().add(new Lens(label, focalLength));
        }
    }

    private void removeLens(String label, List<Box> boxes) {
        int boxIndex = hashString(label);
        Box box = boxes.get(boxIndex);
        box.getLenses().remove(new Lens(label));
    }

    private int computeTotalFocusingPower(List<Box> boxes) {
        int totalFocusingPower = 0;
        for (int i = 0; i < boxes.size(); i++) {
            for (int slot = 1; slot <= boxes.get(i).getLenses().size(); slot++) {
                if (boxes.get(i).getLenses().get(slot - 1) != null ) {
                    totalFocusingPower += (i + 1) * slot * boxes.get(i).getLenses().get(slot - 1).getFocalLength();
                }
            }
        }
        return totalFocusingPower;
    }
}
