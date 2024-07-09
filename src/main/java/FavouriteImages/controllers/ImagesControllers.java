package FavouriteImages.controllers;


import FavouriteImages.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ImagesControllers<id> {

    @Autowired
    ImagesService imagesService;

    @DeleteMapping(path = "/{id}")
    public String deleteImagesById(@PathVariable int id){

        boolean ok = imagesService.deleteImageById(id);
        if (ok) {
            return "image with id" + id + "as deleted";
        } else {
            return  "Error, we have a problem to deleted image" + id;
        }

    }
}