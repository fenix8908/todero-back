pipeline {
    agent any

    environment {
        DOCKER_COMPOSE_FILE = 'docker-compose.yml'
    }

    stages {
        stage('Checkout') {
            steps {
                // Clonar el repositorio
                git branch: 'main', url: 'https://github.com/fenix8908/security-jwt.git'
            }
        }

        stage('Build') {
            steps {
                // Construir los contenedores con Docker Compose
                sh 'docker-compose -f $DOCKER_COMPOSE_FILE build'
            }
        }

        stage('Test') {
            steps {
                // Ejecutar los tests
                sh 'docker-compose -f $DOCKER_COMPOSE_FILE run --rm myapp-backend ./mvnw test'
                sh 'docker-compose -f $DOCKER_COMPOSE_FILE run --rm myapp-frontend ng test --watch=false'
            }
        }

        stage('Deploy') {
            steps {
                // Levantar los contenedores
                sh 'docker-compose -f $DOCKER_COMPOSE_FILE up -d'
            }
        }
    }

    post {
        always {
            // Limpiar los contenedores después de cada ejecución
            sh 'docker-compose -f $DOCKER_COMPOSE_FILE down'
        }
    }
}
