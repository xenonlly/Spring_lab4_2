package org.example.repository;

import org.example.model.ImgEntity;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryImgRepository implements ImgStorageRepository<Long, ImgEntity> {

    private Map<Long, ImgEntity> storage = new HashMap<>();
    private AtomicLong idSequence = new AtomicLong(0L);
    @Override
    public Optional<ImgEntity> findById(long id) {
        return Optional.of(storage.get(id));
    }


    @Override
    public ImgEntity save(ImgEntity entity) {
        long tmp = idSequence.get();
        entity.setId(tmp);
        storage.put(idSequence.getAndIncrement(), entity);
        return storage.get(tmp);
    }
}
