# Flight Planner Web Application - Server Source Code 

The project is a web application that allows users to manage airports & aircraft as well as plan flights between airports.

The project is currently in development.

## Server Implementation Details

- Spring Boot with Spring Data JPA
- Layered architecture
    - Presentation layer
    - Service layer
    - Data Access layer
      - Domain Model
      - Repository
- Currently supports CRUD for airports & aircraft alongside various find & list methods to support queries that narrow down by a specific attribute
- Will support query to use flight planner. The flight planner will use the A* algorithm to find the shortest path between the starting & destination airports while adhering to the limitations of the selected aircraft.
- Will support storage & retrieval of flight plans.
