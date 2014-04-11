package org.renci.opm.ws.impl;

import org.renci.opm.dao.DocumentDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.QuotationDAO;
import org.renci.opm.dao.model.Quotation;
import org.renci.opm.ws.QuotationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuotationServiceImpl implements QuotationService {

    private final Logger logger = LoggerFactory.getLogger(QuotationServiceImpl.class);

    private QuotationDAO quotationDAO;

    @Override
    public Quotation findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Quotation ret = null;
        try {
            ret = quotationDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Quotation quotation) {
        logger.info("ENTERING save(Quotation)");
        Long ret = null;
        try {
            ret = quotationDAO.save(quotation);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public QuotationDAO getQuotationDAO() {
        return quotationDAO;
    }

    public void setQuotationDAO(QuotationDAO quotationDAO) {
        this.quotationDAO = quotationDAO;
    }

}
