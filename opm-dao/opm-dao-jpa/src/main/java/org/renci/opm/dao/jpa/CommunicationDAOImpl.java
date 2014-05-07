package org.renci.opm.dao.jpa;

import org.renci.opm.dao.CommunicationDAO;
import org.renci.opm.dao.model.Communication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommunicationDAOImpl extends BaseDAOImpl<Communication, Long> implements CommunicationDAO {

    private final Logger logger = LoggerFactory.getLogger(CommunicationDAOImpl.class);

    public CommunicationDAOImpl() {
        super();
    }

    @Override
    public Class<Communication> getPersistentClass() {
        return Communication.class;
    }

}
