-- STATUS
create table Status
(
    id integer not null auto_increment ,
    status_id integer not null,
    status_type varchar(255),
    primary key (id)
);

INSERT INTO Status(status_id, status_type) VALUES
                                               (1, 'unresolved'),
                                               (2, 'notified'),
                                               (3, 'resolved');
-- OFFENCE
create table Offence
(
    id integer not null auto_increment ,
    offence_id integer not null,
    offence_type varchar(255) not null,
    primary key (id)
);

insert into Offence
(offence_id, offence_type)
values
    (1, 'stolen'),
    (2, 'wanted'),
    (3, 'expired_license');
--
-- VEHICLE
create table Vehicle
(
    id integer not null auto_increment,
    vehicle_id integer not null,
    status_id integer not null,
    camera_time_captured_at timestamp, -- '2021-08-09 13:57:00--
    license_plate_number varchar(255) not null,
    is_found_match bit,
    primary key (id),
    foreign key(status_id) references Status(id)
);
insert into Vehicle(vehicle_id, status_id, camera_time_captured_at, license_plate_number, is_found_match)
values
    (1,1, null,'ABCK273M', 0),
    (2,2,'2021-08-09 13:57:00', '49H1-1394',0), -- notified
    (3,3,'2022-08-10 09:57:00','H2-1234M1',1);

-- Mapped_Vehicle_Offence
create table Mapped_Vehicle_Offence
(
    id integer not null auto_increment,
    offence_id integer not null,
    vehicle_id integer not null,
    primary key (id),
    foreign key(offence_id) references Offence(id),
    foreign key(vehicle_id) references Vehicle(id)
);

insert into Mapped_Vehicle_Offence
(offence_id, vehicle_id)
values
    (1, 1),
    (1, 2),
    (2, 3),
    (3, 3);


-- USER DETAILS
create table User_Details
(
    id integer not null auto_increment,
    user_details_id integer not null,
    vehicle_id integer not null,
    user_name varchar(255),
    password varchar(255),
    primary key (id),
    foreign key(vehicle_id) references Vehicle(id)
);

INSERT INTO User_Details
(user_details_id, vehicle_id, user_name, password)
VALUES
    (1,1, 'admin','admin'),
    (2,2,'john','johndoe');





