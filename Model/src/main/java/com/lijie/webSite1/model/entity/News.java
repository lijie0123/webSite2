package com.lijie.webSite1.model.entity;

/**
 * Created by lijie on 2016/5/17.
 */
public class News {
    private String id;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
