import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {
    private Worker worker;

    @BeforeEach
    public void setUp() {
        worker = new Worker("John", "Doe", "001", "Mr.", 1980, 20.0);
    }

    @Test
    public void testCalculateWeeklyPay_RegularHours() {
        double pay = worker.calculateWeeklyPay(40);
        assertEquals(800.0, pay, 0.01, "Regular pay calculation failed");
    }

    @Test
    public void testCalculateWeeklyPay_OvertimeHours() {
        double pay = worker.calculateWeeklyPay(50);
        assertEquals(1100.0, pay, 0.01, "Overtime pay calculation failed");
    }

    @Test
    public void testCalculateWeeklyPay_NoHours() {
        double pay = worker.calculateWeeklyPay(0);
        assertEquals(0.0, pay, 0.01, "No hours pay calculation failed");
    }

    @Test
    public void testToCSVDataRecord() {
        String csv = worker.toCSVDataRecord();
        assertEquals("001, John, Doe, Mr., 1980, 20.0", csv, "CSV data record failed");
    }

    @Test
    public void testToJSON() {
        String json = worker.toJSON();
        assertEquals("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"ID\":\"001\",\"title\":\"Mr.\",\"YOB\":1980,\"hourlyPayRate\":20.00}", json, "JSON conversion failed");
    }

    @Test
    public void testToXML() {
        String xml = worker.toXML();
        assertEquals("<SalaryWorker><Person><FirstName>John</FirstName><LastName>Doe</LastName><ID>001</ID><Title>Mr.</Title><YOB>1980</YOB></Person><HourlyPayRate>20.00</HourlyPayRate></SalaryWorker>", xml, "XML conversion failed");
    }
}