package ru.az.doverie.xml.model.v2;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Country {

    @XmlElement(name = "Наименование")
    private String name;

    @XmlElement(name = "Код")
    private String code;

}
