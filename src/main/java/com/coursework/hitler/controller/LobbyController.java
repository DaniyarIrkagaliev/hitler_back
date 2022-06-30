package com.coursework.hitler.controller;

import com.coursework.hitler.entity.LobbyEntity;
import com.coursework.hitler.exception.UserAlreadyExistException;
import com.coursework.hitler.exception.UserNotFoundException;
import com.coursework.hitler.service.AccountService;
import com.coursework.hitler.service.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lobbies")
public class LobbyController {


    @Autowired
    private LobbyService lobbyService;

    @PostMapping
    public ResponseEntity createLobby(@RequestBody LobbyEntity lobby){
        try{
            lobbyService.createLobby(lobby);
            return ResponseEntity.ok("Пользователь сохранен");
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try{
            return ResponseEntity.ok(lobbyService.getOne(id));
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try{
            return ResponseEntity.ok(lobbyService.delete(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
