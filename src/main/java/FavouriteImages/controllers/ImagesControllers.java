package FavouriteImages.controllers;


import FavouriteImages.models.Images;
import FavouriteImages.repositories.IImagesRepository;
import FavouriteImages.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin ( origins = "*")

public class ImagesControllers {
    @Autowired
    ImagesService imagesService;

    @Autowired
    private IImagesRepository imagesRepository;


    // Endpoint para actualizar una nueva imagen por id
    @PutMapping(path = "/images/{id}")
    public ResponseEntity<String> updateImage(@PathVariable int id, @RequestBody Images newImageDetails) {
        return imagesService.updateImage(newImageDetails, id);
    }

}











