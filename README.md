## User Management Service

This project was part of 1 of 2 services to host on kubernetes hosted on localhost ubuntu. The purpose of this
project was to demonstrate the ability of understanding DevOps by hosting two services umso (User Management Service)
and meso (Message Service) with Spring Boot to act as an API service to a mysql pod (hosted on k8s as well)
to respond with appropriate responses (code 200 or 404/403).

For simplicity to whoever is reading this I included in this repository the YAML files for mysql and umso that I used to deploy and service as well
as the SQL files to create the database and populate.

### Initial steps
After setting up kubernetes, I applied the mysql-custom-deploy.yaml which is an
image pulled from docker to be hosted on k8s

`command: kubectl apply -f mysql-custom-deply.yaml`.
This yaml specifies that user = root, password = password

After deployment, I accessed the mysql from the linux terminal.
Using `kubectl get pods` I grabbed the pod name to access it.

Also `kubectl get ep`, gives me the ip of the pod of mysql that is hosted on k8s and used this ip in the JDBC driver url instead of 
localhost:3306.

To access the mysql instance from my terminal I used:
`kubectl exec --stdin --tty {your mysql pod name} -- /bin/bash`

`mysql -h localhost -u root -ppassword`, which gave me the ability to interact with MYSQL statements.

Using the provided .sql files, create and populate the database. Note the name of the database and the JDBC driver url.

### Build .jar file, docker it, host it.
After finishing the Spring Boot properties and creating the specific java classes that require this service
to perform the duties required,

````
1) ./mvnw clean   <--- cleans your build after any modifications, 
removes the target folder for a better build process i guess?

2) ./mvnw package   <--- builds the project and tests the connection to the database, 
basically runs and tests your application.

3) docker build . -t umso:local  <--- builds the image to be contained locally on docker
4) docker save umso > umso.tar`  <--- create and containerize the image
5) microk8s ctr image import umso.tar  
6) kubectl apply -f umso-dep-svc.yaml  <---- deploy and service the application on kubernetes!
````

`kubectl get all` will display the service and pod hosted on k8s. Dashboard can give more info with logs as well!

Record the nodeport of the service (umso)

Send GET and POST on postman. 
example: http://localhost:32110/users

## Challenges Faced
 - YAML creations for deployment and service
 - New to JPA
 - New to Spring Boot and had to consult the documentations
 - New to Kubernetes and had to consult the documentations
 - Project was failing on build (connection refused or no connection detected), this was due to the JDBC driver url
not properly connecting to MYSQL pod on k8s. (not localhost:3306, but rater should grab the IP of the pod, see application.properties)

Video link to demonstrate the build and service in action (shows meso as well): https://www.youtube.com/watch?v=6887G98OULQ