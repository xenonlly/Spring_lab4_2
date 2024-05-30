package org.example.model;

import lombok.Getter;

@Getter
public class ImgEntity {
    private Long id;
    private String data;

    public ImgEntity() {
    }

    public ImgEntity(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setData(String data) {
        this.data = data;
    }
}
