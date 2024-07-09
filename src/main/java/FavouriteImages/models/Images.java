package FavouriteImages.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Images {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int id;

        @Column(name = "title")
        private String title;

        @Column(name = "url")
        private String url;

        @Column(name = "Description")
        private String description;
}
