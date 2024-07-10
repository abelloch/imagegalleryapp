package FavouriteImages.services;

import FavouriteImages.models.Images;
import FavouriteImages.repositories.IImagesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ImagesServiceTest {
    @Mock
    private IImagesRepository iImagesRepository;

    @InjectMocks
    private ImagesService imagesService;

    private Images imagePersona;
    private Images imageGrandblue;
    private ArrayList<Images> imagesList = new ArrayList<>();


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        imagePersona = new Images();
        imagePersona.setId(1);
        imagePersona.setTitle("Persona");
        imagePersona.setDescription("Game persona 4");
        imagePersona.setDescription("https://miro.medium.com/v2/resize:fit:1400/1*cz97DqG8yiPh2G2k3lz-rQ.jpeg");

        imageGrandblue = new Images();
        imageGrandblue.setId(2);
        imageGrandblue.setTitle("Granblue Fantasy");
        imageGrandblue.setDescription("Game Granblue Fantasy Relink");
        imageGrandblue.setUrl("https://static0.gamerantimages.com/wordpress/wp-content/uploads/2024/01/granblue-fantasy-relink-key-art.jpg");

        imagesList.add(imagePersona);
        imagesList.add(imageGrandblue);
    }
    @Test
    void getAllImages() {
        when(imagesService.getAllImages()).thenReturn(imagesList);

        ArrayList<Images> allImages = imagesService.getAllImages();
        assertEquals(2, allImages.size());
        assertEquals("Persona", allImages.get(0).getTitle());
        assertEquals("Granblue Fantasy", allImages.get(1).getTitle());
    }

    @Test
    void getImageId() {
        when(iImagesRepository.findById(2)).thenReturn(Optional.of(imageGrandblue));
        Images imageId = imagesService.getImageId(2);
        assertEquals("Granblue Fantasy", imageId.getTitle());
        assertEquals("Game Granblue Fantasy Relink", imageId.getDescription());
    }
}