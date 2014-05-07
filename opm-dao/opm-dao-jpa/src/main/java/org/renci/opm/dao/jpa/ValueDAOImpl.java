package org.renci.opm.dao.jpa;

import org.renci.opm.dao.ValueDAO;
import org.renci.opm.dao.model.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValueDAOImpl extends BaseDAOImpl<Value, Long> implements ValueDAO {

    private final Logger logger = LoggerFactory.getLogger(ValueDAOImpl.class);

    public ValueDAOImpl() {
        super();
    }

    @Override
    public Class<Value> getPersistentClass() {
        return Value.class;
    }

}
