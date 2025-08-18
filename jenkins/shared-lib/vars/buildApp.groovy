def call(Map args = [:]) {
  def service = args.service

  if (fileExists("build.gradle")) {
    sh './gradlew build -x test'
  } else if (fileExists("package.json")) {
    sh 'npm ci && npm run build'
  } else if (fileExists("go.mod")) {
    sh 'go build -o main .'
  } else {
    error "No known build tool found in ${service}"
  }
}
