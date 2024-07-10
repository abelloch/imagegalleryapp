package FavouriteImages.services;

import FavouriteImages.models.Images;
import FavouriteImages.repositories.IImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ImagesService {

    @Autowired
    IImagesRepository iImagesRepository;


    // Update by ID
    public void updateImage(Images images, Integer id) {
        images.setId(id);
        iImagesRepository.save(images);
    }

}




