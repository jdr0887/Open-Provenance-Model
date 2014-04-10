package org.renci.opm.dao.jpa;

import org.renci.opm.dao.InternationalizedStringDAO;
import org.renci.opm.dao.model.InternationalizedString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InternationalizedStringDAOImpl extends BaseDAOImpl<InternationalizedString, Long> implements
        InternationalizedStringDAO {

    private final Logger logger = LoggerFactory.getLogger(InternationalizedStringDAOImpl.class);

    public InternationalizedStringDAOImpl() {
        super();
    }

    @Override
    public Class<InternationalizedString> getPersistentClass() {
        return InternationalizedString.class;
    }

}
