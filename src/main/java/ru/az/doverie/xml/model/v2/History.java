package ru.az.doverie.xml.model.v2;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"dateOfInclusion","dateOfExclusion"})
public class History {

    @XmlElement(name ="ДатаВключения")
    private List<String> dateOfInclusion;

    @XmlElement(name ="ДатаИсключения")
    private List<String> dateOfExclusion;

}
