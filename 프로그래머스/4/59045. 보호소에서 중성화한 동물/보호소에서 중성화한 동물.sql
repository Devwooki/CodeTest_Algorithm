-- 코드를 입력하세요
-- ANIMAL_INS, ANIMAL_OUTS
-- 들어올 때 중성화 아니지만 나갈 때 중성화
-- 중성화 키워드 Spayed, Neutered
SELECT
    a.animal_id, a.animal_type, a.name
   from ANIMAL_INS a
    , animal_outs b
 where a.animal_id = b.animal_id
   and a.SEX_UPON_INTAKE like '%Intact%'
   and (b.SEX_UPON_OUTCOME like '%Spayed%'
        or b.SEX_UPON_OUTCOME like '%Neutered%')
order by a.animal_id;
 