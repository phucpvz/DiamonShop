SELECT
p.id as id_product
, p.id_category
, p.sizes
, p.name
, p.price
, p.sale
, p.title
, p.highlight
, p.new_product
, p.details
, c.id as id_color
, c.name as name_color
, c.code as code_color
, c.img
, p.created_at
, p.updated_at
FROM
products AS p
INNER JOIN
colors AS c
ON p.id = c.id_product