package com.jdc.cloud.dao.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.cloud.dao.entity.TransactionDetails;

public interface TransactionDetailsRepo extends JpaRepositoryImplementation<TransactionDetails, Long>{

}
