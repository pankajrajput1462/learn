package com.n26.tx.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.n26.tx.model.Amount;

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
    public List<Amount> findAll();
    
    //@Query("select c from Amount c")
    @Query("SELECT c FROM Amount c where c.transactionTime > DATEADD('second', -60, current_timestamp)")
	List<Amount> findAllAmount();


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
