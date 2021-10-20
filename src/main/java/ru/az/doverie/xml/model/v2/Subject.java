package ru.az.doverie.xml.model.v2;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"idTerrorist", "uns", "description", "terrorist", "subjectType","history"})
@Data
public class Subject {

    @XmlElement(name = "ИдСубъекта")
    private String idTerrorist;

    @XmlElement(name = "УНС")
    private String uns;

    @XmlElement(name = "ТипСубъекта")
    private Type subjectType;

    @XmlElement(name = "История")
    private History history;

    @XmlElement(name = "ФЛ")
    private Individual individual;

    @XmlElement(name = "ЮЛ")
    private LegalEntity legalEntity;

    @XmlElementWrapper(name = "СписокАдресов")
    @XmlElement(name = "Адрес")
    private List<Address> addresses;

    @XmlElement(name = "Примечание")
    private String description;

    @XmlElement(name = "Террорист")
    private String terrorist;

}
