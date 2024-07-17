package FavouriteImages.controllers;

import FavouriteImages.models.Images;
import FavouriteImages.services.ImagesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ImagesControllersTest {

    @Mock
    private ImagesService imagesService;

    @InjectMocks
    private ImagesControllers imagesController;

    private MockMvc mockMvc;

    private Images imagePersona;
    private Images imageGrandblue;
    private ArrayList<Images> imagesList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(imagesController).build();

        imagePersona = new Images();
        imagePersona.setId(1);
        imagePersona.setTitle("Persona");
        imagePersona.setDescription("Game persona 4");
        imagePersona.setUrl("https://miro.medium.com/v2/resize:fit:1400/1*cz97DqG8yiPh2G2k3lz-rQ.jpeg");
        imagePersona.setFavorite(false);

        imageGrandblue = new Images();
        imageGrandblue.setId(2);
        imageGrandblue.setTitle("Granblue Fantasy");
        imageGrandblue.setDescription("Game Granblue Fantasy Relink");
        imageGrandblue.setUrl("https://static0.gamerantimages.com/wordpress/wp-content/uploads/2024/01/granblue-fantasy-relink-key-art.jpg");
        imageGrandblue.setFavorite(false);

        imagesList = new ArrayList<>(Arrays.asList(imagePersona, imageGrandblue));
    }

    @Test
    void getAllImages() throws Exception {
        when(imagesService.getAllImages()).thenReturn(imagesList);

        mockMvc.perform(get("/api/v1"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1, 'title': 'Persona', 'description': 'Game persona 4', 'url': 'https://miro.medium.com/v2/resize:fit:1400/1*cz97DqG8yiPh2G2k3lz-rQ.jpeg'}, {'id': 2, 'title': 'Granblue Fantasy', 'description': 'Game Granblue Fantasy Relink', 'url': 'https://static0.gamerantimages.com/wordpress/wp-content/uploads/2024/01/granblue-fantasy-relink-key-art.jpg'}]"));
    }

    @Test
    void getImageId() throws Exception {
        when(imagesService.getImageId(2)).thenReturn(imageGrandblue);

        mockMvc.perform(get("/api/v1/images/2"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 2, 'title': 'Granblue Fantasy', 'description': 'Game Granblue Fantasy Relink', 'url': 'https://static0.gamerantimages.com/wordpress/wp-content/uploads/2024/01/granblue-fantasy-relink-key-art.jpg'}"));
    }

    @Test
    void deleteImagesById() throws Exception {
        when(imagesService.deleteImagesById(2)).thenReturn(true);

        mockMvc.perform(delete("/api/v1/images/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("image with id" + 2 + "was deleted"));

        when(imagesService.deleteImagesById(2)).thenReturn(false);

        mockMvc.perform(delete("/api/v1/images/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("Error, we have a problem to deleted image with id 2"));
    }

    @Test
    void createImage() throws Exception {
        when(imagesService.createImages(any(Images.class))).thenReturn(imageGrandblue);
        String imageJson = "{\"title\": \"Granblue Fantasy\", \"description\": \"Game Granblue Fantasy Relink\", \"url\": \"https://static0.gamerantimages.com/wordpress/wp-content/uploads/2024/01/granblue-fantasy-relink-key-art.jpg\"}";
        mockMvc.perform(post("/api/v1/images")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(imageJson))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 2, \"title\": \"Granblue Fantasy\", \"description\": \"Game Granblue Fantasy Relink\", \"url\": \"https://static0.gamerantimages.com/wordpress/wp-content/uploads/2024/01/granblue-fantasy-relink-key-art.jpg\"}"));
    }

    @Test
    void updateImage() throws Exception {
        doNothing().when(imagesService).updateImage(imageGrandblue, 2);

        ObjectMapper objectMapper = new ObjectMapper();
        String imageJson = objectMapper.writeValueAsString(imageGrandblue);

        mockMvc.perform(put("/api/v1/images/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(imageJson))
                .andExpect(status().isOk());
    }
    @Test
    void updateFavoriteImage() throws Exception {
        when(imagesService.updateFavorite(2)).thenReturn(imageGrandblue);

        mockMvc.perform(put("/api/v1/images/2/favorite"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.title", is("Granblue Fantasy")))
                .andExpect(jsonPath("$.favorite",is(false)));
        verify(imagesService).updateFavorite(2);
    }
}
