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