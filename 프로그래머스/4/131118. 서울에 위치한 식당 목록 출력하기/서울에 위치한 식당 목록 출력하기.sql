--식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수
-- SELECT a.rest_id
--     , a.rest_name
--     , a.food_type
--     , a.FAVORITES
--     , a.address
--     , (select round(avg(b.REVIEW_SCORE),2) 
--          from REST_REVIEW b 
--         where b.rest_id = a.rest_id
--       ) as score
--   from REST_INFO a
--  where a.address like '서울%'
--  order by score desc, a.FAVORITES desc;

-- SELECT i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS, ROUND(AVG(r.REVIEW_SCORE), 2) AS "SCORE"
-- FROM REST_INFO i
-- INNER JOIN REST_REVIEW r
-- ON i.REST_ID = r.REST_ID 
-- WHERE i.ADDRESS LIKE '서울%'
-- GROUP BY i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS
-- ORDER BY ROUND(AVG(r.REVIEW_SCORE), 2) DESC, FAVORITES DESC;


SELECT a.rest_id
    , a.rest_name
    , a.food_type
    , a.FAVORITES
    , a.address
    , round(avg(b.REVIEW_SCORE),2) as score
  from REST_INFO a
    , REST_REVIEW b
 where a.rest_id = b.rest_id
   and a.address like '서울%'
 group by a.rest_id
    , a.rest_name
    , a.food_type
    , a.FAVORITES
    , a.address
 order by score desc, a.FAVORITES desc;