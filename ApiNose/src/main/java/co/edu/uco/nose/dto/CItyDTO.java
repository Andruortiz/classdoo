package co.edu.uco.nose.dto;

public class CItyDTO {

    private UUID id;
    private String name;
    private StateDTO state;

    public CityDTO() {
        super();
        this.id = UUID.randomUUID();
        this.name = "";
        this.state = new StateDTO();
    }

    public CityDTO(UUID id, String name, StateDTO state) {
        super();
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public static CityDTO build() {
        return new CityDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StateDTO getState() {
        return state;
    }

    public void setState(StateDTO state) {
        this.state = state;
    }
}
