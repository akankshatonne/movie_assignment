create table if not exists public.director
(
    id          varchar(255) not null
    primary key,
    name        varchar(255),
    nationality varchar(255)
    );

alter table public.director
    owner to postgres;

create table if not exists public.genre
(
    id   varchar(255) not null
    primary key,
    name varchar(255)
    );

alter table public.genre
    owner to postgres;

create table if not exists public.movie
(
    id           varchar(255) not null
    primary key,
    release_year integer,
    title        varchar(255),
    release_date date
    );

alter table public.movie
    owner to postgres;

create table if not exists public.movie_director
(
    director_id varchar(255) not null
    constraint fkgn1rkfh7ioiax467kc9dcrcrr
    references public.director,
    movie_id    varchar(255) not null
    constraint fkbay4b2v2db4yfaww2oocpld9m
    references public.movie
    );

alter table public.movie_director
    owner to postgres;

create table if not exists public.movie_genre
(
    genre_id varchar(255) not null
    constraint fk86p3roa187k12avqfl28klp1q
    references public.genre,
    movie_id varchar(255) not null
    constraint fkp6vjabv2e2435at1hnuxg64yv
    references public.movie
    );

alter table public.movie_genre
    owner to postgres;





INSERT INTO director (id, name, nationality) VALUES
                                                 ('D1', 'Christopher Nolan', 'British-American'),
                                                 ('D2', 'Steven Spielberg', 'American'),
                                                 ('D3', 'Quentin Tarantino', 'American');


INSERT INTO genre (id, name) VALUES
                                 ('G1', 'Action'),
                                 ('G2', 'Drama'),
                                 ('G3', 'Sci-Fi'),
                                 ('G4', 'Thriller');


INSERT INTO movie (id, release_year, title) VALUES
                                                ('M1', 1994, 'Pulp Fiction'),
                                                ('M2', 1998, 'Saving Private Ryan'),
                                                ('M3', 2010, 'Inception'),
                                                ('M4', 1993, 'Schindlers List');

INSERT INTO movie_director (director_id, movie_id) VALUES
                                                       ('D1', 'M3'),  -- Inception directed by Christopher Nolan
                                                       ('D2', 'M2'),  -- Saving Private Ryan directed by Steven Spielberg
                                                       ('D2', 'M4'),  -- Schindler's List directed by Steven Spielberg
                                                       ('D3', 'M1');  -- Pulp Fiction directed by Quentin Tarantino


INSERT INTO movie_genre (genre_id, movie_id) VALUES
                                                 ('G1', 'M1'),  -- Pulp Fiction genre Action
                                                 ('G2', 'M1'),  -- Pulp Fiction genre Drama
                                                 ('G2', 'M2'),  -- Saving Private Ryan genre Drama
                                                 ('G4', 'M3'),  -- Inception genre Thriller
                                                 ('G3', 'M3'),  -- Inception genre Sci-Fi
                                                 ('G2', 'M4');  -- Schindler's List genre Drama