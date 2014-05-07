package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.TypeDAO;
import org.renci.opm.dao.model.Type;
import org.renci.opm.ws.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TypeServiceImpl implements TypeService {

    private final Logger logger = LoggerFactory.getLogger(TypeServiceImpl.class);

    private TypeDAO typeDAO;

    @Override
    public Type findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Type ret = null;
        try {
            ret = typeDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Type type) {
        logger.info("ENTERING save(Type)");
        Long ret = null;
        try {
            ret = typeDAO.save(type);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public TypeDAO getTypeDAO() {
        return typeDAO;
    }

    public void setTypeDAO(TypeDAO typeDAO) {
        this.typeDAO = typeDAO;
    }

}
