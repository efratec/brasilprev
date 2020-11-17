# Brasilprev
Api Service Brasilprev

# Initial Configuration

* Docker => The api contains the "docker-compose.yaml" file where the postgre dockerized database configuration

1) Executing the file "docker-compose.yaml"

2) Run the api using the application-dev.yaml because is local

2.1) To configure application-dev.yml you need to edit the BrasilPrevApplication file in the VMOption part for -Dspring.profiles.active = dev. This configuration is to run local

2.2) After executing the file above, execute the insert below for the admin user INSERT INTO users (user_id, email, "name", "password", "role") VALUES (1,'admin@gmail.com', 'admin', 'admin', 0);

# SWAGGER DOCUMENTATION
* Local access => http://localhost:8080/swagger-ui.html#




  
