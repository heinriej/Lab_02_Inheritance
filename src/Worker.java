public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate) {
        super(firstName, lastName, ID, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        double regularPay = Math.min(40, hoursWorked) * hourlyPayRate;
        double overtimePay = Math.max(0, hoursWorked - 40) * hourlyPayRate * 1.5;
        return regularPay + overtimePay;
    }

    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(40, hoursWorked);
        double overtimeHours = Math.max(0, hoursWorked - 40);
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double totalPay = regularPay + overtimePay;

        System.out.printf("Regular Hours: %.2f, Regular Pay: $%.2f%n", regularHours, regularPay);
        System.out.printf("Overtime Hours: %.2f, Overtime Pay: $%.2f%n", overtimeHours, overtimePay);
        System.out.printf("Total Pay: $%.2f%n", totalPay);
    }

    @Override
    public String toCSVDataRecord() {
        return super.toCSVDataRecord() + ", " + hourlyPayRate;
    }

    @Override
    public String toJSON() {
        return String.format("{\"firstName\":\"%s\",\"lastName\":\"%s\",\"ID\":\"%s\",\"title\":\"%s\",\"YOB\":%d,\"hourlyPayRate\":%.2f}",
                getFirstName(), getLastName(), getID(), getTitle(), getYOB(), hourlyPayRate);
    }

    @Override
    public String toXML() {
        return String.format("<SalaryWorker>%s<HourlyPayRate>%.2f</HourlyPayRate></SalaryWorker>",
                super.toXML(), hourlyPayRate);
    }
}