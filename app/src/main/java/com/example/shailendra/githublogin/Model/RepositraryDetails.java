
package com.example.shailendra.githublogin.Model;



public class RepositraryDetails {
    private String full_name;
    private String url;
    private String desc;

    public RepositraryDetails(String full_name, String url, String desc) {
        this.full_name = full_name;
        this.url = url;
        this.desc = desc;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
