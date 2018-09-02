package com.gmail.madkiev.security;

import io.swagger.annotations.ApiModelProperty;

public class Credentials {

    @ApiModelProperty(required = true, notes = "Username to authenticate")
    private String username;
    @ApiModelProperty(required = true, notes = "Password to authenticate")
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
