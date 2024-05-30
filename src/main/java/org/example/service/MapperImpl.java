package org.example.service;

import org.example.controller.ImgDto;
import org.example.model.ImgEntity;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements Mapper<ImgEntity, ImgDto>{
    @Override
    public ImgEntity toEntity(ImgDto dto) {
        return new ImgEntity(dto.getId(), dto.getImgBase64data());
    }


    @Override
    public ImgDto toDto(ImgEntity entity) {
        return new ImgDto(entity.getId(), entity.getData());
    }
}
