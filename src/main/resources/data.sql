CREATE TABLE IF NOT EXISTS Hero (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    race VARCHAR(50) NOT NULL,
    primaryAttribute VARCHAR(50) NOT NULL,
    description VARCHAR(255) NOT NULL,
    movementSpeed INT NOT NULL
);

INSERT INTO Hero (id, name, race, primaryAttribute, description, movementSpeed)
VALUES (1, 'Артас', 'UNDEAD', 'STRENGTH', 'Ледяной король', 300),
       (2, 'Тралл', 'ORC', 'AGILITY', 'Вождь орков', 310),
       (3, 'Джайна', 'HUMAN', 'INTELLIGENCE', 'Магистр Кирин-Тора', 290),
       (4, 'Иллидан', 'NIGHT_ELF', 'AGILITY', 'Повелитель миров', 310),
       (5, 'Маннорот', 'DEMON', 'STRENGTH', 'Главный генерал Легиона', 290),
       (6, 'Архимонд', 'DEMON', 'STRENGTH', 'Главный приказчик Легиона', 290);
