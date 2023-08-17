package com.jdc.cloud.dao.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.cloud.dao.entity.Transaction;

public interface TransactionRepo extends JpaRepositoryImplementation<Transaction, Long>{

}
