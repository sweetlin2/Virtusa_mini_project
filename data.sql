-- DATA INSERTION

INSERT INTO Customers (name, city) VALUES
('Sam', 'Chennai'),
('Jeno', 'Kochi'),
('Junia', 'Bombay'),
('Shree', 'Delhi');

INSERT INTO Products (name, category, price) VALUES
('iPhone', 'Electronics', 75000),
('Nike shoes', 'Footwear', 4500),
('Levi jeans', 'Clothing', 2999),
('Headphones', 'Electronics', 2500);

INSERT INTO Orders (customer_id, order_date) VALUES
(1, '2024-01-15'),
(2, '2024-02-10'),
(3, '2024-02-20'),
(4, '2024-03-05');

INSERT INTO Order_Items (order_id, product_id, quantity) VALUES
(1, 1, 1),
(1, 4, 2),
(2, 2, 1),
(3, 3, 2),
(4, 1, 1);