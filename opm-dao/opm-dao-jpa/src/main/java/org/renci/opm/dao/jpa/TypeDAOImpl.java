package org.renci.opm.dao.jpa;

import org.renci.opm.dao.TypeDAO;
import org.renci.opm.dao.model.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TypeDAOImpl extends BaseDAOImpl<Type, Long> implements TypeDAO {

    private final Logger logger = LoggerFactory.getLogger(TypeDAOImpl.class);

    public TypeDAOImpl() {
        super();
    }

    @Override
    public Class<Type> getPersistentClass() {
        return Type.class;
    }

}
