package org.example.model;

public class ImgNotFoundException extends RuntimeException {
    public ImgNotFoundException() {
        super("Image not found!");
    }
}
