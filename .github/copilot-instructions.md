# Photo Catalog Manager

Photo Catalog Manager is a Java Swing desktop application for managing product photo catalogs using Google Drive sync and SQLite database. It helps vendors organize their catalog of product photos with a local desktop directory for web repository management.

Always reference these instructions first and fallback to search or bash commands only when you encounter unexpected information that does not match the info here.

## Working Effectively
- Bootstrap, build, and test the repository:
  - `mvn clean` -- takes 1-2 seconds  
  - `mvn compile` -- takes 3-4 seconds
  - `mvn package -DskipTests` -- takes 5-6 seconds. NEVER CANCEL. Set timeout to 60+ seconds.
- Test the application:
  - `mvn test` -- FAILS due to Java version compatibility. Tests require Java 8 but environment uses Java 17.
  - Use `mvn package -DskipTests` to build without running tests
- Run the application:
  - ALWAYS build first using `mvn package -DskipTests`
  - Desktop GUI: `java -jar target/photo-catalog-manager-0.0.1-SNAPSHOT-jar-with-dependencies.jar`
  - CANNOT run in headless environments (no X11 display) - GUI application only

## Java Version Compatibility Issues
- Project configured for Java 8 (source/target 1.8 in pom.xml)
- Environment provides Java 17 which causes test failures due to missing JAXB classes
- Build and compilation work fine with Java 17
- Tests fail with `ClassNotFoundException: javax.xml.bind.JAXBException`
- ALWAYS use `-DskipTests` flag when packaging to avoid test failures

## Validation
- Always manually validate code changes by building with `mvn package -DskipTests`
- CANNOT interact with GUI in headless environment but can verify JAR is created successfully
- ALWAYS run `mvn clean compile` to verify your changes compile without errors
- Main application JAR created at: `target/photo-catalog-manager-0.0.1-SNAPSHOT-jar-with-dependencies.jar`
- Test functionality requires Windows environment with display for full GUI testing

## Build Timing and Timeouts
- `mvn clean`: 1-2 seconds
- `mvn compile`: 3-4 seconds  
- `mvn package -DskipTests`: 5-6 seconds
- `mvn test`: 8-10 seconds (but FAILS due to Java compatibility)
- NEVER CANCEL: Set timeouts to minimum 60 seconds for package operations
- Initial download of dependencies adds ~15-20 seconds on fresh clone

## Common Tasks
The following are outputs from frequently run commands. Reference them instead of viewing, searching, or running bash commands to save time.

### Repository Structure
```
.
├── README.md
├── pom.xml                    # Maven build configuration
├── photoCatalogManager.db     # SQLite database file
├── src/
│   ├── main/
│   │   ├── java/br/fsg/filereader/
│   │   │   ├── view/Principal.java      # Main GUI class and entry point
│   │   │   ├── model/                   # JPA entities (Directory, Product, Configuration, Sale)
│   │   │   ├── repository/              # Data access layer
│   │   │   ├── util/PersistenceManager.java # JPA configuration
│   │   │   ├── controller/              # Business logic
│   │   │   └── tablemodel/              # Swing table models
│   │   └── resources/
│   │       ├── META-INF/persistence.xml # JPA configuration
│   │       ├── log4j2.properties        # Logging configuration
│   │       └── imagens/                 # Application icons
│   └── test/
│       ├── java/br/fsg/filereader/      # Unit tests (require Java 8)
│       └── resources/                   # Test data and SQLite test DB
└── target/                              # Build output (created by Maven)
```

### Key Components
- **Main Class**: `br.fsg.filereader.view.Principal` - Swing GUI application entry point
- **Database**: SQLite with Hibernate/JPA, configured in `persistence.xml`
- **Build Tool**: Maven with assembly plugin for fat JAR creation
- **GUI Framework**: Java Swing with Nimbus Look and Feel
- **Persistence**: Hibernate 5.2.15.Final with SQLite dialect

### Maven Dependencies
- Java 8 compatibility (source/target 1.8)
- Hibernate 5.2.15.Final for ORM
- SQLite JDBC driver 3.21.0.1
- Commons IO 2.6 for file operations
- Log4j 2.11.0 for logging
- JUnit 4.12 for testing (tests currently fail on Java 17)

### Database Configuration
- SQLite database: `photocatalogmanager.db` in project root
- JPA entities: Directory, Product, Configuration, Sale
- Connection URL: `jdbc:sqlite:photocatalogmanager.db`
- No username/password required
- Hibernate SQL logging enabled in development

### Build Artifacts
- Standard JAR: `target/photo-catalog-manager-0.0.1-SNAPSHOT.jar`  
- Executable JAR: `target/photo-catalog-manager-0.0.1-SNAPSHOT-jar-with-dependencies.jar` (~20MB)
- Fat JAR includes all dependencies for standalone execution

### Known Issues and Workarounds
- Tests fail on Java 17 due to JAXB compatibility - use `mvn package -DskipTests`
- GUI requires display environment - cannot run in headless CI/CD
- Nimbus Look and Feel may not be available on all systems - application handles gracefully
- Hardcoded Windows paths in test files cause test failures on Linux/Mac

### Development Workflow
1. Make code changes in `src/main/java`
2. Run `mvn clean compile` to verify compilation
3. Run `mvn package -DskipTests` to create executable JAR
4. Test GUI manually in environment with display
5. NEVER run `mvn test` in Java 17 environment - it will fail

### Frequently Modified Files
- `src/main/java/br/fsg/filereader/view/Principal.java` - Main GUI and application setup
- `src/main/java/br/fsg/filereader/util/PersistenceManager.java` - Database connection
- `src/main/java/br/fsg/filereader/model/` - Data model changes
- `src/main/resources/META-INF/persistence.xml` - Database configuration
- `pom.xml` - Dependencies and build configuration