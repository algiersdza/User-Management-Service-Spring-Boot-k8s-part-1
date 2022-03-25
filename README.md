## User Management Service

### Initial steps
After setting up kubernetes, use the provided mysql-custom-deploy.yaml
Its an image pulled from docker to be hosted on k8s

`command: kubectl apply -f mysql-custom-deply.yaml`
 this yaml specifies that user = root, password = password

After deployment, you can access the mysql from your linux terminal.
Grab the pod name to access it, `kubectl get pods`

Also `kubectl get ep`, gives you the ip of the pod of mysql, use this ip in the JDBC driver url instead of 
localhost:3306

`kubectl exec --stdin --tty {your mysql pod name} -- /bin/bash`

`mysql -h localhost -u root -ppassword`, You now have access to mysql, you insert into, select..etc



### Build .jar file, docker it, host it.

Assuming you have everything in order with the project,


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

Record the nodeport of the service
![](../../Downloads/1.png)

Send GET and POST on postman http://localhost:32110/users