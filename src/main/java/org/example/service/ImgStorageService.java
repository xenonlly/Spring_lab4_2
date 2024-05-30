package org.example.service;

import org.example.controller.ImgDto;

public interface ImgStorageService {
    ImgDto save(ImgDto dto);
    ImgDto getById(Long id);
}
