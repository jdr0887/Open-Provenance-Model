package org.renci.opm.dao.jpa;

import org.renci.opm.dao.QualifiedNameDAO;
import org.renci.opm.dao.model.QualifiedName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QualifiedNameDAOImpl extends BaseDAOImpl<QualifiedName, Long> implements QualifiedNameDAO {

    private final Logger logger = LoggerFactory.getLogger(QualifiedNameDAOImpl.class);

    public QualifiedNameDAOImpl() {
        super();
    }

    @Override
    public Class<QualifiedName> getPersistentClass() {
        return QualifiedName.class;
    }

}
