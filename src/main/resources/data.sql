-------------------------------------------------------------------------------------------------
-- Example data
-------------------------------------------------------------------------------------------------

---- Categories
INSERT INTO category (id, name)
VALUES (1, 'Horror');

INSERT INTO category (id, name)
VALUES (2, 'Fantasy');

INSERT INTO category (id, name)
VALUES (3, 'Science Fiction (Sci-Fi)');

INSERT INTO category (id, name)
VALUES (4, 'History');

INSERT INTO category (id, name)
VALUES (5, 'Criminal');

INSERT INTO category (id, name)
VALUES (6, 'Food');

INSERT INTO category (id, name)
VALUES (7, 'Poetry');

INSERT INTO category (id, name)
VALUES (8, 'Action and Adventure');

INSERT INTO category (id, name)
VALUES (9, 'Classics');

INSERT INTO category (id, name)
VALUES (10, 'Romance');

INSERT INTO category (id, name)
VALUES (11, 'Memoir');



---- Authors
INSERT INTO author (id, first_name, surname)
VALUES (1, 'Stephen', 'King');

INSERT INTO author (id, first_name, surname)
VALUES (2, 'Ta-Nehisi', 'Coates');

INSERT INTO author (id, first_name, surname)
VALUES (3, 'Margaret', 'Atwood');

INSERT INTO author (id, first_name, surname)
VALUES (4, 'David', 'McCullough');

INSERT INTO author (id, first_name, surname)
VALUES (5, 'Ronan', 'Farrow');

INSERT INTO author (id, first_name, surname)
VALUES (6, 'Julia', 'Child');

INSERT INTO author (id, first_name, surname)
VALUES (7, 'Sylvia', 'Plath');

INSERT INTO author (id, first_name, surname)
VALUES (8, 'Yann', 'Martel');

INSERT INTO author (id, first_name, surname)
VALUES (9, 'Toni', 'Morrison');

INSERT INTO author (id, first_name, surname)
VALUES (10, 'Sarah', 'Maclean');

INSERT INTO author (id, first_name, surname)
VALUES (11, 'Michelle', 'Obama');


---- Publishers
INSERT INTO publisher (id, name)
VALUES (1, 'Anchor');

INSERT INTO publisher (id, name)
VALUES (2, 'One World');

INSERT INTO publisher (id, name)
VALUES (3, 'Nan A. Talese');

INSERT INTO publisher (id, name)
VALUES (4, 'Simon & Schuster');

INSERT INTO publisher (id, name)
VALUES (5, 'Little, Brown and Company');

INSERT INTO publisher (id, name)
VALUES (6, 'Penguin Books');

INSERT INTO publisher (id, name)
VALUES (7, 'Harper Perennial Modern Classics');

INSERT INTO publisher (id, name)
VALUES (8, 'Mariner Books');

INSERT INTO publisher (id, name)
VALUES (9, 'Vintage');

INSERT INTO publisher (id, name)
VALUES (10, 'Avon');

INSERT INTO publisher (id, name)
VALUES (11, 'Viking Press');


-- Books
INSERT INTO book (id, title, year_of_release, description, category_id, author_id, publisher_id)
VALUES (
1,
'Carrie',
'2011',
'Stephen Kings legendary debut, about a teenage outcast and the revenge she enacts on her classmates.',
1,
1,
1
);

INSERT INTO book (id, title, year_of_release, description, category_id, author_id, publisher_id)
VALUES (
2,
'The Water Dancer',
'2019',
'Young Hiram Walker was born into bondage. When his mother was sold away, Hiram was robbed of all memory of her—but was gifted with a mysterious power.',
2,
2,
2
);

INSERT INTO book (id, title, year_of_release, description, category_id, author_id, publisher_id)
VALUES (
3,
'The Testaments',
'2019',
'The Testaments is a modern masterpiece, a powerful novel that can be read on its own or as a companion to Margaret Atwood’s classic, The Handmaid’s Tale.',
3,
3,
3
);

INSERT INTO book (id, title, year_of_release, description, category_id, author_id, publisher_id)
VALUES (
4,
'John Adams',
'2002',
'In this powerful, epic biography, David McCullough unfolds the adventurous life journey of John Adams, the brilliant, fiercely independent, often irascible',
4,
4,
4
 );

INSERT INTO book (id, title, year_of_release, description, category_id, author_id, publisher_id)
VALUES (
5,
'Catch and Kill: Lies, Spies, and a Conspiracy to Protect Predators',
'2019',
'In this instant New York Times bestselling account of violence and espionage, Pulitzer Prize-winning investigative reporter Ronan Farrow exposes serial abusers',
5,
5,
5
 );

INSERT INTO book (id, title, year_of_release, description, category_id, author_id, publisher_id)
VALUES (
6,
'Mastering the Art of French Cooking',
'2011',
'This isnt just any cookery book. It is Mastering the Art of French Cooking, first published in 1961.',
6,
6,
6
 );

INSERT INTO book (id, title, year_of_release, description, category_id, author_id, publisher_id)
VALUES (
7,
'The Collected Poems',
'2018',
'By the time of her death on 11, February 1963, Sylvia Plath had written a large bulk of poetry.',
7,
7,
7
);

INSERT INTO book (id, title, year_of_release, description, category_id, author_id, publisher_id)
VALUES (
8,
'Life of Pi',
'2003',
'The son of a zookeeper, Pi Patel has an encyclopedic knowledge of animal behavior and a fervent love of stories.',
8,
8,
8
);

INSERT INTO book (id, title, year_of_release, description, category_id, author_id, publisher_id)
VALUES (
9,
'Beloved',
'2004',
'Sethe, its protagonist, was born a slave and escaped to Ohio, but eighteen years later she is still not free. She has too many memories of Sweet Home, the beautiful farm where so many hideous things happened.',
9,
9,
9
);

INSERT INTO book (id, title, year_of_release, description, category_id, author_id, publisher_id)
VALUES (
10,
'Brazen and the Beast: The Bareknuckle Bastards Book II',
'2019',
'NewYork Times Bestselling Author Sarah MacLean returns with the next book in the Bareknuckle Bastards series about three brothers bound by a secret that they cannot escape—and the women who bring them to their knees.',
10,
10,
10
 );

INSERT INTO book (id, title, year_of_release, description, category_id, author_id, publisher_id)
VALUES (
11,
'Becoming',
'2018',
'In a life filled with meaning and accomplishment, Michelle Obama has emerged as one of the most iconic and compelling women of our era.',
11,
11,
11
 );

 -- Readers
INSERT INTO reader (id, first_name, surname, phone_number, email, address, province, postal_code)
VALUES (
 1,
 'John',
 'Smith',
 '678846543',
 'J.smith@mail.com',
 'example',
 'example',
 '62-800'
 );

INSERT INTO reader (id, first_name, surname, phone_number, email, address, province, postal_code)
VALUES (
 2,
 'Harry',
 'Mons',
 '126556466',
 'harry.mons@mail.com',
 'example2',
 'example2',
 '63-220'
);

INSERT INTO reader (id, first_name, surname, phone_number, email, address, province, postal_code)
VALUES (
 3,
 'Emilia',
 'Simons',
 '554456565',
 'emilly.Simons@mail.com',
 'example3',
 'example3',
 '33-244'
);

---- Lends
INSERT INTO lend (id, lend_date, suggested_return_date, return_date, book_id, reader_id)
VALUES (
1,
'2021-10-28',
'2021-11-04',
'2021-11-01',
1,
1);

INSERT INTO lend (id, lend_date, suggested_return_date, return_date, book_id, reader_id)
VALUES (
2,
'2021-11-04',
'2021-11-25',
null,
2,
2
);


