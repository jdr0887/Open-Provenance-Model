package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.QualifiedNameDAO;
import org.renci.opm.dao.model.QualifiedName;
import org.renci.opm.ws.QualifiedNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QualifiedNameServiceImpl implements QualifiedNameService {

    private final Logger logger = LoggerFactory.getLogger(QualifiedNameServiceImpl.class);

    private QualifiedNameDAO qualifiedNameDAO;

    @Override
    public QualifiedName findById(Long id) {
        logger.info("ENTERING findById(Long)");
        QualifiedName ret = null;
        try {
            ret = qualifiedNameDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(QualifiedName qualifiedName) {
        logger.info("ENTERING save(QualifiedName)");
        Long ret = null;
        try {
            ret = qualifiedNameDAO.save(qualifiedName);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public QualifiedNameDAO getQualifiedNameDAO() {
        return qualifiedNameDAO;
    }

    public void setQualifiedNameDAO(QualifiedNameDAO qualifiedNameDAO) {
        this.qualifiedNameDAO = qualifiedNameDAO;
    }

}
