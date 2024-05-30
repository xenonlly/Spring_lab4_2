package org.example.repository;

import org.example.model.ImgEntity;

import java.util.Optional;

public interface ImgStorageRepository<K, V> {
    Optional<V> findById(long id);

    V save(V entity);
}
