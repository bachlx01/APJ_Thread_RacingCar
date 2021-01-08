import java.util.Random;

public class Car extends Thread {
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int position = 0;
        long startTime = System.currentTimeMillis();

        while (position < Main.DISTANCE) {
            try {
                int speed = (new Random()).nextInt(20);
                position += speed;
                String log = "|";
                int percentTravel = (position * 100) / Main.DISTANCE;
                for (int i = 0; i < Main.DISTANCE; i += Main.STEP) {
                    if ((position >= i && position < i + Main.STEP) || (position >= Main.DISTANCE - Main.STEP && i >= Main.DISTANCE - Main.STEP)) {
                        log += "o";
                    } else if (position > i) {
                        log += "=";
                    }
                    else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.printf("%-7s%-30s%-5d" + "Km\n","Car " + this.name, log, Math.min(Main.DISTANCE, position));
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("Car " + this.name + " broken...");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");

    }
}
