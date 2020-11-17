# Brasilprev
Api Service Brasilprev

# Initial Configuration

* Docker => The api contains the "docker-compose.yaml" file where the postgre dockerized database configuration

1) Executing the file "docker-compose.yaml"

2) Run the api using the application-dev.yaml because is local

2.1) To configure application-dev.yml you need to edit the BrasilPrevApplication file in the VMOption part for -Dspring.profiles.active = dev. This configuration is to run local

2.2) After executing the file above, execute the insert below for the admin user INSERT INTO users (user_id, email, "name", "password", "role") VALUES (1,'admin@gmail.com', 'admin', 'admin', 0);

# SWAGGER DOCUMENTATION
*Local access => http://localhost:8080/swagger-ui.html#

=> Was created two java class: CustomerResource and LoginResource

-CustomerResouce
*Services created:
- GET localhost8080/api/customers = list all customers
- GET localhost8080/api/customers/{name} = Get customer by name
- PUT localhost8080/api/customers/{id} = Update Customers
- POST localhost8080/api/customers/ = Save Customers
- DELETE localhost8080/api/customers/{id} = Delete Customers

-LoginResouce
*Services created:
- POST localhost8080/login/authentication = User Authentication

You need to authenticate the user saved in the database, which in this case is:
{
   "email": "admin@gmail.com",
   "password": "admin"
}

With that, the api will authenticate and generate a valid token to be executed in the swagger









  
