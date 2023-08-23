package com.jdc.cloud.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.cloud.dao.entity.OwnerAwareEntity;
import com.jdc.cloud.dao.repo.MemberRepo;

public class OwnerAwareEntityManager {

	@Autowired
	private MemberRepo memberRepo;
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasRole('CLIENT_MEMBER')")
	public void setOwnerWithLoginUser(OwnerAwareEntity entity) {
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		memberRepo.findOneByLoginId(username).ifPresent(member -> entity.setOwner(member));
	}
	
	public boolean checkOwnerWithLoginUser(OwnerAwareEntity entity) {
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		return entity.getOwner().getLoginId().equals(username);
	}
	
	public <T> Specification<T> specification() {
		return (root, query, cb) -> cb.equal(root.get("owner").get("loginId"), SecurityContextHolder.getContext().getAuthentication().getName());
	}
}
