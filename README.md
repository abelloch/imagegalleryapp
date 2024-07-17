# Pixel Gallery 

# Project Context :
This project was developed as a result of a client's request for an image management system that allows them to manage and store their favorite images.

The webpage will allow users to: 

•	Upload and view images
•	Add images to favorites
•	Edit image details (e.g., the title)
•	Delete images

Users are also allowed to mark their favorite images by clicking the Heart button as a sign of "I like it!"

# Project Description:

Create a personalized API whose allowing to complete the CRUD process using the following stack:

•	Java
•	Spring Boot
•	MySQL
•	JUnit


Good Practices : We have followed object-oriented programming principles and SOLID best practices to ensure that our code is robust, maintainable and extensible.



#  API Features:

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

# TDD:
Functionalities were tested using Junit & Mockito.

Installation and Execution
Previous requirements
•	Java 11 or higher -Maven -MySQL


# Instructions:

1.	Clone the repository:
git clone (https://github.com/abelloch/imagegalleryapp.git)
2.	Create a  local database called tutorial_db.
•	Configure database credentials in the src/main/resources/application.properties file.
3.	Compile and run the application:
mvn clean install
mvn spring-boot:
4.	The application will be available at http://localhost:8080.


#Contributions
Contributions are welcome!!!. Please open an issue or pull request to discuss any changes you would like to make.

# Developer Team : 

•	Hilmar Hernandez - GitHub
•	Asdrubal Bello - GitHub
•	Maksym Hryshchuk - GitHub
•	Eva Martínez - GitHub

# Checkout our video Demo!! :

https://drive.google.com/file/d/16IPlLf2it2LZBbqejzsALRPrSUf4T8Kv/view
