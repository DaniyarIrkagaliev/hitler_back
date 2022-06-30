package com.coursework.hitler.repository;

import com.coursework.hitler.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepo extends CrudRepository <AccountEntity, Long>{
    Optional<AccountEntity> findByUsername(String username);
//    AccountEntity findByUsername (String username);
}
