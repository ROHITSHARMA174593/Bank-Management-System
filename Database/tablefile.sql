use bankmanagementsystem;

CREATE TABLE signup (
    FormNo VARCHAR(20) PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    FName VARCHAR(100),
    DOB VARCHAR(20), -- Alternatively use DATE
    Email VARCHAR(100),
    Gender VARCHAR(10),
    Marital VARCHAR(15),
    Address VARCHAR(200),
    City VARCHAR(100),
    State VARCHAR(100),
    PinCode VARCHAR(10)
);


CREATE TABLE signuptwo (
    Religion VARCHAR(50),
    Category VARCHAR(50),
    Income VARCHAR(50),
    Occupation VARCHAR(50),
    AadharNumber VARCHAR(20),
    PanNumber VARCHAR(20),
    Education VARCHAR(50),
    SeniorCitizen VARCHAR(5),
    ExistingAccount VARCHAR(5)
);


CREATE TABLE signupthree (
    AccountType VARCHAR(50),
    CardNumber VARCHAR(20),
    PinNumber VARCHAR(10),
    Facility TEXT
);

CREATE TABLE Bank (
    Pin_Number VARCHAR(20),
    Date TIMESTAMP,
    type VARCHAR(20),
    amount INT
);

CREATE TABLE login (
    cardNumber VARCHAR(20) PRIMARY KEY,
    pinNumber VARCHAR(10)
);
