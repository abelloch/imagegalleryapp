package FavouriteImages.controllers;


import FavouriteImages.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @DeleteMapping(path = "/{id}")
    public String deleteImagesById(@PathVariable int id){
        boolean ok = imagesService.deleteImageById(id);
        if (ok) {
            return "image with id" + id + "as deleted";
        } else {
            return  "Error, we have a problem to deleted image" + id;
        }
    }

    @GetMapping(path = "")
    public ArrayList<Images> getAllImages() {
        return imagesService.getAllImages();
    }

    @GetMapping(path = "/images/{id}")
    public Images getImageId(@PathVariable int id) {
        return imagesService.getImageId(id);
    }
}