package com.n26.tx.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.n26.tx.model.AmountDetails;

/**
 * @author SINPANK
 */
@Repository
public class TransactionRepository implements CrudRepository<AmountDetails, Long> {
    @Override
    public <S extends AmountDetails> S save(S s) {
        return null;
    }

    @Override
    public <S extends AmountDetails> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<AmountDetails> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<AmountDetails> findAll() {
        return null;
    }

    @Override
    public Iterable<AmountDetails> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(AmountDetails amountDetails) {

    }

    @Override
    public void deleteAll(Iterable<? extends AmountDetails> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
