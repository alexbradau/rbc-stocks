# rbcstocks

This application was generated using JHipster 6.10.3, you can find documentation and help at [https://www.jhipster.tech/documentation-archive/v6.10.3](https://www.jhipster.tech/documentation-archive/v6.10.3).

## Development

Before you can build this project, you must install and configure the following dependencies on your machine:

1. [Node.js][]: We use Node to run a development web server and build the project.
   Depending on your system, you can install Node either from source or as a pre-packaged bundle.

After installing Node, you should be able to run the following command to install development tools.
You will only need to run this command when dependencies change in [package.json](package.json).

```
npm install
```

We use npm scripts and [Webpack][] as our build system.

Run the following commands in two separate terminals to create a blissful development experience where your browser
auto-refreshes when files change on your hard drive.

```

./mvnw


npm start
```

Npm is also used to manage CSS and JavaScript dependencies used in this application. You can upgrade dependencies by
specifying a newer version in [package.json](package.json). You can also run `npm update` and `npm install` to manage dependencies.
Add the `help` flag on any command to see how you can use it. For example, `npm help update`.

The `npm run` command will list all of the scripts available to run for this project.

## Front End

The front end can be accessed at localhost:8080.

The Dow Jones Indices can be found under Entities in the admin menu, logging in as admin/admin

## REST API
The following can be tested using Postman while the server is running.
Authentication is either user/user or admin/admin

# GET all Dow Jones Indices

localhost:8080/api/dow-jones-indices

# GET Dow Jones Indices by stock

localhost:8080/api/dow-jones-indices/{stock}

# POST create a single new Dow Jones Index

localhost:8080/api/dow-jones-indices

Here is a test record you may use in the body of the request:

{"quarter": 1,"stock": "TEST","date": "2011-01-07","open": 15.82,"high": 16.72,"low": 15.78,"close": 16.42,"volume": 239655616,"percentChangePrice": 3.79267,"percentChangeVolumeOverLastWeek": null,"previousWeeksVolume": null,"nextWeeksOpen": 16.71,"nextWeeksClose": 15.97,"percentChangeNextWeeksPrice": -4.42849,"daysToNextDividend": 26,"percentReturnNextDividend": 0.182704}

# POST bulk data upload from file

localhost:8080/api/upload-file

Add a form-data body to the request with a key value of 'file' and a type of File. Select your csv data file from your filesystem (http://archive.ics.uci.edu/ml/machine-learning-databases/00312/) under Value

