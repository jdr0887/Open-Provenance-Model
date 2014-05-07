package org.renci.opm.dao.jpa;

import org.renci.opm.dao.DerivationDAO;
import org.renci.opm.dao.model.Derivation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DerivationDAOImpl extends BaseDAOImpl<Derivation, Long> implements DerivationDAO {

    private final Logger logger = LoggerFactory.getLogger(DerivationDAOImpl.class);

    public DerivationDAOImpl() {
        super();
    }

    @Override
    public Class<Derivation> getPersistentClass() {
        return Derivation.class;
    }

}
