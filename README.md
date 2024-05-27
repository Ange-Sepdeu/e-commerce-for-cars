e-commerce-for-cars is a web application where users can reserve cars and contact the administrators for details concerning the cars. It was built in J2E (Java Enterprise Edition), with the following properties:
- JDK 19.
- MySQL from Xampp.
- Glassfish server to deploy the application.
- Apache Netbeans 20 as IDE.
  The following are the steps required to enable the proper functioning of this project:
- Cloning this repository using git clone repo_url.
- Opening the project in an IDE and installing the required dependencies.
Note: There's a backup of the database we used for this project named "se3_motors.sql" containing all database tables with values.
- Importing or restoring the database in xampp or mysql workbench.
Remarks
1 This web application performs basic crud operations wherein:
- The admin is able to login (email: admin@gmail.com, password:12345).
- The login button is after the startup page(after clicking on navigate), in the header part of the index page.
- The admin is able to create a brand, edit, view and delete the created brand.
- The administrator is able to add a car to a particular brand, edit, view, add the cars avaliable and delete that specific car.
  While adding the car he's able to upload a photo of it.
- The user is able to view all added cars and click on view to get the most information about each car and reserve one which shiuld automatically reduce the number of cars available for the model.
2 The database port number should be changed at the convenience of the user (in the DatabaseConnection.java file)
Some loop holes:
- A small error when reserving a car due to some technicalities.
- Due to time constraints password encryption | hashing was not implemented.
- Small redirect errors might be observed while testing the web application.
