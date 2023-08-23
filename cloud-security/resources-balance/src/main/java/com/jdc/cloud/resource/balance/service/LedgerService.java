package com.jdc.cloud.resource.balance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.cloud.dao.constants.LedgerType;
import com.jdc.cloud.dao.entity.Ledger;
import com.jdc.cloud.dao.repo.LedgerRepo;
import com.jdc.cloud.dao.service.OwnerAwareEntityManager;
import com.jdc.cloud.resource.balance.model.dto.LedgerDto;
import com.jdc.cloud.resource.balance.model.form.LedgerForm;

@Service
@Transactional(readOnly = true)
public class LedgerService {
	
	@Autowired
	private LedgerRepo ledgerRepo;
	@Autowired
	private OwnerAwareEntityManager ownerAwareEntityManager;

	public LedgerDto findById(int id) {
		return ledgerRepo.findById(id)
				.filter(ownerAwareEntityManager::checkOwnerWithLoginUser)
				.map(LedgerDto::from)
				.orElseThrow();
	}

	@Transactional
	public LedgerDto create(LedgerForm form) {
		var entity = form.entity();
		ownerAwareEntityManager.setOwnerWithLoginUser(entity);
		entity = ledgerRepo.save(entity);
		return LedgerDto.from(entity);
	}
	
	@Transactional
	public LedgerDto update(int id, LedgerForm form) {
		var entity = ledgerRepo.findById(id)
				.filter(ownerAwareEntityManager::checkOwnerWithLoginUser).orElseThrow();
		entity.setName(form.name());
		entity.setType(form.type());
		return LedgerDto.from(entity);
	}

	public List<LedgerDto> search(Optional<LedgerType> type, Optional<String> name) {
	
		return ledgerRepo.findAll(
					whichType(type).and(whichName(name)).and(ownerAwareEntityManager.specification()))
				.stream().map(LedgerDto::from).toList();
	}
	
	private Specification<Ledger> whichType(Optional<LedgerType> param) {
		if(param.isEmpty()) {
			return Specification.where(null);
		}
		
		return (root, query, cb) -> cb.equal(root.get("type"), param.get());
	}
	
	private Specification<Ledger> whichName(Optional<String> param) {
		if(param.isEmpty()) {
			return Specification.where(null);
		}
		
		return (root, query, cb) -> cb.like(cb.lower(root.get("name")), param.get().toLowerCase().concat("%"));
	}
	
}
