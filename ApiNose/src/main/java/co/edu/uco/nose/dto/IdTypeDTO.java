package co.edu.uco.nose.dto;

import java.util.UUID;

public class IdTypeDTO {


    private UUID id;
    private String name;
    private String description;

    public IdTypeDTO() {
        super();
        this.id = UUID.randomUUID();
        this.name = "";
        this.description = "";
    }

    public IdTypeDTO(UUID id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static IdTypeDTO build() {
        return new IdTypeDTO();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
