package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Job {
    private String title;
    private Company company;
    private String description;
    private List<String> qualifications;
    private int salary;
    private  int id;
    private boolean published;
    private LocalDateTime createdAt;


    private static ArrayList<Job> instances = new ArrayList<>();

    public Job(String title, String qualifications, String company, int salary) {
        this.title = title;
        this.qualifications = new ArrayList<String>(){{
            add(qualifications);
        }};
        this.company = new Company(company);
        this.company.setOpenings(this);
        this.salary = salary;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();
    }

    public String getTitle() {
        return title;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications.add(qualifications);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static ArrayList<Job> getAll() {
        return instances;
    }

    public static void clearAll() {
        instances.clear();
    }

    public int getId() {
        return id;
    }

    public static Job findById(int id) {
        return instances.get(id-1);
    }

    public boolean getPublished() {
        return this.published;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void deleteJob() {
        instances.remove(this.id - 1);
    }
}

