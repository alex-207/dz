-- Создайте процедуру, которая принимает кол-во сек и формат их в кол-во дней часов. Пример: 123456 ->'1 days 10 hours 17 minutes 36 seconds '
DELIMITER //
    CREATE PROCEDURE dz6_1(num INT)
        BEGIN
            DECLARE days INT DEFAULT 0;
            DECLARE hours INT DEFAULT 0;
            DECLARE minutes INT DEFAULT 0;
            DECLARE seconds INT DEFAULT 0;
            DECLARE res VARCHAR(50) DEFAULT 0;
            
            SET days = floor(num/60/60/24);
            SET hours = floor(num/60/60%24);
            SET minutes = floor(num/60%60);
            SET seconds = floor(num%60);
            SET res = concat(days, ' days ', hours, ' hours ', minutes, ' minutes ', seconds, ' seconds ');
            SELECT res;
        END;
        
CALL dz6_1(323253);  -- вызоа процедуры
// DELIMITER ;


-- -----------------------------------------------------


-- Создайте функцию, которая выводит только четные числа от 1 до 10. Пример: 2,4,6,8,10
DELIMITER //
    CREATE FUNCTION dz6_2()
        RETURNS VARCHAR(50)  -- тип return
        DETERMINISTIC
        BEGIN
	    DECLARE num INT DEFAULT 4;
	    DECLARE res VARCHAR(50) DEFAULT '2';
	    WHILE num <= 10 DO
	        SET res = concat(res, ',', num);
	        SET num=num+2;
	    END WHILE;
	    RETURN res;
        END;
        
SELECT dz6_2();  -- вызов функции
// DELIMITER ;
