-- 코드를 입력하세요
-- as AVERAGE_DURATION
-- SELECT datediff(start_date, end_date) from CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- order by car_id desc;

SELECT car_id, round(avg(datediff(end_date, start_date)+1), 1) as AVERAGE_DURATION 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
having AVERAGE_DURATION >= 7
order by AVERAGE_DURATION desc, car_id desc;