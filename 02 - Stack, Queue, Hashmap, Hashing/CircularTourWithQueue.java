import java.util.*;

public class CircularTourWithQueue {

    static class PetrolPump {
        int petrol, distance;
        PetrolPump(int p, int d) {
            this.petrol = p;
            this.distance = d;
        }
    }

    public static int circularTour(PetrolPump[] pumps) {
        int n = pumps.length;
        Queue<Integer> queue = new LinkedList<>();

        int start = 0;
        int end = 0;
        int currentSurplus = 0;

        while (true) {
            currentSurplus += pumps[end].petrol - pumps[end].distance;
            queue.add(end);

            // If surplus becomes negative, remove from start
            while (currentSurplus < 0 && !queue.isEmpty()) {
                int removedIndex = queue.poll();
                currentSurplus -= pumps[removedIndex].petrol - pumps[removedIndex].distance;
                start = (removedIndex + 1) % n;
            }

            end = (end + 1) % n;

            if (queue.size() == n) {
                return start; // Completed full circle
            }

            // If we looped back and no result
            if (start == 0 && end == 0 && !queue.isEmpty()) {
                break;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };

        int startIndex = circularTour(pumps);
        if (startIndex != -1) {
            System.out.println("Start at petrol pump index: " + startIndex);
        } else {
            System.out.println("No possible tour.");
        }
    }
}
