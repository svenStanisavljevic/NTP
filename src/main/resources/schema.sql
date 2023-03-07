DROP TABLE IF EXISTS posts_users CASCADE;
CREATE TABLE posts_users (
     post_id INT NOT NULL,
     user_id INT NOT NULL,
     PRIMARY KEY (post_id, user_id),
     FOREIGN KEY (post_id) REFERENCES posts(id),
     FOREIGN KEY (user_id) REFERENCES users(id)
);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users(
     id INT GENERATED ALWAYS AS IDENTITY,
     username VARCHAR(50) NOT NULL,
     first_name VARCHAR(50) NOT NULL,
     last_name VARCHAR(50) NOT NULL,
     email VARCHAR(80) NOT NULL,
     profile_picture BLOB,
     pass VARCHAR(300) NOT NULL,
     phone_number VARCHAR(30) NOT NULL,
     balance_eur DOUBLE PRECISION NOT NULL,
     PRIMARY KEY (id)
);

DROP TABLE IF EXISTS posts CASCADE;
CREATE TABLE posts(
     id INT GENERATED ALWAYS AS IDENTITY,
     title VARCHAR(100) NOT NULL,
     description VARCHAR(1000) NOT NULL,
     price DOUBLE PRECISION NOT NULL,
     category VARCHAR(30)
);
