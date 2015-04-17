package org.renci.opm.ws.impl;

import org.renci.opm.dao.DelegationDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Delegation;
import org.renci.opm.ws.DelegationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelegationServiceImpl implements DelegationService {

    private final Logger logger = LoggerFactory.getLogger(DelegationServiceImpl.class);

    private DelegationDAO delegationDAO;

    @Override
    public Delegation findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Delegation ret = null;
        try {
            ret = delegationDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Delegation document) {
        logger.info("ENTERING save(Delegation)");
        Long ret = null;
        try {
            ret = delegationDAO.save(document);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public DelegationDAO getDelegationDAO() {
        return delegationDAO;
    }

    public void setDelegationDAO(DelegationDAO delegationDAO) {
        this.delegationDAO = delegationDAO;
    }

}
