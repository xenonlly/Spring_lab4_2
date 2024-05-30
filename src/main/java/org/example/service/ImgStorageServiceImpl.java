package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.controller.ImgDto;
import org.example.model.ImgEntity;
import org.example.model.ImgNotFoundException;
import org.example.repository.ImgStorageRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImgStorageServiceImpl implements ImgStorageService {

    private final ImgStorageRepository<Long, ImgEntity> repository;
    private final Mapper<ImgEntity, ImgDto> mapper;

    @Override
    public ImgDto save(ImgDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public ImgDto getById(Long id) {
        ImgEntity entity = repository.findById(id).orElseThrow(ImgNotFoundException::new);
        return mapper.toDto(entity);
    }
}
