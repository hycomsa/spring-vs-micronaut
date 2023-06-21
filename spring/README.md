# Getting Started

### Using docker to setup mongodb
```
docker pull mongo
docker run -d --name mongo -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin mongo
```

### Running in development mode
To run application in development mode simply run the following goal:

```
$ ./mvnw clean spring-boot:run 
```

### Executable with Native Build Tools
Use this option if you want to build a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.

To create the executable, run the following goal:

```
$ ./mvnw clean native:compile -Pnative
```

Then, you can run the app as follows:
```
$ target/demo
```

