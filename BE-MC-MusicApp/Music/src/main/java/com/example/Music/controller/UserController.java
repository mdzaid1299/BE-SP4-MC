package com.example.Music.controller;

import com.example.Music.Service.UserService;
import com.example.Music.domain.Track;
import com.example.Music.domain.User;
import com.example.Music.exception.TrackNotfoundException;
import com.example.Music.exception.UserAlreadyExistsException;
import com.example.Music.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/trackdata/api/")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyExistsException {
        ResponseEntity responseEntity = null;
        try{
            user.setTrackList(new ArrayList<>());
            responseEntity = new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        }catch (UserAlreadyExistsException e){
            throw new UserAlreadyExistsException();
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @PutMapping("/track/addTrack/{userId}")
    public ResponseEntity<?> addProductForUser(@PathVariable String userId, @RequestBody Track track) throws UserNotFoundException {
        ResponseEntity responseEntity = null;
        try{
            responseEntity = new ResponseEntity<>(userService.addTrackForUser(userId,track), HttpStatus.CREATED);
        }catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @DeleteMapping("/track/deleteTrack/{userId}/{trackId}")
    public ResponseEntity<?> deleteProductForUser(@PathVariable(value = "trackId")int trackId,@PathVariable(value = "userId") String userId) throws TrackNotfoundException, UserNotFoundException {
        ResponseEntity responseEntity = null;
        try{
            responseEntity = new ResponseEntity<>(userService.deleteTrackFromUser(userId, trackId), HttpStatus.OK);
        }catch (TrackNotfoundException e){
            throw new TrackNotfoundException();
        }catch (UserNotFoundException e){
            throw new UserNotFoundException();
        } catch(Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @GetMapping("/track/tracks/{userId}")
    public ResponseEntity<?> getProductsForUser(@PathVariable String userId) throws UserNotFoundException {
        ResponseEntity responseEntity = null;
        try{
            responseEntity = new ResponseEntity<>(userService.getTrackForUser(userId), HttpStatus.OK);
        }catch(UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @PutMapping("/track/updateTrack/{userId}")
    public ResponseEntity<?> updateTrackForUser(@PathVariable String userId,@RequestBody Track track) throws UserNotFoundException {
        ResponseEntity responseEntity = null;
        try{
            responseEntity = new ResponseEntity<>(userService.updateTrackForUser(userId,track), HttpStatus.CREATED);
        }catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
