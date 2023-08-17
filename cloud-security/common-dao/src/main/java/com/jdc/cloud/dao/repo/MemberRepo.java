package com.jdc.cloud.dao.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.cloud.dao.entity.Member;

public interface MemberRepo extends JpaRepositoryImplementation<Member, Integer>{

}
