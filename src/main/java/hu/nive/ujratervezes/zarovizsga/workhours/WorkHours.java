package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class WorkHours {

    public String minWork(String file) {
        List<WorkingRegister> registers = parseWorkHours(file);
        WorkingRegister min = findRegisterWithMinWorkingHour(registers);
        return min.getName() + ": " + min.getDate().toString();
    }

    private List<WorkingRegister> parseWorkHours(String file) {
        List<WorkingRegister> result = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(createWorkingRegisterByRow(line));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file" + file);
        }
        return result;
    }

    private WorkingRegister createWorkingRegisterByRow(String line) {
        try {
            String[] row = line.split(",");
            return new WorkingRegister(row[0], Integer.parseInt(row[1]), LocalDate.parse(row[2]));
        } catch (NullPointerException | DateTimeParseException | NumberFormatException | PatternSyntaxException e) {
            throw new IllegalArgumentException("Invalid data in row " + line);
        }
    }

    private WorkingRegister findRegisterWithMinWorkingHour(List<WorkingRegister> registers) {
        return registers.stream().min(Comparator.comparing(WorkingRegister::getWorkingHours)).orElseThrow(() -> new IllegalStateException("Empty list of registers!"));
    }
}
