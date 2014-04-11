package org.renci.opm.dao.jpa;

import org.renci.opm.dao.RevisionDAO;
import org.renci.opm.dao.model.Revision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RevisionDAOImpl extends BaseDAOImpl<Revision, Long> implements RevisionDAO {

    private final Logger logger = LoggerFactory.getLogger(RevisionDAOImpl.class);

    public RevisionDAOImpl() {
        super();
    }

    @Override
    public Class<Revision> getPersistentClass() {
        return Revision.class;
    }

}
