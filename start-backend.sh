#!/bin/bash

# Kill any existing Java processes
pkill -f "spring-boot:run"

# Wait a moment
sleep 2

# Start the backend with explicit H2 configuration
export SPRING_DATASOURCE_URL=jdbc:h2:mem:testdb
export SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.h2.Driver
export SPRING_DATASOURCE_USERNAME=sa
export SPRING_DATASOURCE_PASSWORD=password
export SPRING_JPA_HIBERNATE_DDL_AUTO=create-drop
export SPRING_JPA_SHOW_SQL=true
export SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.H2Dialect

echo "Starting backend with H2 database..."
./mvnw spring-boot:run
