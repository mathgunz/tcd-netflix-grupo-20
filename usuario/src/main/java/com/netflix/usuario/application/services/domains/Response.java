package com.netflix.usuario.application.services.domains;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
    private T user;
    private List<String> errors;

    public T getUser() {
        return user;
    }

    public void setUser(T user) {
        this.user = user;
    }

    public List<String> getErrors() {
        if (this.errors == null) {
            this.errors = new ArrayList<String>();
        }
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public Response(){
    }

}
