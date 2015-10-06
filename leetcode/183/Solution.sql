# Write your MySQL query statement below
SELECT Customers.Name
FROM Customersa
WHERE Customers.Id NOT IN (SELECT CustomerId FROM Orders);
