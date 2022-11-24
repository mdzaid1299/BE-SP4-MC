package com.example.Music.Service;

import com.example.Music.domain.Track;
import com.example.Music.domain.User;
import com.example.Music.exception.TrackNotfoundException;
import com.example.Music.exception.UserAlreadyExistsException;
import com.example.Music.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User addUser(User user) throws UserAlreadyExistsException;
    public User addTrackForUser(String userId, Track track) throws UserNotFoundException;
    public User deleteTrackFromUser(String userId,int trackId) throws UserNotFoundException, TrackNotfoundException;
    List<Track> getTrackForUser(String userId) throws UserNotFoundException;
    User updateTrackForUser(String userId,Track track) throws UserNotFoundException;
}
