public class SalaryWorker extends Worker {
    private double annualSalary;

    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate, double annualSalary) {
        super(firstName, lastName, ID, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.printf("Weekly Pay (fraction of yearly salary): $%.2f%n", weeklyPay);
    }

    @Override
    public String toCSVDataRecord() {
        return super.toCSVDataRecord() + ", " + annualSalary;
    }

    @Override
    public String toJSON() {
        return String.format("{\"firstName\":\"%s\",\"lastName\":\"%s\",\"ID\":\"%s\",\"title\":\"%s\",\"YOB\":%d,\"hourlyPayRate\":%.2f,\"annualSalary\":%.2f}",
                getFirstName(), getLastName(), getID(), getTitle(), getYOB(), annualSalary);
    }

    @Override
    public String toXML() {
        return String.format("<SalaryWorker>%s<AnnualSalary>%.2f</AnnualSalary></SalaryWorker>",
                super.toXML(), annualSalary);
    }
}