package org.renci.opm.dao.model;

public class TypeAdapter extends AbstractTypedValueAdapter<Type> {

    public TypeAdapter() {
        super();
    }

    @Override
    public Type unmarshal(Object o) throws Exception {
        if (o instanceof org.w3c.dom.Element) {
            org.w3c.dom.Element el = (org.w3c.dom.Element) o;

            String prefix = el.getPrefix();
            String namespaceURI = el.getNamespaceURI();
            String localPart = el.getLocalName();
            String child = el.getTextContent();
            String typeAsString = el.getAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type");

            String lang = el.getAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "lang");
            // QualifiedName type = ((typeAsString == null) || (typeAsString.equals(""))) ? null :
            // stringToQualifiedName(
            // typeAsString, el);
            // Name name = pFactory.getName();
            // if (type == null)
            // type = name.XSD_STRING;
            // if (type.equals(name.XSD_QNAME)) {
            // QualifiedName qn = stringToQualifiedName(child, el);
            // Attribute x = pFactory.newAttribute(namespace, local, prefix, qn, type);
            // return x;
            // } else if (type.equals(name.RDF_LITERAL)) {
            // NodeList nodes = el.getChildNodes();
            // org.w3c.dom.Element content = null;
            // for (int i = 0; i < nodes.getLength(); i++) {
            // Node node = nodes.item(i);
            // if (node instanceof org.w3c.dom.Element) {
            // content = (org.w3c.dom.Element) node;
            // break;
            // }
            // }
            // return pFactory.newAttribute(namespace, local, prefix, content, type);
            // } else if ((lang == null) || (lang.equals(""))) {
            // return pFactory.newAttribute(namespace, local, prefix, vconv.convertToJava(type, child), type);
            // } else {
            // return pFactory.newAttribute(namespace, local, prefix,
            // pFactory.newInternationalizedString(child, lang), type);
            // }
            Type ret = new Type();
            ret.setType(new QualifiedName(namespaceURI, localPart, prefix));
            ret.setValue(child);
            return ret;
        }
        return null;
    }

}
