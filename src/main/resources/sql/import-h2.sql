ALTER TABLE POST
  ALTER COLUMN create_date SET DEFAULT CURRENT_TIMESTAMP;

INSERT INTO USER (user_id, approved, password, email, username, first_name, last_name, active)
VALUES
  (1, true, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'batman@mail.com', 'batman', 'Bruce', 'Wayne',
   1);

INSERT INTO USER (user_id, approved, password, email, username, first_name, last_name, active)
VALUES
  (2, true, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'superman@gmail.com', 'superman', 'Clerk', 'Kent', 1);

INSERT INTO USER (user_id, approved, password, email, username, first_name, last_name, active)
VALUES (3, true, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'joker@gmail.com', 'joker', 'Arthur', 'Fleck', 1);

INSERT INTO USER (user_id, approved, password, email, username, first_name, last_name, active)
VALUES (4, true, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'asheeq.bracu@gmail.com', 'asheeq', 'Ashiqur', 'Rahman',1);

INSERT INTO USER (user_id, approved, password, email, username, first_name, last_name, active)
VALUES (5, false, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'jzzz@gmail.com', 'jzzz', 'zzz', 'zzz', 1);


INSERT INTO ROLE (role_id, role)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE (role_id, role)
VALUES (2, 'ROLE_USER');


INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 2);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (2, 2);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (3, 2);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (4,2);


INSERT INTO POST (post_id, approved, user_id, title, body, create_date)
VALUES (1, true, 1, 'Gotham',
        '"Where is Joker? We need to talk."',
        {ts '2020-10-19 11:10:13.247'});
INSERT INTO POST (post_id, approved, user_id, title, body, create_date)
VALUES (2, true, 2, 'Arkham',
        '"You wont let me live, you wont let me die."',
        {ts '2020-05-10 11:10:13.247'});
INSERT INTO POST (post_id, approved, user_id, title, body, create_date)
VALUES (3, true, 3, 'Metropolis',
        '"If you are good at something never do it for free."',
        {ts '2020-06-10 11:10:13.247'});
INSERT INTO POST (post_id, approved, user_id, title, body, create_date)
VALUES (4, false, 3, 'New York',
        '"approved?"',
        {ts '2020-06-10 11:10:13.247'});


INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (1, 3,
        '"Dont you have a city that needs saving?."',
        CURRENT_TIMESTAMP());
INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (2, 1,
        '"Alfred, I need the big gun."',
        CURRENT_TIMESTAMP());

