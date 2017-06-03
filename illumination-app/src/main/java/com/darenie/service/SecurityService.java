package com.darenie.service;

public interface SecurityService {

    String findLoggedInUserLogin();

    void autologin(String username, String password);
}