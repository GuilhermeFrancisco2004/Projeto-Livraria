# 📚 Livraria Online - Projeto Full Stack

Projeto completo de uma livraria online desenvolvido com React (Frontend) e Spring Boot (Backend).

## 🚀 Funcionalidades

### Frontend React
- ✅ Catálogo de livros com filtros e busca
- ✅ Página de detalhes do livro
- ✅ Carrinho de compras
- ✅ Checkout e finalização de pedido
- ✅ Histórico de pedidos
- ✅ Autenticação de usuário
- ✅ Interface responsiva

### Backend Spring Boot
- ✅ API REST completa
- ✅ Gerenciamento de livros
- ✅ Sistema de carrinho de compras
- ✅ Processamento de pedidos
- ✅ Autenticação de usuários
- ✅ Banco de dados MySQL

## 📋 Requisitos

- **Node.js** v16+ e npm
- **Java** 17+
- **Maven** 3.8+
- **MySQL** 8.0+
- **Git** (opcional)

## 🔧 Instalação e Setup

### 1. Backend (Java/Spring Boot)

#### Configurar Banco de Dados

Crie um banco de dados MySQL:

```sql
CREATE DATABASE livraria_db;
USE livraria_db;
```

#### Instalar Maven (se necessário)

```bash
# Windows (com choco)
choco install maven

# Ou baixar manualmente em: https://maven.apache.org/
```

#### Build e Execução

```bash
cd C:\Users\Admin\ProjetoLivrariaMaven

# Compilar e instalar dependências
mvn clean install

# Executar a aplicação
mvn spring-boot:run
```

O backend estará disponível em: **http://localhost:8080**

#### Populando o Banco com Dados de Teste

```bash
# Conecte ao MySQL e execute:
mysql -u root -p livraria_db < populateDatabase.sql

# Ou execute manualmente no MySQL Workbench/phpMyAdmin:
# Copie e cole o conteúdo de populateDatabase.sql
```

### 2. Frontend (React)

```bash
cd C:\Users\Admin\Guilherme\Rocketnotes-Frontend

# Instalar dependências
npm install

# Iniciar servidor de desenvolvimento
npm run dev
```

O frontend estará disponível em: **http://localhost:5173**

## 📱 Como Usar

### Primeira Execução

1. Certifique-se de que o backend está rodando (`http://localhost:8080`)
2. Inicie o frontend (`npm run dev`)
3. O navegador abrirá em `http://localhost:5173`
4. Faça login com suas credenciais ou crie uma nova conta
5. Navegue pelo catálogo de livros
6. Adicione livros ao carrinho
7. Finalize a compra

### Fluxo de Compra

1. **Catálogo**: Explore o catálogo de livros
   - Filtre por categoria
   - Busque por título ou autor
   - Visualize detalhes do livro

2. **Carrinho**: Adicione livros ao carrinho
   - Aumente ou diminua quantidade
   - Remova itens indesejados
   - Veja o total

3. **Checkout**: Forneça endereço de entrega

4. **Meus Pedidos**: Acompanhe o status dos pedidos

## 📚 Estrutura do Projeto

### Backend

```
ProjetoLivrariaMaven/
├── src/main/java/org/livraria/
│   ├── controller/        # Controladores REST
│   ├── service/           # Lógica de negócio
│   ├── repository/        # Acesso a dados
│   ├── model/             # Entidades
│   ├── dto/               # Data Transfer Objects
│   └── LivrariaMavenApplication.java
├── src/main/resources/
│   └── application.properties
└── pom.xml
```

### Frontend

```
Rocketnotes-Frontend/
├── src/
│   ├── components/        # Componentes reutilizáveis
│   ├── pages/             # Páginas da aplicação
│   ├── services/          # Comunicação com API
│   ├── routes/            # Definição de rotas
│   ├── styles/            # Estilos globais
│   ├── hooks/             # Hooks customizados
│   └── main.jsx
└── package.json
```

## 🔌 API Endpoints

### Livros
- `GET /api/livros` - Listar todos os livros
- `GET /api/livros/{id}` - Obter detalhes de um livro
- `GET /api/livros/categoria/{categoria}` - Filtrar por categoria
- `GET /api/livros/buscar/titulo?titulo={titulo}` - Buscar por título
- `POST /api/livros` - Criar novo livro (admin)

### Carrinho
- `GET /api/carrinho/{usuarioId}` - Obter carrinho
- `POST /api/carrinho/{usuarioId}/adicionar` - Adicionar item
- `PUT /api/carrinho/{usuarioId}/item/{itemId}` - Atualizar quantidade
- `DELETE /api/carrinho/{usuarioId}/item/{itemId}` - Remover item
- `DELETE /api/carrinho/{usuarioId}/limpar` - Limpar carrinho

### Pedidos
- `POST /api/pedidos/{usuarioId}` - Criar pedido
- `GET /api/pedidos/{usuarioId}` - Listar pedidos do usuário
- `GET /api/pedidos/detalhe/{pedidoId}` - Detalhes do pedido

### Usuários
- `POST /api/usuarios/obter-ou-criar` - Criar ou obter usuário
- `GET /api/usuarios/{id}` - Obter dados do usuário

## ⚙️ Configurações

### Backend (application.properties)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/livraria_db
spring.datasource.username=root
spring.datasource.password=123456789
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

### Frontend (api.js)

```javascript
export const api = axios.create({
    baseURL: "http://localhost:8080/api",
});
```

## 🐛 Troubleshooting

### Conexão com banco de dados

Se tiver erro de conexão:
- Certifique-se de que MySQL está rodando
- Verifique usuário e senha em `application.properties`
- Verifique se o banco `livraria_db` existe

### Frontend não conecta ao backend

- Verifique se o backend está rodando em `http://localhost:8080`
- Verifique CORS habilitado no backend
- Limpe o cache do navegador

### Porta já em uso

```bash
# Mudar porta do backend
# Edite application.properties: server.port=8081

# Para o React, use:
npm run dev -- --port 5174
```

## 📝 Exemplo de Dados

Alguns livros já estão pré-carregados no banco:
- Harry Potter e a Pedra Filosofal
- O Senhor dos Anéis
- 1984
- Dom Casmurro
- Clean Code
- E mais...

## 🎨 Temas e Estilo

O projeto usa Styled Components e um tema personalizado com cores:
- Primária: #FF6B6B (vermelho)
- Secundária: #F4EDE8 (bege)
- Texto: #312E38 (escuro)

## 📄 Licença

Este projeto é de código aberto e disponível sob a licença MIT.

## 👨‍💻 Autor

Desenvolvido como projeto de livraria online full-stack.

---

**Dúvidas?** Verifique os logs no console do navegador e do servidor para mais detalhes.
