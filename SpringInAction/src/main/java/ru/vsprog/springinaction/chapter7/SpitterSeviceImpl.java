package ru.vsprog.springinaction.chapter7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import ru.vsprog.springinaction.chapter6.Spitter;
import ru.vsprog.springinaction.chapter6.SpitterDAO;
import ru.vsprog.springinaction.chapter8.SpitterService;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by vsa
 * Date: 19.11.14.
 */
public class SpitterSeviceImpl implements SpitterService {
    private SpitterDAO spitterDao;
    private EntityTransaction txStatus;
    private TransactionTemplate transactionTemplate;
    @Autowired
    SpitterService spitterService;

    @Override
    public List<Spittle> getRecentSpittles(int count) {
        return null;
    }

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

    @Override
    public void saveSpitter(Spitter spitter) {

    }

    @Override
    public Spitter getSpitter(long id) {
        return null;
    }

    @Override
    public void startFollowing(Spitter follower, Spitter followee) {

    }

    @Override
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        return null;
    }

    @Override
    public List<Spittle> getSpittlesForSpitter(String username) {
        Spitter spitter = spitterService.getSpitter(username);
        return spitterService.getSpittlesForSpitter(spitter);
    }

    @Override
    public Spitter getSpitter(String username) {
        return null;
    }

    @Override
    public Spittle getSpittleById(long id) {
        return null;
    }

    @Override
    public void deleteSpittle(long id) {

    }

    @Override
    public List<Spitter> getAllSpitters() {
        return null;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    @Async
    public Future<Long> performSomeReallyHairyMath(long input) {
        long result = 0L;
        return new AsyncResult<Long>(result);

    }
}
