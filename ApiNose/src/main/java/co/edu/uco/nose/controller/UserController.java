package co.edu.uco.nose.controller;

import co.edu.uco.nose.business.facede.impl.UserFacadeImpl;
import co.edu.uco.nose.controller.dto.Response;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping
    public ResponseEntity<Response<UserDTO> findAllUsers() {

        Response<UserDTO> responseObjectDara = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;
        try {
            var facade = new UserFacadeImpl();
            responseObjectDara.setData(facade.findAllUser());


            responseObjectDara.addMessage("All users filtered successfully.");
            q3

        }catch (NoseException exception) {
            responseObjectDara = Response.createFailedResponse();
            responseObjectDara.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();

        } catch (Exception exception) {
            var userMessage = "Unexpected error";
            responseObjectDara = Response.createFailedResponse();
            responseObjectDara.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }


        return new ResponseEntity<>(responseObjectDara, responseStatusCode);
    }

    @PostMapping
    public String registerNewUserInformation() {
        return "POST: User registered";
    }

    @PutMapping
    public String updateUserInformation() {
        return "UPDATE: User updated";
    }

    @DeleteMapping
    public String dropUserInformation() {
        return "DELETE: User deleted";
    }
}
