package org.renci.opm.ws.impl;

import org.renci.opm.dao.CommunicationDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Communication;
import org.renci.opm.ws.CommunicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommunicationServiceImpl implements CommunicationService {

    private final Logger logger = LoggerFactory.getLogger(CommunicationServiceImpl.class);

    private CommunicationDAO communicationDAO;

    @Override
    public Communication findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Communication ret = null;
        try {
            ret = communicationDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Communication communication) {
        logger.info("ENTERING save(Communication)");
        Long ret = null;
        try {
            ret = communicationDAO.save(communication);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public CommunicationDAO getCommunicationDAO() {
        return communicationDAO;
    }

    public void setCommunicationDAO(CommunicationDAO communicationDAO) {
        this.communicationDAO = communicationDAO;
    }

}
