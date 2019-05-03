-- creates the amies user and database
-- this script must be executed by an admin user. It can typically be executed from the root of the project using
-- psql -h localhost -U postgres -f backend/database/database.sql

create user fairphone password 'fairphone';
create database fairphone owner fairphone
  encoding 'UTF8'
  lc_collate 'fr_FR.UTF-8'
  lc_ctype 'fr_FR.UTF-8'
  template=template0;

create database fairphone_test owner fairphone
encoding 'UTF8'
lc_collate 'fr_FR.UTF-8'
lc_ctype 'fr_FR.UTF-8'
template=template0;
