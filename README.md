# **Stock Management Application**
This is a Java-based backend application built using Spring Boot framework to manage stocks. The application provides RESTful endpoints to perform CRUD operations on stocks. Additionally, a basic frontend is included to display the list of stocks.

**Getting Started**
To run the application locally, follow the instructions below:

**Prerequisites**

Java JDK (8 or later)
Maven

Installation
Clone the repository:

`git clone https://github.com/AyeniAmanda/Stock.git
`

Run the backend application:
`mvn spring-boot:run   
`
or you run it through your IDE

**Endpoints**

The following RESTful endpoints are available:

* GET /api/stocks: Get a list of stocks.
* GET /api/stocks/{id}: Get details of a single stock.
* PUT /api/stocks/{id}: Update the price of a single stock.
* POST /api/stocks: Create a new stock.

**Stock Object**

A stock object has the following fields:

* id (Number): Unique identifier for the stock.
* name (String): Name of the stock.
* currentPrice (Amount): Current price of the stock.
* createDate (Timestamp): Timestamp indicating when the stock was created.
* lastUpdate (Timestamp): Timestamp indicating when the stock was last updated.


**Technologies Used**

* Java
* Spring Boot
* Maven
