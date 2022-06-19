package com.coursework.hitler.repository;

import com.coursework.hitler.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository <AccountEntity, Long>{

    AccountEntity findByUsername (String username);
}
