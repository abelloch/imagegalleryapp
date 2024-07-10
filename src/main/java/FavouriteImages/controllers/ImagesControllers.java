package FavouriteImages.controllers;


import FavouriteImages.models.Images;
import FavouriteImages.repositories.IImagesRepository;
import FavouriteImages.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin ( origins = "*")

public class   ImagesControllers {
    @Autowired
    ImagesService imagesService;

    @Autowired
    private IImagesRepository imagesRepository;


    // Endpoint para actualizar una nueva imagen por id
    @PutMapping(path = "/images/{id}")
    public void updateImage (@RequestBody Images images, @PathVariable int id) {
        imagesService.updateImage(images, id);
    }

}











