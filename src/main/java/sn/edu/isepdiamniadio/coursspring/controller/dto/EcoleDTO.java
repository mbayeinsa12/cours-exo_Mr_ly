package sn.edu.isepdiamniadio.coursspring.controller.dto;

import sn.edu.isepdiamniadio.coursspring.domain.Ecole;

public class EcoleDTO {

    Ecole ecole;
    String message;

    public Ecole getEcole() {
        return ecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
