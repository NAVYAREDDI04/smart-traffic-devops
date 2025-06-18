pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/yourusername/smart-traffic-devops.git'
            }
        }
        stage('Build') {
            steps {
                sh 'cd traffic-api && mvn clean package'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t traffic-api:latest ./traffic-api'
            }
        }
        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook ansible/deploy.yml -i ansible/inventory'
            }
        }
    }
}
