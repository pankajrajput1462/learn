package com.n26.tx.dao;

import com.n26.tx.model.Amount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author SINPANK
 */
@Repository
public class TransactionRepository implements CrudRepository<Amount, Long> {
    @Override
    public <S extends Amount> S save(S s) {
        return null;
    }

    @Override
    public <S extends Amount> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Amount> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Amount> findAll() {
        return null;
    }

    @Override
    public Iterable<Amount> findAllById(Iterable<Long> iterable) {
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
    public void delete(Amount amount) {

    }

    @Override
    public void deleteAll(Iterable<? extends Amount> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
