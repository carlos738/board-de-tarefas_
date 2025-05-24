
CREATE TABLE task (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    status VARCHAR(20) NOT NULL,
    board_id BIGINT,
    FOREIGN KEY (board_id) REFERENCES board(id)
);
