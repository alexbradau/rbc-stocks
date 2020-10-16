# rbcstocks

## Install

Run the following command in the root directory of the project to build and start the application server:

```

./mvnw

```

## Front End

The front end can be accessed at localhost:8080.

The Dow Jones Indices can be found under Entities in the admin menu, logging in as admin/admin

## REST API
The following can be tested using Postman while the server is running.
Authentication is either user/user or admin/admin

### GET all Dow Jones Indices

localhost:8080/api/dow-jones-indices

### GET Dow Jones Indices by stock

localhost:8080/api/dow-jones-indices/{stock}

### POST create a single new Dow Jones Index

localhost:8080/api/dow-jones-indices

Select a raw body with JSON type in Postman. Here is a test record you may use in the body of the request:

{"quarter": 1,"stock": "TEST","date": "2011-01-07","open": 15.82,"high": 16.72,"low": 15.78,"close": 16.42,"volume": 239655616,"percentChangePrice": 3.79267,"percentChangeVolumeOverLastWeek": null,"previousWeeksVolume": null,"nextWeeksOpen": 16.71,"nextWeeksClose": 15.97,"percentChangeNextWeeksPrice": -4.42849,"daysToNextDividend": 26,"percentReturnNextDividend": 0.182704}

### POST bulk data upload from file

localhost:8080/api/upload-file

Add a form-data body to the request with a key value of 'file' and a type of File. Select your csv data file from your filesystem (http://archive.ics.uci.edu/ml/machine-learning-databases/00312/) under Value

