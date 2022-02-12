
create table plants (id bigint not null AUTO_INCREMENT, description varchar(255), image varchar(255), name varchar(255), primary key (id));

create table users (id bigint not null AUTO_INCREMENT, name varchar(255), role varchar(255), primary key (id));

create table plants_users (user_id bigint not null, plant_id bigint not null, primary key (user_id, plant_id)
CONSTRAINT FK_movie 
      FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT FK_category 
      FOREIGN KEY (category_id) REFERENCES plants(id));



