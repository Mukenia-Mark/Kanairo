CREATE DATABASE bus_stop;
\c bus_stop;
CREATE TABLE stops  ( location VARCHAR, bus_sacco_name VARCHAR, cost INTEGER);
CREATE DATABASE bus_stop_test WITH TEMPLATE bus_stop;