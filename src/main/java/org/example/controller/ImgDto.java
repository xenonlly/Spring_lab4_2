package org.example.controller;


import lombok.ToString;

@ToString
public class ImgDto {
    private Long id;
    private String imgBase64data;

    public ImgDto(Long id, String imgBase64data) {
        this.id = id;
        this.imgBase64data = imgBase64data;
    }

    public ImgDto(String imgBase64data) {
        this.imgBase64data = imgBase64data;
    }

    public ImgDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgBase64data() {
        return imgBase64data;
    }

    public void setImgBase64data(String imgBase64data) {
        this.imgBase64data = imgBase64data;
    }
}
