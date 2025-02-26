pipeline {
    agent any



    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/Himanshu-Shrivastava1729/Devops_project1.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }





//         stage('Deploy with Ansible') {
//                     steps {
//                         script {
//                             def deployStatus = sh(script: 'ansible-playbook --connection=local --become deploy.yml', returnStatus: true)
//                             if (deployStatus != 0) {
//                                 error "Deployment failed!"
//                             }
//                         }
//                     }
//                 }

//         stage('Run Ansible Playbook') {
//                     steps {
//                         script {
//                             ansiblePlaybook(
//                                 playbook: 'deploy.yml',
//                                 inventory: 'inventory'
//                             )
//                         }
//                     }
//                 }

    }

    post {
        success {
            emailext(
                to: 'himanshushrivastava227@gmail.com',
                subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>The build and deployment were <b>successful!</b></p>
                         <p>Check the build details: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>"""
            )
        }
        failure {
            emailext(
                to: 'himanshushrivastava227@gmail.com',
                subject: "FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>The build or deployment <b>failed!</b></p>
                         <p>Check the build details: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>"""
            )
        }
        always {
            cleanWs()
        }
    }
}