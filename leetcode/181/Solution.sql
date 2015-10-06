# Write your MySQL query statement below
SELECT emp.Name
FROM Employee emp INNER JOIN Employee man
WHERE emp.ManagerId  = man.Id AND emp.Salary > man.Salary;