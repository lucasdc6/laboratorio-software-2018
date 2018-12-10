package ar.edu.unlp.info.cedica.razasypelajescedica.internal;

public class Horse {
    private Integer imageId;
    private String race;
    private String coats;


    public Integer getImgeId() {
        return imageId;
    }

    public void setImgeId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCoats() {
        return coats;
    }

    public void setCoats(String coats) {
        this.coats = coats;
    }

    public Horse(Integer imageId, String race, String coats) {
        setImgeId(imageId);
        setRace(race);
        setCoats(coats);
    }
}
