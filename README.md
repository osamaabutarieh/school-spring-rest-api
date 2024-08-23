# School API

## Overview

The **School API** is a RESTful web service designed to manage and provide information about  students, employee, and courses. This API allows for easy integration into educational platforms or school management systems.

## Features

- **Student Management**: Add, update, and delete student records.
- **Employee Management**: Add, update, and delete employee records.
- **Course Management**: Create, update, and manage courses.

## Getting Started

### Prerequisites

- **Java** (or the language/framework you’re using)
- **Spring** (or your chosen web framework)
- **Postman**
- **MySQL** (or any supported database)
- **Git** (for version control)

### Installation

1. **Clone the repository:**
    ```bash
    git clone https://github.com/osamaabutarieh/school-spring-rest-api.git
    cd school-api
    ```

2. **Install dependencies:**
    - go to pom.xml and refresh maven to install all dependencies.

3. **Set up the database:**
    - You will find the script.sql in src/main/resources
    - open this file in MySQL Workbench and run it 

4. **Run the Application:**
   - You can run it using IDE or using terminal 
    ```bash
    mvn spring-boot:run
    ```

5. **Access the API:**
    - The API can be accessed at `http://localhost:8080/api/`.

### API Endpoints

- **Students**
  - `GET /api/students/` - List all students
  - `POST /api/student/` - Create a new student
  - `GET /api/student/{studentId}` - Retrieve a student by ID
  - `PUT /api/student` - Update a student by ID
  - `DELETE /api/student/{id}/` - Delete a student by ID

- **Employee**
  - `GET /api/employees` - List all teachers
  - `POST /api/employee` - Create a new teacher
  - `GET /api/employee/{id}/` - Retrieve a teacher by ID
  - `PUT /api/employee/{id}/` - Update a teacher by ID
  - `DELETE /api/employee/{id}/` - Delete a teacher by ID

- **Courses**
  - `GET /api/courses/` - List all courses
  - `POST /api/course/` - Create a new course
  - `GET /api/course/{id}/` - Retrieve a course by ID
  - `PUT /api/course/{id}/` - Update a course by ID
  - `DELETE /api/course/{id}/` - Delete a course by ID

Note that I made this rest api and appliyed security (Basic Auth) into it so there is three Roles: 
 - EMPLOYEE
 - MANAGER
 - ADMIN
 - STUDENT


And every roles can access api but: 
 - STUDENT => can GET courses/employees/students
 - EMPLOYEE => can GET courses/employees/students
 - MANAGER => can GET/POST/PUT employees/students/courses
 - ADMIN => can DELETE employee/student/courses and GET/POST/PUT (can doing everything)



Also, there is three users: 
 - john => is a employee
 - mary => is a employee & manager
 - susan => is a employee & manager & admin

and the password for three users is : fun123


Have Fun .... 
