CREATE TABLE IF NOT EXISTS stock (
                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   name VARCHAR(255) NOT NULL,
                                   currentPrice DECIMAL(19, 4) NOT NULL,
                                   created_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                   updated_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON
                                   UPDATE CURRENT_TIMESTAMP
    );