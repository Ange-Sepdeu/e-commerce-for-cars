<%-- 
    Document   : index
    Created on : 23 mai 2024, 20:43:30
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SE3 Mottos</title>
    <link rel="stylesheet" href="style_1.css">
</head>
<body>
    <header>
        <div class="logo">
            <img src="images/logo-no-background.png" alt="SE3 Mottod Logo"> 
            <h1>SE3 Mottos</h1>
        </div>
        <nav>
            <ul>
                <li><a href="#car-for-sale">Cars for Sale</a></li>
                <li><a href="#news-videos">News & Videos</a></li>
                <li><a href="signin.html" class="btn-signin">Sign up/Log in</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <section class="hero">
            <h2>Imagine the Possibilities</h2>
            <p>Mustang Season</p>
            <img src="images\car.jpg" alt="Car driving down a dirt road">
            <div class="sponsored">
                <h3>SE3 Motos</h3>
                <p>Ford Mustang, Great offers across the our lineup.</p>
            </div>
        </section>
        <section id="car-for-sale" class="search">
            <h2>Shop cars for sale</h2>
            <form>
              <div class="search-row">
                <label for="brand-name">Brand Name:</label>
                <select name="brand-name" id="brand-name">
                  <option value="">All Brands</option>
                </select>
              </div>
              <div class="search-row">
                <label for="model-name">Model Name:</label>
                <select name="model-name" id="model-name">
                  <option value="">All Models</option>
                </select>
              </div>
              <div class="search-row">
                <label for="year">Year:</label>
                <select name="year" id="year">
                  <option value="">All Years</option>
                </select>
              </div>
              <div class="search-row">
                <label for="price">Price:</label>
                <select name="price" id="price">
                  <option value="">Any Price</option>
                </select>
              </div>
              <div class="search-row">
                <label for="number-of-cars">Number of Cars:</label>
                <select name="number-of-cars" id="number-of-cars">
                  <option value="">Any Number</option>
                </select>
              </div>
              <div class="search-row">
                <label for="images">Images:</label>
                <select name="images" id="images">
                  <option value="">Any Images</option>
                </select>
              </div>
              <div class="search-row">
                <label for="description">Description:</label>
                <input type="text" name="description" id="description" placeholder="Description">
              </div>
              <div class="search-row">
                <label for="operation">Operation:</label>
                <select name="operation" id="operation">
                  <option value="">Any Operation</option>
                </select>
              </div>
              <button type="submit">Show 10,000+ matches</button>
            </form>
          </section>
          <section class="car-gallery">
            <h2>Cars for Sale</h2>
            <div class="car-container">
                <c:forEach items="${allCars}" var="cars">
                    <div class="car-card">
                <img src="${cars.image}" alt="Lamborghini Aventador">
                <h3>${cars.model}</h3>
                <p>${cars.otherDetails}</p>
                <p>${cars.year}</p>
                </div>
            <form action="SelectSingle" method="POST">
                <input type="text" id="brand" placeholder='${cars.model}' hidden value='${cars.model}' name="model"><br><br>
            <input type="number" hidden id="price" placeholder='${cars.price}' value='${cars.price}' name="price"><br><br>
            <input hidden type="number" id="year" placeholder='${cars.year}' value='${cars.year}' name="year"><br><br>
                        <input hidden type="number" id="year" placeholder='${cars.image}' value='${cars.image}' name="image"><br><br>
                    <input hidden type="number" id="year" placeholder='${cars.image}' value='${cars.numberOfCarsAvailable}' name="numberOfCarsAvailable"><br><br>
            <input hidden name="carId" value='${cars.carId}'>
            <textarea id="description" name="otherDetails" placeholder='${cars.otherDetails}' hidden value='${cars.otherDetails}' rows="4" cols="50"></textarea><br><br>
                <button type="submit" style="background-color: darkblue; color: white; padding: 5px; border: none; text-align: center; cursor: pointer;">View</button>
              </form>
                </c:forEach>
            </div>
          </section>
          <section id="news-videos" class="news-videos-section">
            <h2>News & Videos</h2>
            <div class="news-container">
                <div class="news-card">
                    <img src="images/Ridgeline1.jpg" alt="Ridgeline EV Concept Front-View">
                    <h3>Introducing the Ridgeline EV Concept</h3>
                    <p>The Ridgeline EV concept comes from the mind of California-based Rene Garcia, a concept designer at ILM who’s previously worked on: 
                        <ol>Mandalorian</ol>
                        <ol>Thor: Ragnaroky</ol>
                        <ol>The Avengers</ol>
                        <ol>Transformers</ol>
                    </p>
                    <img src="images/Ridgeline2.jpg" alt="Ridgeline EV Concept side-view">
                    <p>
                        Garcia began designing the vehicle as a Dakar rally truck, but gradual iterations slowly turned it into a conceptual pickup truck for Honda.
                        Designed to handle pretty much anything you can throw at it, the EV comes with its own winch-hook on the front, a frunk behind it, suicide-style rear doors that give you access to the car’s spacious interiors, and an expandable truck-bed on the back that even comes equipped with tools and emergency medical kits
                    </p>
                    <a href="https://www.yankodesign.com/2022/01/23/top-10-automotive-trends-of-2022/" class="btn-read-more">Read More</a>
                </div>
                    <div class="news-card">
                        <img src="images/12bugatti-bugattit55hommage.jpg" alt="Bugattit-55 Hommage">
                        <h3>Bugatti-Bugattit-55 Hommage</h3>
                        <p>
                            <ol>Bugatti has revealed the latest one-of-one Chiron designed by its in-house Sur Mesure team, this time called the "55 One of One.</ol>
                            <ol>As the name implies, the newest Sur Mesure Chiron pays tribute to the renowned Type 55 Super Sport designed by Jean Bugatti.</ol>
                            <ol>The special-edition Chiron Super Sport shares its black and yellow paint scheme with the first Bugatti Super Sport model ever built.</ol>
                        </p>
                        <img src="images/bugatti-bugattit55hommage.jpg" alt="Bugatti-55 Hommage">
                        <p>
                            There are no ugly Bugatti Chirons—or at least we haven't seen any—and the brand's newest one-of-one commission is anything but. On the contrary, Sur Mesure's latest creation is a cut above, using Bugatti's two-tone paint scheme to its full appeal. Called the "55 One of One," this bespoke Chiron Super Sport is a rolling homage to Bugatti's storied past. As the name implies, the newest creation honors the Type 55 Super Sport designed by Jean Bugatti.
                        </p>
                            <a href="about.html" class="btn-read-more">Read More</a>
                    </div>
            </div>
        </section>
    </main>
    <footer>
        <div class="footer">
            <div class="footer-content"> 
                <div class="footer-logo"> 
                    <img src="images/logo-no-background.png" alt="SE3 Mottod Logo"> 
                </div> 
                <div class="footer-links"> 
                    <ul> 
                        <li><a href="#">Home</a>
                        </li> <li><a href="about.html">About Us</a>
                        </li> <li><a href="#">News</a></li>
                        <li><a href="#">Contact</a></li> 
                    </ul> 
                </div> 
                <div class="footer-social"> 
                    <ul>
                        <li><a href="#"><i class="fab fa-facebook-f"></i></a></li> 
                        <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fab fa-instagram"></i></a></li>
                    </ul> 
                </div> 
            </div> 
            <div class="footer-bottom"> 
                <p>&copy; 2024 SE3 Mottos. All rights reserved.</p> 
            </div> 
        </div>
    </footer>
    <form id="car-modal" style="position: absolute; top: 25%; width: 70%; left:50%; padding: 12px;"></form>
    <script>
            const carModal = document.getElementById("car-modal");
            function displayModal(car) {
                const strDive = ""+
                '<div class="car-card">'+
                '<img src="${car.image}" alt="Lamborghini Aventador">'+
                '<h3>${car.model}</h3>'+
                '<p>${car.otherDetails}</p>'+
                '<p>${car.year}</p>'+
              "</div>";
                carModal.innerHTML = strDive;
            }
     </script>
</body>
</html>

