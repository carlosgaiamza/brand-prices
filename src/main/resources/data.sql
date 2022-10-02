drop table if exists price_list_item CASCADE;
drop table if exists brand CASCADE;
drop table if exists price_list CASCADE;

create table brand (id bigint not null, name varchar(255), primary key (id));

create table price_list (id bigint not null, primary key (id));

create table price_list_item (
    id bigint not null,
    end_date timestamp,
    amount numeric(19,2),
    currency varchar(255),
    priority integer not null,
    product_id bigint,
    start_date timestamp,
    brand_id bigint,
    price_list_id bigint,
    primary key (id)
);

alter table price_list_item
    add constraint FK6_price_list_item_brand
        foreign key (brand_id)
            references brand;

alter table price_list_item
    add constraint FK_price_list_item_price_list
        foreign key (price_list_id)
            references price_list;

INSERT INTO price_list (id) VALUES (1);
INSERT INTO price_list (id) VALUES (2);
INSERT INTO price_list (id) VALUES (3);
INSERT INTO price_list (id) VALUES (4);

INSERT INTO brand (id, name) VALUES (1, 'ZARA');

INSERT INTO price_list_item (id , brand_id, start_date, end_date, price_list_id, product_id, priority, amount, currency)
    VALUES (1, 1, '2020-06-14T00:00:00', '2020-12-31T23:59:59', 1, 35455, 0, 35.50, 'EUR');

INSERT INTO price_list_item  (id , brand_id, start_date, end_date, price_list_id, product_id, priority, amount, currency)
    VALUES (2 ,1, '2020-06-14T15:00:00', '2020-06-14T18:30:00', 2, 35455, 1, 25.45, 'EUR');

INSERT INTO price_list_item  (id , brand_id, start_date, end_date, price_list_id, product_id, priority, amount, currency)
    VALUES (3 ,1, '2020-06-15T00:00:00', '2020-06-15T11:00:00', 3, 35455, 1, 30.50, 'EUR');

INSERT INTO price_list_item  (id , brand_id, start_date, end_date, price_list_id, product_id, priority, amount, currency)
    VALUES (4 ,1, '2020-06-15T16:00:00', '2020-12-31T23:59:59', 4, 35455, 1, 38.95, 'EUR');
