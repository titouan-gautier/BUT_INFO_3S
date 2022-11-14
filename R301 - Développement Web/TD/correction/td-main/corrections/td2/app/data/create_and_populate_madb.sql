CREATE TABLE IF NOT EXISTS product (
        id INTEGER PRIMARY KEY,
        name TEXT NOT NULL UNIQUE,
        price FLOAT NOT NULL,
        quantity INTEGER NOT NULL DEFAULT 0
);

INSERT OR REPLACE INTO product (id,name,price, quantity) VALUES (1,'p1',10.0,1);
INSERT OR REPLACE INTO product (id,name,price, quantity) VALUES (2,'p2',20.0,1);

CREATE TABLE IF NOT EXISTS user (
                                    pseudo TEXT PRIMARY KEY,
                                    password TEXT NOT NULL,
                                    status TEXT NOT NULL CHECK ( status IN ('Administrator','Customer','Visitor'))
);
/* password = pass */
INSERT OR REPLACE INTO user (pseudo,password,status) VALUES ('Jojo','$2y$10$JMuuaDMCavASPKf9KBcD1eaMHJ0zkeD8eYs7HjecoD8QeUVRhKQq6','Visitor');
INSERT OR REPLACE INTO user (pseudo,password,status) VALUES ('Raoul','$2y$10$JMuuaDMCavASPKf9KBcD1eaMHJ0zkeD8eYs7HjecoD8QeUVRhKQq6','Customer');
INSERT OR REPLACE INTO user (pseudo,password,status) VALUES ('Romeo','$2y$10$JMuuaDMCavASPKf9KBcD1eaMHJ0zkeD8eYs7HjecoD8QeUVRhKQq6','Administrator');


