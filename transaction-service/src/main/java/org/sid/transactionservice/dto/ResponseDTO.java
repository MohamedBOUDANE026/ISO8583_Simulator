package org.sid.transactionservice.dto;

public class ResponseDTO {
    private String messageISO;
    private String responseCode;
    private String description;

    public ResponseDTO() {}

    public ResponseDTO(String messageISO, String responseCode, String description) {
        this.messageISO = messageISO;
        this.responseCode = responseCode;
        this.description = description;
    }

    public String getMessageISO() {
        return messageISO;
    }

    public void setMessageISO(String messageISO) {
        this.messageISO = messageISO;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
