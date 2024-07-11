package FavouriteImages.controllers;

import FavouriteImages.models.Images;
import FavouriteImages.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ImagesControllers {
  @Autowired ImagesService imagesService;

  @PostMapping(path = "/images")
  public Images createImages(@RequestBody Images newImages) {
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
  public String deleteImagesById(@PathVariable int id) {
    boolean ok = imagesService.deleteImagesById(id);
    if (ok) {
      return "image with id" + id + "as deleted";
    } else {
      return "Error, we have a problem to deleted image" + id;
    }
  }

  @PutMapping(path = "/images/{id}")
  public void updateImage(@RequestBody Images images, @PathVariable int id) {
    imagesService.updateImage(images, id);
  }

  @PutMapping(path = "/images/{id}/favorite")
  public ResponseEntity<String> updateFavorite(@PathVariable int id, @RequestBody Map<String, Boolean> request) {
      try {
          Boolean favorite = request.get("favorite");
          if (favorite == null) {
              return ResponseEntity.badRequest().body("Missing 'favorite' field in request body");
          }
      Images favoriteImages = imagesService.updateFavorite(id, favorite);
      return ResponseEntity.ok(id + "is favorite");
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
