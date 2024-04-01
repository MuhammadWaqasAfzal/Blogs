# Spring Boot Blogging Platform

This project is a blogging platform built with Spring Boot, allowing users to sign up, sign in, write blogs, and like or dislike blogs written by others. It's designed to provide a simple yet effective way for users to share their thoughts and interact with other writers through likes, dislikes, and comments.

## Features

- **User Authentication**: Sign up and sign in functionality for users.
- **Blog Management**: Users can create and delete their blogs.
- **Interactions**: Users can like or dislike blogs.
- **Comments** (planned): Users will be able to comment on blogs in future versions.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java JDK 11 or later
- Maven 3.6 or later
- MySQL 8.0 or later

### Installing

1. **Clone the Repository**

    ```bash
    git clone git@github.com:MuhammadWaqasAfzal/Blogs.git
    ```

2. **Configure MySQL**

    - Create a new database in MySQL for the project.
    - Update `src/main/resources/application.properties` with your database details:

        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
        spring.datasource.username=your_username
        spring.datasource.password=your_password
        ```

3. **Run the Application**

   Navigate to the project directory and run the application using Maven:

    ```bash
    cd your-blog-project
    mvn spring-boot:run
    ```

   The application should be accessible at `http://localhost:8080`.

## API Endpoints

(Here, list some of the core API endpoints and their purposes, for example:)

- `POST /api/users/signUp`: Register a new user.
- `POST /api/users/signIn`: Authenticate a user.
- `POST /api/blogs/create`: Create a new blog post.
- `GET /api/blogs/getAll`: Retrieve all blogs.
- `POST /api/blogs/getUserBlog`: Retrieve blog of specific user.
- `POST /api/reaction/getReactionOfBlog`: Get Reactions on a blog.

## Contributing

We welcome contributions to this project! Please refer to the `CONTRIBUTING.md` file for more details on how to contribute.


