# Student Management System (Hibernate + MySQL)

A simple CRUD-based Student Management System built using Java, Hibernate ORM, MySQL, and Maven. This project demonstrates the use of Hibernate for performing basic operations such as Create, Read, Update, and Delete on a `Student` entity.

---

## 🔧 Tech Stack

- Java 11
- Hibernate 5+
- Maven
- MySQL
- JDBC
- Log4j (for logging)

---

## 📂 Project Structure
```properties
src/
├── main/
│ ├── java/
│ │ └── com.studentmanagement/
│ │ ├── config/
│ │ │ └── HibernateUtil.java
│ │ ├── dao/
│ │ │ └── StudentDAO.java
│ │ ├── model/
│ │ │ └── Student.java
│ │ ├── service/
│ │ │ └── StudentService.java
│ │ └── Main.java
│ └── resources/
│ ├── hibernate.cfg.xml
│ └── log4j.properties
```

---

## 📘 Features

- Add a new student
- View all students
- Update student information
- Delete student by ID
- Search student by ID

---

## 🗄️ Database Configuration

MySQL Table:

```sql
CREATE TABLE student (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  course VARCHAR(100) NOT NULL
);
```
## Hibernate Configuration
hibernate.cfg.xml:
```bash
<hibernate-configuration>
  <session-factory>
    <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/studentdb</property>
    <property name="hibernate.connection.username">root</property>
    <property name="hibernate.connection.password">yourpassword</property>
    <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
    <property name="show_sql">true</property>
    <property name="hbm2ddl.auto">update</property>
    
    <mapping class="com.studentmanagement.model.Student"/>
  </session-factory>
</hibernate-configuration>
```

## How to Run
 - Clone the repository.

 - Import as Maven Project in your IDE.

 - Set your MySQL credentials in hibernate.cfg.xml.

 - Create the database studentdb.

 - Run Main.java to start the app.

## Project Structure

- **controller**: REST controllers for handling HTTP requests
- **service**: Business logic layer
- **repository**: Hibernate data access layer
- **model**: Entity classes
- **config**: Hibernate configuration

## API Endpoints
# Create a New Student
```bash
curl -X POST http://localhost:8080/api/studentManagement/student \
-H "Content-Type: application/json" \
-d '{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "age": 22
}'
```
# Get Student by ID
```bash
curl -X GET http://localhost:8080/api/studentManagement/student/1
```
#Get All Students
```bash
curl -X GET http://localhost:8080/api/studentManagement/students

```
## Update Existing Student by ID
```bash
curl -X PUT http://localhost:8080/api/studentManagement/student/1 \
-H "Content-Type: application/json" \
-d '{
  "name": "John Updated",
  "email": "john.updated@example.com",
  "age": 23
}'

```
## Delete Student by ID
```bash
curl -X DELETE http://localhost:8080/api/studentManagement/student/1

```

## Sample JSON for Student
```bash
{
  "id": 1,
  "name": "John Doe",
  "percentage": 90
}

```

##  Dependencies (pom.xml)
```bash

    <properties>
        <java.version>11</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>2.7.14</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>4.3.5.Final</version>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-c3p0</artifactId>
            <version>4.3.5.Final</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>2.7.14</version>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
        </plugins>
    </build>

    <repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
        <repository>
            <id>spring-snapshots</id>
            <name>Spring Snapshots</name>
            <url>https://repo.spring.io/snapshot</url>
            <releases>
                <enabled>false</enabled>
            </releases>
        </repository>
    </repositories>

    <pluginRepositories>
        <pluginRepository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </pluginRepository>
        <pluginRepository>
            <id>spring-snapshots</id>
            <name>Spring Snapshots</name>
            <url>https://repo.spring.io/snapshot</url>
            <releases>
                <enabled>false</enabled>
            </releases>
        </pluginRepository>
    </pluginRepositories>

</project>
```