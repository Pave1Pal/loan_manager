create table customers
(
    id                         bigint not null
        constraint customers_pkey
            primary key,
    first_name                 varchar(255),
    middle_name                varchar(255),
    surname                    varchar(255),
    job_finish                 date,
    job_organization           varchar(255),
    job_position               varchar(255),
    job_start                  date,
    job_is_work                boolean,
    address                    varchar(255),
    passport_code              varchar(255),
    passport_department_code   varchar(255),
    family_status              varchar(255),
    passport_place_of_issuance varchar(255),
    phone_number               varchar(255)
);

alter table customers
    owner to postgres;

create table credit_applications
(
    id              bigint  not null
        constraint credit_applications_pkey
            primary key,
    accepted        boolean not null,
    money_currency  varchar(255),
    money_decimal   integer,
    money_integer   bigint,
    creation_date   date,
    days            integer,
    expiration_date date,
    customer_id     bigint
        constraint fk_credit_applications_customer_id
            references customers
);

alter table credit_applications
    owner to postgres;

create table credit_contracts
(
    id                    bigint  not null
        constraint credit_contracts_pkey
            primary key,
    accepted_by_user      boolean not null,
    sing_in_date          date,
    credit_application_id bigint
        constraint fk_credit_contracts_credit_application_id
            references credit_applications,
    customer_id           bigint
        constraint fk_credit_contracts_credit_customer_id
            references customers
);

alter table credit_contracts
    owner to postgres;