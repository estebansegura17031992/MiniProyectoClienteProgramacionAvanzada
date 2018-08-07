/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniproyectoclienteprogramacionavanzada.cliente;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
    ArrayList<User> users  = new ArrayList<User>();
    // A la etiqueta que identifique el inicio y fin de cada user en el XML
    @XmlElement(name = "user")
    private List<User> userList;
    
    public Users() {
        userList = new ArrayList();
    }
 
    public List<User> getUsersList() {
        return userList;
    }
 
    public void setUsersList(List<User> userList) {
        this.userList = userList;
    }
    
    public User getUser(int i){
        return users.get(i);
    }
}

