/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import static java.util.Objects.toString;

/**
 *
 * @author ADMIN
 */
public class SMTPServer {
    
    private String server;
    private String port;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return server + " " + port;
    }
    
}
