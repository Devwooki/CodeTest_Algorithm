
select a.hour, nvl(b.cnt,0)
  from (select level-1 as hour
          from dual
        connect by level <= 24) a
  left outer join (select to_number(to_char(datetime, 'HH24')) as hour
                        , count(*) as cnt
                      from ANIMAL_OUTS
                      group by to_char(datetime, 'HH24')
                ) b
  on a.hour = b.hour
order by 1;
