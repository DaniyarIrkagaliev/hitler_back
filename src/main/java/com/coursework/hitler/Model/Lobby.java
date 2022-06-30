package com.coursework.hitler.Model;

import com.coursework.hitler.entity.AccountEntity;
import com.coursework.hitler.entity.LobbyEntity;

public class Lobby {
    private Long id;
    private String LobbyName;
    private Long playerCount;
    private String users_id;
    private Boolean status; // false - не завершена true - завершено

    public static Lobby toModel (LobbyEntity entity){
        Lobby model = new Lobby();
        model.setId(entity.getId());
        model.setLobbyName(entity.getLobbyName());
        model.setPlayerCount(entity.getPlayerCount());
        model.setUsers_id(entity.getUsers_id());
        model.setStatus(entity.getStatus());
        return model;
    }

    public Lobby() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLobbyName() {
        return LobbyName;
    }

    public void setLobbyName(String lobbyName) {
        LobbyName = lobbyName;
    }

    public Long getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(Long playerCount) {
        this.playerCount = playerCount;
    }

    public String getUsers_id() {
        return users_id;
    }

    public void setUsers_id(String users_id) {
        this.users_id = users_id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
