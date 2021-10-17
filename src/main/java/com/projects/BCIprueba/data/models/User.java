package com.projects.BCIprueba.data.models;


import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class User {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "created")
    private Date creationDate;
    @Column(name = "modified")
    private Date modificationDate;
    @Column(name = "lastlogin")
    private Date lastLogin;
    @Column(name = "token")
    private String ApiToken;
    @Column(name = "active")
    private boolean active;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Phone> phones = new ArrayList<>();

    public User() {
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void getId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getApiToken() {
        return ApiToken;
    }

    public void setApiToken(String apiToken) {
        ApiToken = apiToken;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        for (Phone ph:phones) {
            ph.setId(getId());
            ph.setPhoneid(getNewUUID());
            this.phones.add(ph);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", lastLogin=" + lastLogin +
                ", ApiToken='" + ApiToken + '\'' +
                ", active=" + active +
                ", phones=" + phones +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return active == user.active && Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(creationDate, user.creationDate) && Objects.equals(modificationDate, user.modificationDate) && Objects.equals(lastLogin, user.lastLogin) && Objects.equals(ApiToken, user.ApiToken) && phones == user.phones;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, creationDate, modificationDate, lastLogin, ApiToken, active, phones);
    }

    private String getNewUUID(){
        return UUID.randomUUID().toString();
    }
}
