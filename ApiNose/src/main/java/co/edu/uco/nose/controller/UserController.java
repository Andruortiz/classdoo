package co.edu.uco.nose.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import co.edu.uco.nose.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.controller.dto.Response;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.dto.UserDTO;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/dummy")
    public UserDTO getUserDTODummy() {
        return new UserDTO();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Response<UserDTO>> findById(@PathVariable UUID id) {
        Response<UserDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new UserFacadeImpl();
            List<UserDTO> user = new ArrayList<UserDTO>();
            user.add(facade.findSpecificUser(id));
            responseObjectData.setData(user);
            responseObjectData.addMessage("User found succesfully!");
        } catch (final NoseException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();
        } catch (final Exception exception) {
            var userMessage = "Unexpected error";
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(userMessage);
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }

        return new ResponseEntity<>(responseObjectData, responseStatusCode);

    }


    @GetMapping("/userFilter")
    public ResponseEntity<Response<UserDTO>> findByFilter(@RequestBody UserDTO userFilters)
    {
        Response<UserDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {

            var facade = new UserFacadeImpl();
            responseObjectData.setData(facade.findUserByFilter(userFilters));
            responseObjectData.addMessage("Users filtered successfully!");
        } catch (final NoseException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();
        } catch (final Exception exception) {
            var userMessage = "Unexpected error";
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(userMessage);
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }

        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }

    @GetMapping
    public ResponseEntity<Response<UserDTO>> findAllUsers() {

        Response<UserDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new UserFacadeImpl();
            responseObjectData.setData(facade.findAllUser());
            responseObjectData.addMessage("All users filtered succesfully!");
        } catch (final NoseException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();
        } catch (final Exception exception) {
            var userMessage = "Unexpected error";
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(userMessage);
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }

        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }

    @PostMapping
    public ResponseEntity<Response<UserDTO>> registerNewUserInformation(@RequestBody UserDTO user) {

        Response<UserDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new UserFacadeImpl();
            facade.registerNewUserInformation(user);
            responseObjectData.addMessage("User registered successfully!");
        } catch (final NoseException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();
        } catch (final Exception exception) {
            var userMessage = "Unexpected error";
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(userMessage);
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }


        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Response<UserDTO>> updateUserInformation(@PathVariable UUID id, @RequestBody UserDTO user) {
        Response<UserDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;
        try {
            var facade = new UserFacadeImpl();
            facade.updateUserInformation(id, user);
            responseObjectData.addMessage(" User updated successfully!");
        } catch (final NoseException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();
        } catch (final Exception exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(" Unexpected error");
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }

        return new ResponseEntity<>(responseObjectData, responseStatusCode);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<UserDTO>> dropUserInformation(@PathVariable UUID id) {
        Response<UserDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new UserFacadeImpl();
            facade.dropUserInformation(id);
            responseObjectData.addMessage("🗑 User deleted successfully!");
        } catch (final NoseException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();
        } catch (final Exception exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(" Unexpected error");
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }

        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleDeserializationError(HttpMessageNotReadableException ex) {
        return ResponseEntity
                .badRequest()
                .body("Error al interpretar el JSON: " + ex.getMessage());
    }

}
