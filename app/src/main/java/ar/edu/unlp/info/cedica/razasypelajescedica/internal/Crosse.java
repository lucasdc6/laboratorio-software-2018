package ar.edu.unlp.info.cedica.razasypelajescedica.internal;

public class Crosse {
    private String name;
    private Horse first;
    private Horse second;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Horse getFirst() {
        return first;
    }

    public void setFirst(Horse first) {
        this.first = first;
    }

    public Horse getSecond() {
        return second;
    }

    public void setSecond(Horse second) {
        this.second = second;
    }

    public Crosse(String name, Horse first, Horse second) {
        setName(name);
        setFirst(first);
        setSecond(second);
    }
}
