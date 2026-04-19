/* QUERIES
Key Tasks
Find top-selling products
Identify most valuable customers
Monthly revenue calculation
Category-wise sales analysis
Detect inactive customers
Expected Outcome
A structured database with optimized queries that provide actionable business insights.
*/

-- Top selling products
SELECT pr.name AS product_name,
       SUM(oi.quantity) AS total_quantity
FROM Order_Items oi
JOIN Products pr ON oi.product_id = pr.product_id
GROUP BY pr.name
ORDER BY total_quantity DESC;

-- Customers who spent the most money
SELECT cu.name AS customer_name,
       SUM(oi.quantity * pr.price) AS total_amount
FROM Customers cu
JOIN Orders ord ON cu.customer_id = ord.customer_id
JOIN Order_Items oi ON ord.order_id = oi.order_id
JOIN Products pr ON oi.product_id = pr.product_id
GROUP BY cu.name
ORDER BY total_amount DESC;

-- Revenue per month
SELECT DATE_FORMAT(ord.order_date, '%M %Y') AS month_name,
       SUM(oi.quantity * pr.price) AS total_revenue
FROM Orders ord
JOIN Order_Items oi ON ord.order_id = oi.order_id
JOIN Products pr ON oi.product_id = pr.product_id
GROUP BY month_name;

-- Sales based on product category
SELECT pr.category AS category_name,
       SUM(oi.quantity * pr.price) AS total_revenue
FROM Order_Items oi
JOIN Products pr ON oi.product_id = pr.product_id
GROUP BY pr.category
ORDER BY total_revenue DESC;

-- Customers who have not ordered in last 90 days
SELECT cu.name AS customer_name,
       MAX(ord.order_date) AS last_order_date
FROM Customers cu
JOIN Orders ord ON cu.customer_id = ord.customer_id
GROUP BY cu.name
HAVING DATEDIFF(CURDATE(), last_order_date) > 90;
