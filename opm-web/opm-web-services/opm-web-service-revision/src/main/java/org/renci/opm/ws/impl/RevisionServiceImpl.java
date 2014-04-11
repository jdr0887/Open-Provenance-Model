package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.RevisionDAO;
import org.renci.opm.dao.model.Revision;
import org.renci.opm.ws.RevisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RevisionServiceImpl implements RevisionService {

    private final Logger logger = LoggerFactory.getLogger(RevisionServiceImpl.class);

    private RevisionDAO revisionDAO;

    @Override
    public Revision findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Revision ret = null;
        try {
            ret = revisionDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Revision revision) {
        logger.info("ENTERING save(Revision)");
        Long ret = null;
        try {
            ret = revisionDAO.save(revision);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public RevisionDAO getRevisionDAO() {
        return revisionDAO;
    }

    public void setRevisionDAO(RevisionDAO revisionDAO) {
        this.revisionDAO = revisionDAO;
    }

}
