package main.utils;

import lombok.Getter;

//TODO mover essa classe para o pacote domain
@Getter
public enum TemplatesEnum {
    TEMPLATE_UPDATE_PASSWORD("template_update_password.ftl"),
    TEMPLATE_APPROVED_ADOPTION("template_approved_adoption.ftl"),
    TEMPLATE_REJECTED_ADOPTION("template_rejected_adoption.ftl");

    private String fileName;

    TemplatesEnum(String fileName) {
        this.fileName = fileName;
    }
}
