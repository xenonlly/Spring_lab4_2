package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.ImgStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/img")
@RequiredArgsConstructor
public class ImgStorageController {
    private final ImgStorageService service;
    @PostMapping()
    public ImgDto save(@RequestBody ImgDto dto) {
        System.out.println("before save");
        ImgDto saved = service.save(dto);
        System.out.println("after save");
        System.out.println(saved);
        return saved;
    }

    @GetMapping("/{id}")
    public ImgDto getImgById(@PathVariable("id") int id) {
        System.out.println("before get");

        ImgDto imgDto = service.getById((long) id);
        System.out.println(imgDto);
        System.out.println("after get");

        return imgDto;
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return null;
    }
}
