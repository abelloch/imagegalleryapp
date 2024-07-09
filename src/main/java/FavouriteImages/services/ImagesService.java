package FavouriteImages.services;

import FavouriteImages.models.Images;
import FavouriteImages.repositories.IImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ImagesService {

    @Autowired
    IImagesRepository iImagesRepository;


    // Update by ID
    public ResponseEntity<String> updateImage(Images newImageDetails, int id) {
        try {
            Optional<Images> optionalImage = iImagesRepository.findById(id);
            if (optionalImage.isPresent()) {
                Images existingImage = optionalImage.get();
                existingImage.setTitle(newImageDetails.getTitle());
                existingImage.setUrl(newImageDetails.getUrl());
                existingImage.setDescription(newImageDetails.getDescription());
                iImagesRepository.save(existingImage);
                return new ResponseEntity<>("Image updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Image not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while updating the image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



