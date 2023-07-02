INSERT INTO users (username, first_name, last_name, email, profile_picture, pass, role, phone_number, balance_eur, creation_ts)
VALUES (?, ?, ?, ?, NULL, ?, ?, ?, ?, ?);

SELECT * FROM users;

UPDATE users
SET first_name = ?, last_name = ?
WHERE id = ?;

DELETE FROM users
WHERE id = ?;

INSERT INTO posts (title, description, price, category)
VALUES (?, ?, ?, ?);

SELECT * FROM posts;

UPDATE posts
SET title = ?, price = ?
WHERE id = ?;

DELETE FROM posts
WHERE id = ?;

INSERT INTO locations (country, region, city)
VALUES (?, ?, ?);

SELECT * FROM locations;

UPDATE locations
SET city = ?
WHERE id = ?;

DELETE FROM locations
WHERE id = ?;
