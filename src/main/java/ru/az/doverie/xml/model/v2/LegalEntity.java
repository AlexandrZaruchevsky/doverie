package ru.az.doverie.xml.model.v2;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class LegalEntity {

    @XmlElement(name = "Наименование")
    private String name;

    @XmlElement(name = "НаименованиеЛат")
    private String nameLat;

    @XmlElement(name = "ИНН")
    private String inn;

    @XmlElement(name = "ОГРН")
    private String ogrn;

}
