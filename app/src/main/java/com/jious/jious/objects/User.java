package com.jious.jious.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * User represents the user information upon registration.
 */
public class User implements Parcelable {

    private String username;
    private String email;
    private String password;
    private String postal;

    public User(Parcel input) {
        this(input.readString(), input.readString(), input.readString(),
                input.readString());
    }

    public User(String username, String email,
                String password, String postal) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.postal = postal;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static final Parcelable.Creator<User> CREATOR
            = new Creator<User>() {

        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(postal);
    }
}
