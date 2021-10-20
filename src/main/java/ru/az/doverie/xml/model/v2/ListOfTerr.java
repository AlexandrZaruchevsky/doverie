package ru.az.doverie.xml.model.v2;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Перечень")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"formatOfVersion", "dateListOfTerr", "previosDateListOfTerr","listOfTerrorist"})
@Data
public class ListOfTerr {

    @XmlElement(name = "ВерсияФормата")
    private String formatOfVersion;

    @XmlElement(name = "ДатаПеречня")
    private String dateListOfTerr;

    @XmlElement(name = "ДатаПредыдущегоПеречня")
    private String previosDateListOfTerr;

    @XmlElementWrapper(name = "АктуальныйПеречень")
    @XmlElement(name = "Субъект")
    private List<Subject> listOfTerrorist;

}
