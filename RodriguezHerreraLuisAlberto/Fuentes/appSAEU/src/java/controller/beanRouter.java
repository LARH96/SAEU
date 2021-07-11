/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author LARH96
 */
@Named(value = "beanRouter")
@SessionScoped
public class beanRouter implements Serializable {

    private String page;
    
    /**
     * Creates a new instance of beanRouter
     */
    public beanRouter() {
        this.page = "index";
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
    
    
    
}
