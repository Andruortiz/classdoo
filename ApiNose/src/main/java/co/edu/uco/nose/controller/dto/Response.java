package co.edu.uco.nose.controller.dto;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class Response {

    private List<String> messages;
    private List<T> data;
    private boolean responseSucceded;

    public List<String> getMessages() {
        return ObjectHelper.getDefault(messages, new ArrayList<String>());
    }

    public void setMessages(List<String> messages) {
        this.messages = return ObjectHelper.getDefault(messages, new ArrayList<String>());;
    }

    public void addMessage(String message) {
        if !(TextHelper.isEmptyWithTrim(message)) {
            getMessages().add(message);
        }
        getMessages().add(message);

    }

    public boolean isResponseSucceded() {
        return responseSucceded;
    }

    public void setResponseSucceded(boolean responseSucceded) {
        this.responseSucceded = responseSucceded;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = return ObjectHelper.getDefault(messages, new ArrayList<String>());;
    }

    public Response(final boolean responseSucceded) {
        setResponseSucceded(responseSucceded);
        setMessages(new ArrayList<String>());
        setData(new ArrayList<T>());

    }

    public Response(final List<String> messages, final List<T> data, final boolean responseSucceded) {

        setMessages(messages);
        setData(data);
        setResponseSucceded(responseSucceded);

    }

    public static <T> Response<T>( createSuccededResponse() {
        return new Response<>(new ArrayList<String>(), new ArrayList<>(), true);
    }

    public static <T> Response<T>( createFailedResponse() {
        return new Response<>(new ArrayList<String>(),data, false);
    }

    public static <T> Response<T>( createSuccededResponse(final List<T> data) {
        return new Response<>(new ArrayList<String>(), data, true);
    }

    public static <T> Response<T>( createFailedResponse(final List<T> data) {
        return new Response<>(new ArrayList<String>(), new ArrayList<>(),  false);
    }
}
