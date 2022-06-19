package com.coursework.hitler.service;

import com.coursework.hitler.Model.Account;
import com.coursework.hitler.entity.AccountEntity;
import com.coursework.hitler.exception.UserAlreadyExistException;
import com.coursework.hitler.exception.UserNotFoundException;
import com.coursework.hitler.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {


    @Autowired
    private AccountRepo accountRepo;

    public AccountEntity registration(AccountEntity account) throws UserAlreadyExistException {
        if (accountRepo.findByUsername(account.getUsername()) != null) {
            throw new UserAlreadyExistException("Пользователь с тамим Username уже существует");
        }
        return accountRepo.save(account);
    }

    public Account getOne(Long id) throws UserNotFoundException {
        AccountEntity account = accountRepo.findById(id).get();
        if (account == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return Account.toModel(account);
    }

    public Long delete(Long id) {
        accountRepo.deleteById(id);
        return id;
    }

}
