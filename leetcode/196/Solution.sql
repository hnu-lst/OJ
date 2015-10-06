# Write your MySQL query statement below
#DELETE FROM Person
#WHERE Email IN (SELECT Email FROM Person GROUP BY Email HAVING COUNT(Email) > 1 )
#AND Id NOT IN ((SELECT MIN(Id) FROM Person GROUP BY Email HAVING COUNT(Email) > 1 ));
DELETE e2
FROM Person e JOIN Person e2 
ON e2.Email = e.Email
WHERE e2.ID > e.ID;