package ru.az.doverie.xml.model.v2;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Document {

    @XmlElement(name = "ТипДокумента")
    private Type documentType;

    @XmlElement(name = "Серия")
    private String serial;

    @XmlElement(name = "number")
    private String number;

    @XmlElement(name = "ОрганВыдачи")
    private String issuingAuthority;

    @XmlElement(name = "ДатаВыдачи")
    private String dateOfIssue;



}
