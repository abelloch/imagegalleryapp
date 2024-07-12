package FavouriteImages.controllers;

import FavouriteImages.models.Images;

import FavouriteImages.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

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

    @GetMapping(path = "")
    public ArrayList<Images> getAllImages() {
        return imagesService.getAllImages();
    }

    @GetMapping(path = "/images/{id}")
    public Images getImageId(@PathVariable int id) {
        return imagesService.getImageId(id);
        }

    @DeleteMapping(path = "images/{id}")
    public ResponseEntity<String> deleteImagesById(@PathVariable int id) {
        boolean ok = imagesService.deleteImagesById(id);
        if (ok) {
            return ResponseEntity.ok( "image with id" + id + "was deleted");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, we have a problem to delete image with id " + id);
        }
    }
    
    @PutMapping(path = "/images/{id}")
    public void updateImage (@RequestBody Images images, @PathVariable int id) {
        imagesService.updateImage(images, id);
    }
}