package org.renci.opm.dao.jpa;

import org.renci.opm.dao.PersonDAO;
import org.renci.opm.dao.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonDAOImpl extends BaseDAOImpl<Person, Long> implements PersonDAO {

    private final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

    public PersonDAOImpl() {
        super();
    }

    @Override
    public Class<Person> getPersistentClass() {
        return Person.class;
    }

}
