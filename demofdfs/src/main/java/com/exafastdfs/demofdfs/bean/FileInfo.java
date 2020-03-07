package com.exafastdfs.demofdfs.bean;

import java.util.Date;

public class FileInfo {

    private Integer id;
    private String filename;
    private String filedesc;
    private Date addtime;
    private String picaddr;
    private String picdesc;
    private String picname;
    private String piclove;
    private String picson;

    public String getPicdesc() {
        return picdesc;
    }

    public void setPicdesc(String picdesc) {
        this.picdesc = picdesc;
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname;
    }

    public String getPiclove() {
        return piclove;
    }

    public void setPiclove(String piclove) {
        this.piclove = piclove;
    }

    public String getPicson() {
        return picson;
    }

    public void setPicson(String picson) {
        this.picson = picson;
    }

    public String getFiledesc() {
        return filedesc;
    }

    public void setFiledesc(String filedesc) {
        this.filedesc = filedesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getPicaddr() {
        return picaddr;
    }

    public void setPicaddr(String picaddr) {
        this.picaddr = picaddr;
    }
}
