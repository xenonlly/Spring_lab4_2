package org.example.service;

import org.example.model.ImgEntity;

public interface Mapper<E, D> {
    E toEntity(D dto);
    D toDto(E entity);
}
