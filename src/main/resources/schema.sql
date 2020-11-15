DROP TABLE IF EXISTS `product_comment`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
    `product_category_id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100),
    `description` VARCHAR(500),
    PRIMARY KEY (`product_category_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

CREATE TABLE `product`  (
    `product_id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100),
    `description` VARCHAR(500),
    `launch_date` DATE NULL DEFAULT NULL,
    `price` DECIMAL(10, 2) NULL DEFAULT 0.00,
    `status` CHAR(1),
    `product_category_product_category_id` INT(11) NOT NULL,
    PRIMARY KEY (`product_id`),
    UNIQUE INDEX `uk_product`(`name`),
    CONSTRAINT `fk_product_category` FOREIGN KEY (`product_category_product_category_id`) REFERENCES `product_category` (`product_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

CREATE TABLE `product_comment`  (
    `product_comment_id` int(11) NOT NULL AUTO_INCREMENT,
    `comment` VARCHAR(300),
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `product_product_id` INT(11) NOT NULL,
    PRIMARY KEY (`product_comment_id`) ,
    CONSTRAINT `fk_product_id` FOREIGN KEY (`product_product_id`) REFERENCES `product` (`product_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

INSERT INTO `product_category`(product_category_id, name, description) VALUES (1, 'Test Product Category', 'This is a product category');
INSERT INTO `product_category`(product_category_id, name, description) VALUES (2, 'Second Product Category', 'This is a product category');
INSERT INTO `product_category`(product_category_id, name, description) VALUES (3, 'Another Product Category', 'This is a product category');

INSERT INTO `product`(product_id, name, description, launch_date, price, status, product_category_product_category_id) VALUES (1, 'Product 1', 'description', '2020-12-01',  199.00, 'A', 1);
INSERT INTO `product`(product_id, name, description, launch_date, price, status, product_category_product_category_id) VALUES (2, 'Product 2', 'description', '2020-12-01',  150.00, 'A', 1);
INSERT INTO `product`(product_id, name, description, launch_date, price, status, product_category_product_category_id) VALUES (3, 'Product 3', 'description', '2020-12-01',  149.00, 'A', 1);
INSERT INTO `product`(product_id, name, description, launch_date, price, status, product_category_product_category_id) VALUES (4, 'Product 4', 'description', '2020-12-01',  129.00, 'A', 1);
INSERT INTO `product`(product_id, name, description, launch_date, price, status, product_category_product_category_id) VALUES (5, 'Product 5', 'description', '2020-12-01',  119.00, 'A', 1);
INSERT INTO `product`(product_id, name, description, launch_date, price, status, product_category_product_category_id) VALUES (6, 'Product 6', 'description', '2020-12-01',  139.00, 'A', 1);
INSERT INTO `product`(product_id, name, description, launch_date, price, status, product_category_product_category_id) VALUES (7, 'Product 7', 'description', '2020-12-01',  179.00, 'A', 2);
INSERT INTO `product`(product_id, name, description, launch_date, price, status, product_category_product_category_id) VALUES (8, 'Product 8', 'description', '2020-12-01',  169.00, 'A', 2);
INSERT INTO `product`(product_id, name, description, launch_date, price, status, product_category_product_category_id) VALUES (9, 'Product 9', 'description', '2020-12-01',  189.00, 'A', 2);
INSERT INTO `product`(product_id, name, description, launch_date, price, status, product_category_product_category_id) VALUES (10, 'Product 10', 'description', '2020-12-01',  199.00, 'A', 1);
INSERT INTO `product`(product_id, name, description, launch_date, price, status, product_category_product_category_id) VALUES (11, 'Product 11', 'description', '2020-12-01',  119.00, 'A', 2);

INSERT INTO `product_comment`(comment, product_product_id) VALUES ('comment', 1);
INSERT INTO `product_comment`(comment, product_product_id) VALUES ('comment', 1);
INSERT INTO `product_comment`(comment, product_product_id) VALUES ('comment', 1);
INSERT INTO `product_comment`(comment, product_product_id) VALUES ('comment', 2);
INSERT INTO `product_comment`(comment, product_product_id) VALUES ('comment', 2);
INSERT INTO `product_comment`(comment, product_product_id) VALUES ('comment', 3);
INSERT INTO `product_comment`(comment, product_product_id) VALUES ('comment', 3);
INSERT INTO `product_comment`(comment, product_product_id) VALUES ('comment', 3);
INSERT INTO `product_comment`(comment, product_product_id) VALUES ('comment', 3);
