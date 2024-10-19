-- 코드를 작성해주세요
with recursive hic as(
    select id
        , PARENT_ID
        , 1 as gen
      from ECOLI_DATA
     where parent_id is null
    union all
    
    select a.id
        , a.PARENT_ID
        , hic.gen + 1 as gen
      from ECOLI_DATA a
        , hic hic
     where a.parent_id = hic.id
)
select id from hic
where gen = 3
order by id;