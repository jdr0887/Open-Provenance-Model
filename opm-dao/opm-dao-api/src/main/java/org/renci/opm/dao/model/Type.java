package org.renci.opm.dao.model;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Type", namespace = "http://www.w3.org/ns/prov#")
@javax.persistence.Entity
@Table(name = "type")
@XmlJavaTypeAdapter(type = Type.class, value = TypeAdapter.class)
public class Type extends TypedValue {

    private static final long serialVersionUID = -8297188646027977027L;

    public Type() {
        super();
    }

}
