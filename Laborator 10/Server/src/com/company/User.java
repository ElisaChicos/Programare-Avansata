package com.company;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String adress;
    private List<User> friends = new ArrayList<>();
    private String name;

    public User() {

    }

    public User(String adress, List<User> friends, String name) {
        this.adress = adress;
        this.friends = friends;
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<User> getFriends() {
        return friends;
    }

    public List<User> addFriend(User friend) {
        this.friends.add(friend);
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
