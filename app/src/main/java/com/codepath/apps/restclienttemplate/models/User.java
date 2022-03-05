package com.codepath.apps.restclienttemplate.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
@Entity
public class User {

    @ColumnInfo
    @PrimaryKey
    public  long id; //Ask about it

    @ColumnInfo
    public String name;

    @ColumnInfo
    public String screenName;
    @ColumnInfo
    public String profileImageUrl;

    //Empty constructor needed for the Parceler library
    public User() {}

    public static User fromJson(JSONObject jsonObject) throws JSONException {
        //new user object and return it
        User user = new User();
        user.id = jsonObject.getLong("id");
        user.name = jsonObject.getString("name");
        user.screenName = jsonObject.getString("screen_name");
        user.profileImageUrl= jsonObject.getString("profile_image_url_https");
        return user;

    }

    public static List<User> fromJsonTweetAttay(List<Tweet> tweetsFromNetwork) {
        List<User> users = new ArrayList<>();
        for(int i =0; i < tweetsFromNetwork.size(); i++){
            users.add(tweetsFromNetwork.get(i).user);
        }
        return users;
    }
}