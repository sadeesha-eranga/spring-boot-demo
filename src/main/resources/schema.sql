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

INSERT INTO `product_category`(name, description) VALUES ('Test Product Category', 'This is a product category');
INSERT INTO `product_category`(name, description) VALUES ('Second Product Category', 'This is a product category');
