select a.history_id
    , (a.daily_fee * (100 - NVL(b.DISCOUNT_RATE, 0))/100) * a.duration as fee
  from (select a.history_id
        , b.car_type
        , b.daily_fee
        , a.end_date - a.start_date + 1 as duration
        , case 
            when a.end_date - a.start_date  >= 90 
                then '90일 이상'
            when a.end_date - a.start_date >= 30 
                then '30일 이상'
            when a.end_date - a.start_date >= 7 
                then '7일 이상'
            else '7일 이하'
        end as DURATION_TYPE
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY a
    left outer join CAR_RENTAL_COMPANY_CAR b
      on a.car_id = b.car_id
    where b.car_type = '트럭') a
  left outer join CAR_RENTAL_COMPANY_DISCOUNT_PLAN b
    on a.car_type = b.car_type
   and a.DURATION_TYPE = b.DURATION_TYPE
order by fee desc, history_id desc;

