package practice.hw.l5_ivan;
import com.fasterxml.jackson.xml.XmlMapper;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        // JSON
        JSONObject jo = new JSONObject(Files.readString(new File("target/input.json").toPath()));

        ObjectMapper objectMapper = new ObjectMapper();
        Computer computer = objectMapper.readValue(jo.toString(), Computer.class);
        computer.setColor("gold");
        computer.setPrice(2000);
        JSONObject json2 = new JSONObject(computer);

        FileWriter fw = new FileWriter("target/output.json");
        fw.write(json2.toString());
        fw.flush();
        fw.close();

        // XML
        XmlMapper xmlMapper = new XmlMapper();
        Computer computer2 = xmlMapper.readValue(Files.readString(new File("target/input.xml").toPath()), Computer.class);
        computer.setName("iPad");
        FileWriter fw2 = new FileWriter("target/output.xml");
        String xmlString = xmlMapper.writeValueAsString(computer2);
        fw2.write(xmlString);
        fw2.flush();
        fw2.close();

        // Stream
        Employee e1 = new Employee("John P.", 3000, "developer");
        Employee e2 = new Employee("Sarah M.", 2000, "designer");
        Employee e3 = new Employee("Charles B.", 900, "develper");
        Employee e4 = new Employee("Mary T.", 5000, "Team Lead");
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4);
        List<String> customersWithMoreThan100Points = employees
                .stream()
                .filter(Employee::hasBiggerSalaryThanThousand)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(customersWithMoreThan100Points);
    }
}
