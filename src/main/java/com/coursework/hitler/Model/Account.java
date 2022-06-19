package com.coursework.hitler.Model;

import com.coursework.hitler.entity.AccountEntity;

public class Account {
    private Long id;
    private String username;
    private String email;
    private String description;
    private String img_id;


    public static Account toModel (AccountEntity entity){
        Account model = new Account();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setEmail(entity.getEmail());
        model.setDescription(entity.getDescription());
        model.setImg_id(entity.getImg_id());
        return model;
    }



    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_id() {
        return img_id;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id;
    }
}
