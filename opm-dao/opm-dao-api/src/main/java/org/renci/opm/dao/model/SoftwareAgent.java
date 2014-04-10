package org.renci.opm.dao.model;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SoftwareAgent complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoftwareAgent">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.w3.org/ns/prov#}Agent">
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoftwareAgent")
@javax.persistence.Entity
@Table(name = "software_agent")
public class SoftwareAgent extends Agent {

    private static final long serialVersionUID = -6342403179395614184L;

    public SoftwareAgent() {
        super();
    }

}
