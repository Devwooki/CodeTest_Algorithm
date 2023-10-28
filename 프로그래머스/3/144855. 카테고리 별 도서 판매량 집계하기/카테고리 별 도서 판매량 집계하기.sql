-- 코드를 입력하세요
SELECT b.category, sum(a.sales) from BOOK_SALES a
join book b
on b.book_id = a.book_id
where sales_date like '2022-01%'
group by b.category
order by b.category asc;

# select *, sum(temp) from book a
# join (SELECT book_id, sum(sales) as temp from BOOK_SALES
# where sales_date like '2022-01%'
# group by book_id) b
# on a.book_id = b.book_id
# group by category;