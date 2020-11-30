package com.qsystems.persists;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kornyukhina Sasha
 */

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Integer> {
}
