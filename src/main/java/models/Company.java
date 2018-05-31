package models;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Job> openings;
    private int id;

    private static ArrayList<Company> instances = new ArrayList<>();

    public Company(String name) {
        this.name = name;
        this.openings = new ArrayList<>();
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Job> getOpenings() {
        return openings;
    }

    public static ArrayList<Company> getAll() {
        return instances;
    }

    public int getId() {
        return id;
    }

    public static void clearAll() {
        instances.clear();
    }

    public static Company findById(int id) {
        return instances.get(id-1);
    }

    public void setOpenings(Job opening) {
        this.openings.add(opening);
    }


}
