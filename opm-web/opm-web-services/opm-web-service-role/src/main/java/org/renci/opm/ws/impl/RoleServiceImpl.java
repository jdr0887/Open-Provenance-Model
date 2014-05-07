package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.PersonDAO;
import org.renci.opm.dao.model.Person;
import org.renci.opm.ws.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonServiceImpl implements PersonService {

    private final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    private PersonDAO personDAO;

    @Override
    public Person findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Person ret = null;
        try {
            ret = personDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Person person) {
        logger.info("ENTERING save(Person)");
        Long ret = null;
        try {
            ret = personDAO.save(person);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

}
