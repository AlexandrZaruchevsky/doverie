package ru.az.doverie.xml.model.v2;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Individual {

    @XmlElement(name = "ФИО")
    private String fio;

    @XmlElement(name = "Фамилия")
    private String lastName;

    @XmlElement(name = "ФИОЛат")
    private String fioLat;

    @XmlElement(name = "ДатаРождения")
    private String birthday;

    @XmlElement(name = "ГодРождения")
    private String yearOfBirth;

    @XmlElement(name = "МестоРождения")
    private String placeOfBirth;

    @XmlElement(name = "ИНН")
    private String inn;

    @XmlElement(name = "СНИЛС")
    private String snils;

    @XmlElementWrapper(name = "СписокДрНаименований")
    @XmlElement(name = "ДрНаименование")
    private List<OtherName> otherNames;

    @XmlElementWrapper(name = "СписокДокументов")
    @XmlElement(name = "Документ")
    private List<Document> documents;


}
