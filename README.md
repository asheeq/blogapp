# BlogApp built on Spring Boot, Spring Security, Thymeleaf, Spring Data JPA, Spring Data REST and H2 Database.

Overview - 
1. Two types of users. Admin & Blogger.
2. Admin has the following functionalities:
a. Log in with username/password
b. Create other Admin account
c. Approve / Deactivate Blogger type user’s account
d. Approve and publish a Blog post
e. Delete any blog post

3. Blogger has following functionality before his/her account is approved by Admin:
a. Create an account and send for Admin’s approval.

4. Blogger will have following functionalities after his/her account is approved by Admin:
a. Log in with username/password
b. Create a blog post and send for admin’s approval
c. Delete own blog post
d. View other blogger’s approved blog post
e. Comment on other blogger’s approved blog post

-----------------------------------------------------------

#Run $ mvn spring-boot:run

#Visit the page http://localhost:8080/login after application starts.

#Admin username: admin||Admin password: admin

#H2 Database web interface
Go to the web browser and visit http://localhost:8080/h2-console

-----------------------------------------------------------
