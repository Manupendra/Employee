# Spring Boot Web App

#### This project is demonstrate the CI/CD pipeline, it is build as docker image and pushed to dockerHub repo after that I've deployed in K8s with log are stored in central data store - Logstash and visual and monitor using ELK stask. 
The project is Spring Boot Application using gradle build tool. It contains 3 endpoints 
1. **GET** ```/status``` - to check the liveness or readiness of the service
2. **GET** ```/employees/get``` - to get the list of employees 
3. **POST** ```/employees/add``` - to add the employee in the list with payload ```{
			"firstName": "Manupendra",
			"lastName": "Tiwari",
			"email": "manupendratiwari@gmail.com"
}```

### CI/CD pipeline of Spring Boot Application
-----------

<img width="1327" alt="Screenshot 2022-09-10 at 2 01 29 PM" src="https://user-images.githubusercontent.com/26532939/189481886-9045a70e-aa2c-4929-97b3-e9305335c36d.png">

#### Step 1: Build the docker image 

Here, I've build the image using [dockerfile](https://github.com/Manupendra/Employee/blob/master/dockerfile), the following is the command, in this command we have one parameter which takes the already build jars(usig gradle build): 

```docker build --build-arg JAR_FILE=build/libs/\*.jar -t employee-spring-boot-app:latest .```

#### Step 2: Push the image to DockerHub repository 

Here, we have push the image to dockerhub repository using latest tag of build image.Here are the following commands:

```docker tag employee-spring-boot-app:latest manupendra/employee-spring-boot-app:latest```<br />
```docker push manupendra/employee-spring-boot-app:latest```


**The following is image in remote DockerHub repository Screenshot**

<img width="1440" alt="Screenshot 2022-09-09 at 2 58 57 PM" src="https://user-images.githubusercontent.com/26532939/189482480-fc9cf456-b49b-4d03-8d8d-218e8c31d733.png">

#### Step 3: Deploy the Application in Minikube using Helm 

Here, I've deployed the Apllication in local minikube k8s cluster using [helm chart](https://github.com/Manupendra/Employee/tree/master/helm-charts/employeeapp). The following is the helm command:

```helm install employeeapp employeeapp/ --values employeeapp/values.yaml```<br />

**Service Readiness/liveness status Screenshot**

<img width="1440" alt="Screenshot 2022-09-09 at 8 40 59 PM" src="https://user-images.githubusercontent.com/26532939/189482797-e112c94e-5cc3-43d8-95a0-d8acd40e4f68.png">

Here, we have deployed the service using ClusterIP and targetport 8080

We have verified the service after hitting the endpoint **GET** ```/employees/get```. the following is screenshot of the request:

<img width="1440" alt="Screenshot 2022-09-09 at 8 35 30 PM" src="https://user-images.githubusercontent.com/26532939/189482979-7897ef9c-afa6-44a8-9869-c728a623b2d2.png">

**Screenshot of Server trace of the above request in pod**. The following is the command to get the pod logs ```kubectl logs -f <ContainerName>```

<img width="1440" alt="Screenshot 2022-09-09 at 8 34 51 PM" src="https://user-images.githubusercontent.com/26532939/189483041-a26e1a6b-2a7f-4121-97d2-e30efa16f00e.png">

#### Code coverage 

Here, we have used jacoco library for code coverage, the following is screenshot of code coverage report;

<img width="1438" alt="Screenshot 2022-09-09 at 11 58 17 PM" src="https://user-images.githubusercontent.com/26532939/189483148-b3bc8cf4-f018-4559-b91d-2b02276b6ce3.png">

#### Logging and Visualization using ELK stack 

Server logs been send to Logstash using output log file. Below is screenshot of it.

<img width="1440" alt="Screenshot 2022-09-13 at 6 45 37 PM" src="https://user-images.githubusercontent.com/26532939/189911521-55dae46e-0189-4532-bb2a-c57ce4e3a306.png">

Using ElasticSearch we can see the index of logstash logs, below is screenshot of it 

<img width="1440" alt="Screenshot 2022-09-13 at 6 53 09 PM" src="https://user-images.githubusercontent.com/26532939/189912743-9f786070-63b0-4c95-a3c8-06a2ac396777.png">

Visualize logs in Kibana locally of **logstash-** index 

<img width="1440" alt="Screenshot 2022-09-13 at 6 56 20 PM" src="https://user-images.githubusercontent.com/26532939/189913304-5e6e40a3-5295-4754-b308-b4d3fce7c914.png">



