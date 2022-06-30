package com.coursework.hitler.repository;

import com.coursework.hitler.entity.AccountEntity;
import com.coursework.hitler.entity.LobbyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LobbyRepo  extends CrudRepository<LobbyEntity, Long> {
    Optional<LobbyEntity> findByLobbyName(String username);
    Optional<LobbyEntity> findByLobbyId(String username);
}
