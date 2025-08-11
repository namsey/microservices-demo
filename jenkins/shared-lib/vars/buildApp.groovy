def call(Map args = [:]) {
  def service = args.service
  if (fileExists("${service}/build.gradle")) {
    dir(service) {
      sh './gradlew build -x test'
    }
  } else if (fileExists("${service}/package.json")) {
    dir(service) {
      sh 'npm ci && npm run build'
    }
  } else if (fileExists("${service}/go.mod")) {
    dir(service) {
      sh 'go build -o main .'
    }
  } else {
    error "No known build tool found in ${service}"
  }
}
