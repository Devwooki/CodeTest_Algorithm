-- 코드를 입력하세요
# SELECT ugu.user_id as '회원 ID', ugu.nickname as '닉네임', sum(ugb.price) as '총거래금액' 
# from USED_GOODS_BOARD ugb join USED_GOODS_USER ugu 
# on ugb.writer_id = ugu.user_id
# having '총거래금액' >= 700000;

# SELECT ugu.user_id as '회원 ID', ugu.nickname as '닉네임', sum(ugb.price) as '총거래금액' 
# from USED_GOODS_BOARD ugb left join USED_GOODS_USER ugu 
# on ugb.writer_id = ugu.user_id;

select ugu.user_id as '회원 ID', ugu.nickname as '닉네임', sum(ugb.price) as '총거래금액' 
from USED_GOODS_BOARD ugb left join USED_GOODS_USER ugu  
on ugb.writer_id = ugu.user_id
where ugb.status like 'DONE'
group by ugu.user_id
having sum(ugb.price) >= 700000
order by sum(ugb.price) asc;