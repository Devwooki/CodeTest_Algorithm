--gender는 0 : 남자, 1 : 여자

-- 1 2021년에 가입한 전체 회원 수

--2 2021년에 가입한 사람중 상품을 구매한 회원 수
select 
    to_char(sales_date, 'YYYY') as year
    , to_number(to_char(sales_date, 'MM'))as month
    , count(distinct(user_id)) as purchased_users /*한 아이디로 여러번 살 수 있으므로*/
    , round(count(distinct(user_id)) / (select count(user_id)
                                  from user_info
                                 where to_char(joined, 'YYYY') = '2021')
            , 1 ) as PUCHASED_RATIO
from online_sale
where user_id in (select user_id
                    from user_info
                    where to_char(joined, 'YYYY') = '2021'
                 )
group by to_char(sales_date, 'YYYY'), to_char(sales_date, 'MM')

order by to_char(sales_date, 'YYYY') asc, to_char(sales_date, 'MM') asc