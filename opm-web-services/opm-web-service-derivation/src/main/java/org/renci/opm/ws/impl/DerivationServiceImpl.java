package org.renci.opm.ws.impl;

import org.renci.opm.dao.DerivationDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Derivation;
import org.renci.opm.ws.DerivationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DerivationServiceImpl implements DerivationService {

    private final Logger logger = LoggerFactory.getLogger(DerivationServiceImpl.class);

    private DerivationDAO derivationDAO;

    @Override
    public Derivation findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Derivation ret = null;
        try {
            ret = derivationDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Derivation derivation) {
        logger.info("ENTERING save(Derivation)");
        Long ret = null;
        try {
            ret = derivationDAO.save(derivation);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public DerivationDAO getDerivationDAO() {
        return derivationDAO;
    }

    public void setDerivationDAO(DerivationDAO derivationDAO) {
        this.derivationDAO = derivationDAO;
    }

}
