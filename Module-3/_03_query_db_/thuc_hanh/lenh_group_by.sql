SELECT 
    status
FROM
    orders
GROUP BY status;

SELECT 
    status, COUNT(*) 'So luong status'
FROM
    orders
GROUP BY status
order by status;

SELECT 
    status, SUM(quantityOrdered * priceEach) amount
FROM
    orders
        INNER JOIN
    orderdetails ON orders.ordernumber = orderdetails.ordernumber
GROUP BY status
ORDER BY status;

SELECT 
    orderNumber, SUM(quantityOrdered * priceEach) total
FROM
    orderdetails
GROUP BY orderNumber;
--

SELECT 
    YEAR(orderDate) year, SUM(quantityOrdered * priceEach) total
FROM
    orders
        INNER JOIN
    orderdetails ON orders.orderNumber = orderdetails.orderNumber
WHERE
    status = 'shipped'
GROUP BY year
HAVING year > 2003;

