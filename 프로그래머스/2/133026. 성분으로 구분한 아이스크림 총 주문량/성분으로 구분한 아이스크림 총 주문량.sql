select  b.ingredient_type, sum(a.total_order) as TOTAL_TYPE
from FIRST_HALF a, icecream_info b
where a.flavor = b.flavor
group by b.ingredient_type
order by a.total_order asc;
