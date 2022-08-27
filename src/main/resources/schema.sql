create table User_Details
(
    id integer not null auto_increment,
    user_name varchar(255),
    password varchar(255),
    primary key (id)
);

INSERT INTO User_Details(user_name, password) VALUES ('admin','admin');

INSERT INTO User_Details(user_name, password) VALUES ('john','johndoe');

-- for foreign key definition

-- CREATE TABLE PLANETICKETS(
--     DESTINATION VARCHAR(10) NOT NULL,
--     TICKETPRICE NUMERIC(8,2) NOT NULL,
--     TOURISTINFO_ID INT,
--     FOREIGN KEY(TOURISTINFO_ID) REFERENCES TOURISTINFO -- no need for touristinfo(TOURISTINFO_ID)
-- )

