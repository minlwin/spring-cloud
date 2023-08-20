package com.jdc.cloud.dao.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.cloud.dao.entity.TransactionItem;

public interface TransactionItemRepo extends JpaRepositoryImplementation<TransactionItem, Long>{

}
