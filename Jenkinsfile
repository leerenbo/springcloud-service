pipeline {
    agent {
        docker {
            image 'leerenbo/git-java10-maven-ssh'
            args '--mount type=bind,source=/root/.m2,target=/root/.m2'
        }
    }
    stages {
        stage('Prepare') {
            steps {
                sh 'echo Prepare'
            }
        }
        stage('Install') {
            steps {
                sh 'mvn install -U -B -e'
            }
        }
        stage('Delivery') {
            when{
                branch 'dev'
            }
            steps {
                sh 'mkdir -p /root/.ssh/'
                sh 'cp jenkins/dev/id_rsa /root/.ssh/'
                sh 'chmod 700 ~/.ssh'
                sh 'chmod 600 ~/.ssh/id_rsa'
                sh 'scp -o StrictHostKeyChecking=no service-boot-web/target/service-boot-web-0.0.1-SNAPSHOT.jar root@172.100.101.84:/tmp/'
            }
        }
        stage('Deploy'){
            when{
                branch 'dev'
            }
            steps{
                sh 'bash jenkins/dev/deploy.sh'
            }
        }
    }
    post {
        always {
            junit 'service-boot-web/target/surefire-reports/*.xml'
        }
    }
}
