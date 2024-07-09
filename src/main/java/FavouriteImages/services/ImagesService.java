package FavouriteImages.services;

import FavouriteImages.models.Images;
import FavouriteImages.repositories.IImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ImagesService {
    @Autowired
    IImagesRepository iImagesRepository;

    public boolean deleteImageById(long id) {
        try {
            iImagesRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public ArrayList<Images> getAllImages() {
        return (ArrayList<Images>) iImagesRepository.findAll();
    }

    public Images getImageId(int id) {
        Images image = iImagesRepository.findById(id).orElseThrow();;
        return image;
    }
}



