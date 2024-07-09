package FavouriteImages.controllers;


import FavouriteImages.models.Images;
import FavouriteImages.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ImagesControllers {
    @Autowired
    ImagesService imagesService;

    @PostMapping(path = "/images")
    public Images createImages(@RequestBody Images newImages){
        return imagesService.createImages(newImages);
    }
}
