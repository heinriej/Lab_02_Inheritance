import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SalaryWorkerTest {
    private SalaryWorker sw;

    @BeforeEach
    public void setUp() {
        sw = new SalaryWorker("John", "Doe", "12345", "Engineer", 1985, 50.0, 104000.0);
    }

    @Test
    public void testCalculateWeeklyPay() {
        double expectedWeeklyPay = 104000.0 / 52;
        assertEquals(expectedWeeklyPay, sw.calculateWeeklyPay(40), 0.01);
    }

    @Test
    public void testDisplayWeeklyPay() {
        double expectedWeeklyPay = 104000.0 / 52;
        sw.displayWeeklyPay(40);
    }

    @Test
    public void testToCSVDataRecord() {
        String expectedCSV = "12345, John, Doe, Engineer, 1985, 50.0, 104000.0";
        assertEquals(expectedCSV, sw.toCSVDataRecord());
    }

    @Test
    public void testToJSON() {
        Worker sw = new SalaryWorker("John", "Doe", "12345", "Engineer", 1985, 50.0, 104000.0);
        String expectedJSON = "{\"firstName\":\"%s\",\"lastName\":\"%s\",\"ID\":\"%s\",\"title\":\"%s\",\"YOB\":%d,\"hourlyPayRate\":%.2f,\"annualSalary\":%.2f}";
        assertEquals(expectedJSON, sw.toJSON());
    }

    @Test
    public void testToXML() {
        String expectedXML = "<SalaryWorker><SalaryWorker><Person><FirstName>John</FirstName><LastName>Doe</LastName><ID>12345</ID><Title>Engineer</Title><YOB>1985</YOB></Person><HourlyPayRate>50.00</HourlyPayRate></SalaryWorker><AnnualSalary>104000.00</AnnualSalary></SalaryWorker>";
        assertEquals(expectedXML, sw.toXML());
    }
}