# README #

1) Встановити pgAdmin4 (https://o7planning.org/ru/11353/installing-pgadmin-on-ubuntu#a6605357), створити тестову базу даних.
* name:ContactsServer; 
* Host name:localhost;
* Port:5432;
* Maintenance database:postgres;
* Username:postgres;
* Password:postgres;

2) Запустити файл src/main/resources/sql/init.sql для заповнення бази тестовими даними

3) Запустити проект (app.ApplicationConfiguration), API відпрацює за таким URL: http://localhost:8080/hello/contacts.

Приклад зі всіма параметрами: 
http://localhost:8080/hello/contacts?nameFilter=^B.*$&page=0&size=40