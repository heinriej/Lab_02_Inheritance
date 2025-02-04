import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();

        workers.add(new Worker("John", "Doe", "001", "Mr.", 1980, 20.0));
        workers.add(new Worker("Jane", "Smith", "002", "Ms.", 1985, 25.0));
        workers.add(new Worker("Jim", "Brown", "003", "Mr.", 1990, 30.0));

        workers.add(new SalaryWorker("Alice", "Johnson", "004", "Dr.", 1975, 20.0, 104000.0));
        workers.add(new SalaryWorker("Bob", "Williams", "005", "Prof.", 1980, 30.0, 165000.0));
        workers.add(new SalaryWorker("Charlie", "Davis", "006", "Hon.", 1985, 25.0, 122000.0));

        double[] hoursWorked = {40, 50, 40};

        for (int week = 0; week < hoursWorked.length; week++) {
            System.out.printf("Week %d:%n", week + 1);
            for (Worker worker : workers) {
                worker.displayWeeklyPay(hoursWorked[week]);
            }
            System.out.println();
        }
    }
}