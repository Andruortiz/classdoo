package co.edu.uco.nose.dto;

import java.util.UUID;

public class IdTypeDTO {


    private UUID id;
    private String name;

    public IdTypeDTO() {
        super();
        this.id = UUID.randomUUID();
        this.name = "";
    }

    public IdTypeDTO(UUID id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
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


}
