def call(Map args = [:]) {
  def service = args.service
  if (fileExists("${service}/build.gradle")) {
    dir(service) {
      sh './gradlew test'
    }
  } else if (fileExists("${service}/package.json")) {
    dir(service) {
      sh 'npm test'
    }
  } else if (fileExists("${service}/go.mod")) {
    dir(service) {
      sh 'go test ./...'
    }
  } else {
    echo "No tests found for ${service}"
  }
}
