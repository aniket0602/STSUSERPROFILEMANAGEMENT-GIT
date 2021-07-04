package com.userprofile.userservices;

import java.util.List;

import com.userprofile.userentities.User;



public interface UserService {
    public List<User> getprofiles();
    public User getprofile(long profileId);
    public User addprofile(User user);
    public User updateprofile(User user);
    public void deleteprofile(long profileId);
}
