package com.n26.tx.dao;

import com.n26.tx.model.Amount;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author SINPANK
 */
public interface TransactionRepository extends CrudRepository<Amount, Long> {
    @Override
    public <S extends Amount> S save(S s);
    

    @Override
    public <S extends Amount> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    public Optional<Amount> findById(Long aLong);

    @Override
    public boolean existsById(Long aLong);

    @Override
    public Iterable<Amount> findAll();
    
    @Query("select c from Amount c")
	Stream<Amount> findAllAmount();


    @Override
    public Iterable<Amount> findAllById(Iterable<Long> iterable);

    @Override
    public long count();

    @Override
    public void deleteById(Long aLong);

    @Override
    public void delete(Amount amount);

    @Override
    public void deleteAll(Iterable<? extends Amount> iterable);

    @Override
    public void deleteAll();
}
