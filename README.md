#Image Management System
Project Context
This project was developed at the request of a client who needs an image management system to save their favorite images. The system will allow users to:
•	Upload and view images
•	Add images to favorites
•	Edit image details (e.g., the title)
•	Delete images
Project Description
The goal of this project is to develop an image management system in Java that offers the following functionalities:
1.	View a list of images: Display the images and their titles stored in the system.
2.	Add images: Allow users to upload new images to the database.
3.	Delete images: Provide the ability to delete images from the database.
4.	Edit an existing image: Allow modification of the title of an already stored image.
5.	Add images to favorites: Mark certain images as favorites for quick access.
Stacks Used
•	Java
•	Spring Boot
•	MySQL
•	JUnit
Good Practices
We have followed object-oriented programming principles and SOLID best practices to ensure that our code is robust, maintainable and extensible.



#Features
1.	See Images all of them or sear by ID
•	Endpoint: GET /tutorials
•	Description: Allows you to view all the tutorials available in the database.
2.	Add Image
•	Endpoint: POST /tutorials
•	Description: Allows you to add a new tutorial to the database.
•	Body: { "title": "titulo", "description": "descripcion", "published": true/false }
3.	Delete Image
•	Endpoint: DELETE /tutorials/{id}
•	Description: Allows you to delete an existing tutorial from the database.
4.	Edit Image by ID
•	Endpoint: PUT /tutorials/{id}
•	Description: Allows you to update an existing tutorial.
•	Body: { "title": "new title", "description": "new description", "published": true/false }

#TDD
All C.R.U.D functionalities were tested using Junit & Mockito.

Installation and Execution
Previous requirements
•	Java 11 or higher -Maven -MySQL


#Instructions
1.	Clone the repository:
git clone https://github.com/usuario/tutorial-management-system.git
cd tutorial-management-system
2.	Configure MySQL database:
•	Create a database called tutorial_db.
•	Configure database credentials in the src/main/resources/application.properties file.
3.	Compile and run the application:
mvn clean install
mvn spring-boot:run
4.	The application will be available at http://localhost:8080.
Contributions
Contributions are welcome. Please open an issue or pull request to discuss any changes you would like to make.
•	Hilmar Hernandez - GitHub
•	Asdrubal Bello - GitHub
•	Maksym Hryshchuk - GitHub
•	Eva Martínez - GitHub

