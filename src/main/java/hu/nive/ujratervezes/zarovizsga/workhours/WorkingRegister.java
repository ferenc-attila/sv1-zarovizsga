package hu.nive.ujratervezes.zarovizsga.workhours;

import java.time.LocalDate;

public class WorkingRegister {

    private String name;
    private int workingHours;
    private LocalDate date;

    public WorkingRegister(String name, int workingHours, LocalDate date) {
        this.name = name;
        this.workingHours = workingHours;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getWorkingHours() {
        return workingHours;
    }
}
