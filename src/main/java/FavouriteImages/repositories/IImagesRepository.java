package FavouriteImages.repositories;

import FavouriteImages.models.Images;
import org.springframework.data.repository.CrudRepository;

public interface IImagesRepository extends CrudRepository <Images, Integer> {

}
