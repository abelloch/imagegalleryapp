package FavouriteImages.services;

import FavouriteImages.models.Images;
import FavouriteImages.repositories.IImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagesService {
    @Autowired
    IImagesRepository iImagesRepository;

    public Images createImages (Images newimages){
        return iImagesRepository.save(newimages);
    }
}
