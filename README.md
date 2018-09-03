#The simple blog web application.

It was made using Spring Boot, Spring Data JPA, Spring Data REST. Database is in memory H2.

The application have one user role - PUBLISHER.
username - john
password - password

Only the publisher can update or remove only own posts.

Required technologies: Java 8.

To run this project you need to choose class Application in IDE and click 'run application'.

For more API documentation or curl requests you need to go http://localhost:8080/swagger-ui.html
and send request if you need to authenticate :
{
                   "username": "john",
                   "password": "password"
                 }
![Image alt](https://github.com/MadKiev/webBlogRest/blob/master/Screen%20Shot%202018-09-02%20at%2018.08.55.png)
