package com.coursework.hitler.service;

import com.coursework.hitler.Model.Account;
import com.coursework.hitler.Model.Lobby;
import com.coursework.hitler.entity.AccountEntity;
import com.coursework.hitler.entity.LobbyEntity;
import com.coursework.hitler.exception.UserAlreadyExistException;
import com.coursework.hitler.exception.UserNotFoundException;
import com.coursework.hitler.repository.AccountRepo;
import com.coursework.hitler.repository.LobbyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LobbyService {

    @Autowired
    private LobbyRepo lobbyRepo;

    public LobbyEntity createLobby(LobbyEntity lobby) throws UserAlreadyExistException{
        if (lobbyRepo.findByLobbyName(lobby.getLobbyName()) != null) {
            throw new UserAlreadyExistException("Лобби уже существует");
        }
        return lobbyRepo.save(lobby);
    }

    public Lobby getOne(Long id) throws UserNotFoundException {
        LobbyEntity lobby = lobbyRepo.findById(id).get();
        if (lobby == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return Lobby.toModel(lobby);
    }

    public Long delete(Long id) {
        lobbyRepo.deleteById(id);
        return id;
    }
}
