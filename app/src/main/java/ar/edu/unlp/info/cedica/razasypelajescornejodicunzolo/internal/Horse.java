package ar.edu.unlp.info.cedica.razasypelajescornejodicunzolo.internal;

public class Horse {
    private Integer id;
    private Integer imageId;
    private String race;
    private String coats;

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Horse(Integer imageId, String race) {
        setImgeId(imageId);
        setRace(race);
    }
}
