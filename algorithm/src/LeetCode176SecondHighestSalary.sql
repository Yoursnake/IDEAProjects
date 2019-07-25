/*
Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+

For example, given the above Employee table, the query should
return 200 as the second highest salary. If there is no second
highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
 */

-- Create table If Not Exists Employee (Id int, Salary int);
-- Truncate table Employee;
-- insert into Employee (Id, Salary) values ('1', '100');
-- insert into Employee (Id, Salary) values ('2', '200');
-- insert into Employee (Id, Salary) values ('3', '300');

-- 方法1
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary)
                FROM Employee);

-- 方法2
SELECT (SELECT Salary
        FROM Employee
        GROUP BY Salary       -- 过滤掉相同薪水
        ORDER BY Salary DESC  -- 逆序排序
        LIMIT 1, 1)           -- 取第1-1位
  as SecondHighestSalary;

-- 方法3（其实和方法2一样）
SELECT (SELECT DISTINCT Salary  -- 过滤掉相同薪水
        FROM Employee
        ORDER BY Salary DESC
        LIMIT 1, 1)
  as SecondHighestSalary;




