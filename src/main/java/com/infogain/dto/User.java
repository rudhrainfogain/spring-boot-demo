package com.infogain.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements Serializable
{
    @JsonProperty("username")
    String userName;
    int age;
    int userId;

    public User()
    {
    }

    public User(String userName, int age, int userId)
    {
        this.userName = userName;
        this.age = age;
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    @JsonIgnore
    public int getAge()
    {
        return age;
    }
   @JsonProperty("age")
    public void setAge(int age)
    {
        this.age = age;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(age, userId, userName);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return age == other.age && userId == other.userId
                && Objects.equals(userName, other.userName);
    }

    @Override
    public String toString()
    {
        return "User [" + (userName != null ? "userName=" + userName + ", " : "") + "age=" + age
                + ", userId=" + userId + "]";
    }

}
