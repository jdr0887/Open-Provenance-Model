package org.renci.opm.dao.jpa;

import org.renci.opm.dao.QuotationDAO;
import org.renci.opm.dao.model.Quotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuotationDAOImpl extends BaseDAOImpl<Quotation, Long> implements QuotationDAO {

    private final Logger logger = LoggerFactory.getLogger(QuotationDAOImpl.class);

    public QuotationDAOImpl() {
        super();
    }

    @Override
    public Class<Quotation> getPersistentClass() {
        return Quotation.class;
    }

}
