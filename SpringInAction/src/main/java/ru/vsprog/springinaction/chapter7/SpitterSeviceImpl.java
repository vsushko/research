package ru.vsprog.springinaction.chapter7;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import ru.vsprog.springinaction.chapter6.SpitterDAO;

import javax.persistence.EntityTransaction;

/**
 * Created by vsa
 * Date: 19.11.14.
 */
public class SpitterSeviceImpl {
    private SpitterDAO spitterDao;
    private EntityTransaction txStatus;
    private TransactionTemplate transactionTemplate;

    public void saveSpittle(final Spittle spittle) {
        transactionTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus transactionStatus) {
                try {
                    spitterDao.saveSpittle(spittle);
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }
}
