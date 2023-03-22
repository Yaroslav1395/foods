create table if not exists users
(
    id       bigserial primary key,
    name     varchar(255) not null,
    username varchar(255) not null unique,
    password varchar(255) not null
);

create table if not exists users_roles
(
    user_id bigint       not null,
    role    varchar(255) not null,
    primary key (user_id, role),
    constraint fk_users_roles_users foreign key (user_id) references users (id) on delete cascade on update no action
);

create table if not exists restaurant(
    id bigserial primary key,
    name varchar(255) not null,
    description varchar(255) not null
);

create table if not exists dish(
    id bigserial primary key,
    name varchar(255) not null,
    price bigint not null
);

create table if not exists type(
    dish_id bigint not null,
    type varchar(255) not null,
    primary key(dish_id, type),
    constraint fk_dish_type foreign key (dish_id) references dish (id) on delete cascade on update cascade
);

create table if not exists orders(
    id bigserial primary key,
    user_id bigint not null,
    dish_id bigint not null,
    date_time timestamp not null,
    constraint FK_user_order_user foreign key (user_id) references users (id) on delete cascade on update cascade,
    constraint FK_dish_order_dish foreign key (dish_id) references dish (id) on delete cascade on update cascade
);

create table if not exists menu(
    id bigserial primary key,
    restaurant_id bigint not null,
    dish_id bigint not null,
    constraint FK_restaurant_menu foreign key (restaurant_id) references restaurant(id) on delete cascade on update cascade,
    constraint FK_dish_menu foreign key (dish_id) references dish(id) on delete cascade on update cascade
);
