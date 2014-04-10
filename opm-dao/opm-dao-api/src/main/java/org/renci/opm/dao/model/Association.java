package org.renci.opm.dao.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

/**
 * <p>
 * Java class for Association complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Association">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activity" type="{http://www.w3.org/ns/prov#}IDRef"/>
 *         &lt;element name="agent" type="{http://www.w3.org/ns/prov#}IDRef" minOccurs="0"/>
 *         &lt;element name="plan" type="{http://www.w3.org/ns/prov#}IDRef" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/ns/prov#}label" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/ns/prov#}role" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/ns/prov#}type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://www.w3.org/ns/prov#}id"/>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Association", propOrder = { "activity", "agent", "plan", "label", "role", "type", "other" })
@javax.persistence.Entity
@Table(name = "association")
public class Association extends Element {

    private static final long serialVersionUID = 371997270157919088L;

    @XmlJavaTypeAdapter(IDRefAdapter.class)
    @XmlElement(required = true, type = IDRef.class)
    @ManyToOne
    @JoinColumn(name = "activity")
    protected QualifiedName activity;

    @XmlJavaTypeAdapter(IDRefAdapter.class)
    @XmlElement(type = IDRef.class)
    @ManyToOne
    @JoinColumn(name = "agent")
    protected QualifiedName agent;

    @XmlJavaTypeAdapter(IDRefAdapter.class)
    @XmlElement(type = IDRef.class)
    @ManyToOne
    @JoinColumn(name = "plan")
    protected QualifiedName plan;

    @ManyToMany(targetEntity = InternationalizedString.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "association_internationalized_string", joinColumns = @JoinColumn(name = "association_fk"), inverseJoinColumns = @JoinColumn(name = "internationalized_string_fk"))
    protected Set<InternationalizedString> label;

    @ManyToMany(targetEntity = Role.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "association_role", joinColumns = @JoinColumn(name = "association_fk"), inverseJoinColumns = @JoinColumn(name = "role_fk"))
    protected Set<Role> role;

    @ManyToMany(targetEntity = Type.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "association_type", joinColumns = @JoinColumn(name = "association_fk"), inverseJoinColumns = @JoinColumn(name = "type_fk"))
    protected Set<Type> type;

    @ManyToMany(targetEntity = Other.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "association_other", joinColumns = @JoinColumn(name = "association_fk"), inverseJoinColumns = @JoinColumn(name = "other_fk"))
    protected Set<Other> other;

    @XmlAttribute(name = "id", namespace = "http://www.w3.org/ns/prov#")
    @XmlJavaTypeAdapter(QNameAdapter.class)
    @ManyToOne
    @JoinColumn(name = "id")
    protected QualifiedName id;

    @XmlAnyAttribute
    @Transient
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public Association() {
        super();
        label = new HashSet<InternationalizedString>();
        type = new HashSet<Type>();
        other = new HashSet<Other>();
        otherAttributes = new HashMap<QName, String>();
    }

    public QualifiedName getActivity() {
        return activity;
    }

    public void setActivity(QualifiedName activity) {
        this.activity = activity;
    }

    public QualifiedName getAgent() {
        return agent;
    }

    public void setAgent(QualifiedName agent) {
        this.agent = agent;
    }

    public QualifiedName getPlan() {
        return plan;
    }

    public void setPlan(QualifiedName plan) {
        this.plan = plan;
    }

    public Set<InternationalizedString> getLabel() {
        return label;
    }

    public void setLabel(Set<InternationalizedString> label) {
        this.label = label;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public Set<Type> getType() {
        return type;
    }

    public void setType(Set<Type> type) {
        this.type = type;
    }

    public Set<Other> getOther() {
        return other;
    }

    public void setOther(Set<Other> other) {
        this.other = other;
    }

    public QualifiedName getId() {
        return id;
    }

    public void setId(QualifiedName id) {
        this.id = id;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public void setOtherAttributes(Map<QName, String> otherAttributes) {
        this.otherAttributes = otherAttributes;
    }

    @Override
    public String toString() {
        return String.format("Association [primaryKey=%s, id=%s, activity=%s, agent=%s, plan=%s]", primaryKey, id,
                activity, agent, plan);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((activity == null) ? 0 : activity.hashCode());
        result = prime * result + ((agent == null) ? 0 : agent.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((plan == null) ? 0 : plan.hashCode());
        result = prime * result + ((primaryKey == null) ? 0 : primaryKey.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Association other = (Association) obj;
        if (activity == null) {
            if (other.activity != null)
                return false;
        } else if (!activity.equals(other.activity))
            return false;
        if (agent == null) {
            if (other.agent != null)
                return false;
        } else if (!agent.equals(other.agent))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (plan == null) {
            if (other.plan != null)
                return false;
        } else if (!plan.equals(other.plan))
            return false;
        if (primaryKey == null) {
            if (other.primaryKey != null)
                return false;
        } else if (!primaryKey.equals(other.primaryKey))
            return false;
        return true;
    }

}
