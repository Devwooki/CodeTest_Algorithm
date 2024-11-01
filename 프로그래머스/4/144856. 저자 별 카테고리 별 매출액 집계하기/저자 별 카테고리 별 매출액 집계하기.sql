select a.author_id, c.author_name, a.category, sum(b.sales * a.price)
  from book a
 inner join (SELECT book_id, sales
                from book_sales
                where to_char(sales_date, 'YYYYMM') = '202201'
            ) b
    on a.book_id = b.book_id
 inner join author c
    on a.author_id = c.author_id
group by a.author_id, c.author_name, a.category
order by 1 asc, 3 desc;
