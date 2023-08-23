package com.jdc.cloud.dao.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.cloud.dao.entity.Member;

public interface MemberRepo extends JpaRepositoryImplementation<Member, Integer>{

	Optional<Member> findOneByLoginId(String username);

}
