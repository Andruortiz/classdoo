package co.edu.uco.nose.dto;

public class CountryDTO {



    private UUID id;
    private String name;

    public CountryDTO() {
        super();
        this.id = UUID.randomUUID();
        this.name = "";
    }

    public CountryDTO(UUID id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public static CountryDTO build() {
        return new CountryDTO();
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
}
