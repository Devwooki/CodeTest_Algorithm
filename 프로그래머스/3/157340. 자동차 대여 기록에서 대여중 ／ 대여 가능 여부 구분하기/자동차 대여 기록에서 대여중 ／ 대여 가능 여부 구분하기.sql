-- 코드를 입력하세요
# SELECT CAR_ID, 
#     case 
#         when CAR_ID in (select CAR_ID 
#                         from CAR_RENTAL_COMPANY_RENTAL_HISTORY
#                         where '2022-10-16' between start_date and end_date)  then "대여중"
#         else "대여가능"
#         end as availability;v
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# order by CAR_ID desc;

select car_id,
    case
        when car_id in (SELECT CAR_ID
                        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                        WHERE '2022-10-16' 
                            BETWEEN DATE_FORMAT(START_DATE, '%Y-%m-%d') 
                            AND DATE_FORMAT(END_DATE, '%Y-%m-%d')) 
        then "대여중"
        else "대여 가능"
        end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc;
