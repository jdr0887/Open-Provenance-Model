package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.ValueDAO;
import org.renci.opm.dao.model.Value;
import org.renci.opm.ws.ValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValueServiceImpl implements ValueService {

    private final Logger logger = LoggerFactory.getLogger(ValueServiceImpl.class);

    private ValueDAO valueDAO;

    @Override
    public Value findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Value ret = null;
        try {
            ret = valueDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Value value) {
        logger.info("ENTERING save(Value)");
        Long ret = null;
        try {
            ret = valueDAO.save(value);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public ValueDAO getValueDAO() {
        return valueDAO;
    }

    public void setValueDAO(ValueDAO valueDAO) {
        this.valueDAO = valueDAO;
    }

}
