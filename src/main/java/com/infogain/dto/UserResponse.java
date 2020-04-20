package com.infogain.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserResponse implements Serializable
{
    @JsonIgnore
    int responseId;
 User user;
    Map<String, String> links;

    Random r= new Random(); 

    public UserResponse(User user)
    {
        this.user = user;
        responseId=r.nextInt();
    }

    public Map<String, String> getLinks()
    {
        return links;
    }

    public int getResponseId()
    {
        return responseId;
    }

    public void setResponseId(int responseId)
    {
        this.responseId = responseId;
    }

    public void setLinks(Map<String, String> links)
    {
        this.links = links;
    }

    public void generateLinks(Map<String, String> endpoints)
    {
        if (links == null)
        {
            links = new HashMap<>();
        }
        Set<String> keySet = endpoints.keySet();
        for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();)
        {
            String name = iterator.next();
            String url = endpoints.get(name).replace("{userId}", String.valueOf(user.userId));
            links.put(name, url);
        }
    }

    public UserResponse()
    {
        // TODO Auto-generated constructor stub
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(links, user);
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
        UserResponse other = (UserResponse) obj;
        return Objects.equals(links, other.links) && Objects.equals(user, other.user);
    }

    @Override
    public String toString()
    {
        return "UserResponse [" + (user != null ? "user=" + user + ", " : "")
                + (links != null ? "links=" + links : "") + "]";
    }

  

}
