CREATE TABLE public.manager
(
    id    uuid    not null
        constraint manager_pk
        primary key,
    name  varchar not null,
    phone varchar not null
);


CREATE TABLE public.sales
(
    model      varchar not null,
    price      integer not null,
    manager_id uuid    not null
        constraint sales_manager_id_fk
        references manager,
    date       date    not null,
    count      integer
);

