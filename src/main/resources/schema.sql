CREATE TABLE IF NOT EXISTS MESSAGES(
    id varchar(60) default RANDOM_UUID() primary key,
    text LONGVARCHAR not null
);