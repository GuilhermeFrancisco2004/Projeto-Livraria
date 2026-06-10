-- Script para popular o banco de dados com livros de exemplo

USE livraria_db;

-- Inserir livros de exemplo
INSERT INTO livros (titulo, autor, preco, descricao, estoque, categoria, ano_publicacao, isbn) VALUES
('Harry Potter e a Pedra Filosofal', 'J.K. Rowling', 49.90, 'O primeiro livro da série Harry Potter que acompanha um jovem bruxo em sua jornada na Escola de Magia e Bruxaria de Hogwarts.', 20, 'Fantasia', 1998, '978-8532530787'),
('O Senhor dos Anéis', 'J.R.R. Tolkien', 89.90, 'Uma épica de fantasia que segue o hobbit Frodo em sua jornada para destruir um anel poderoso.', 15, 'Fantasia', 1954, '978-8533613370'),
('1984', 'George Orwell', 34.90, 'Um romance distópico que explora um regime totalitário e suas implicações.', 25, 'Ficção', 1949, '978-8506080949'),
('Dom Casmurro', 'Machado de Assis', 29.90, 'Um clássico da literatura brasileira que conta a história de um romance conturbado.', 30, 'Romance', 1899, '978-8535914009'),
('O Pequeno Príncipe', 'Antoine de Saint-Exupéry', 39.90, 'Uma fábula tocante sobre um jovem príncipe que viaja por diferentes planetas.', 35, 'Ficção', 1943, '978-8532523136'),
('Cem Anos de Solidão', 'Gabriel García Márquez', 54.90, 'Uma obra-prima do realismo mágico que narra a história da família Buendía.', 18, 'Ficção', 1967, '978-8501045863'),
('Clean Code', 'Robert C. Martin', 79.90, 'Um guia essencial para escrever código limpo e profissional.', 40, 'Desenvolvimento', 2008, '978-8577807599'),
('Design Patterns', 'Gang of Four', 89.90, 'O livro fundamental sobre padrões de design em programação.', 22, 'Tecnologia', 1994, '978-8588639690'),
('A Revolução Francesa', 'Simon Schama', 74.90, 'Uma análise profunda dos eventos e personagens da Revolução Francesa.', 12, 'Não-Ficção', 1989, '978-8535914016'),
('O Hobbit', 'J.R.R. Tolkien', 49.90, 'A préquela de O Senhor dos Anéis que segue Bilbo Bolseiro em sua aventura.', 28, 'Fantasia', 1937, '978-8533613387'),
('Orgulho e Preconceito', 'Jane Austen', 44.90, 'Um romance clássico sobre amor, sociedade e relacionamentos na Inglaterra do século XVIII.', 32, 'Romance', 1813, '978-8535914023'),
('O Crime e o Castigo', 'Fiódor Dostoiévski', 64.90, 'Uma exploração profunda da psicologia humana e moralidade.', 16, 'Ficção', 1866, '978-8535914030'),
('Python para Análise de Dados', 'Wes McKinney', 89.90, 'Um guia prático para análise de dados com Python.', 45, 'Tecnologia', 2012, '978-8575257648'),
('O Alienista', 'Machado de Assis', 32.90, 'Um conto que mistura ficção científica com sátira social.', 20, 'Ficção', 1882, '978-8535914047'),
('Beloved', 'Toni Morrison', 59.90, 'Uma obra sobre as consequências do escravismo na vida de uma mulher.', 14, 'Ficção', 1987, '978-8535914054');
