package ru.az.doverie.xml.model.v2;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlElement(name = "НормАдрес")
    private Type addressNormalize;

    @XmlElement(name = "ТипАдреса")
    private Type addressType;

    @XmlElement(name = "ТекстАдреса")
    private String rawAddress;

    @XmlElement(name = "Страна")
    private Country country;

    @XmlElement(name = "Индекс")
    private String postIndex;

    @XmlElement(name = "ОКАТО")
    private String okato;

    @XmlElement(name = "Регион")
    private String region;

    @XmlElement(name = "Город")
    private String city;

    @XmlElement(name = "Улица")
    private String street;

    @XmlElement(name = "Дом")
    private String houseNumber;

    @XmlElement(name = "Помещение")
    private String quarters;

}
