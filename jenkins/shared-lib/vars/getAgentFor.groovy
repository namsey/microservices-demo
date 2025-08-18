def call(Map args = [:]) {
  if (fileExists("build.gradle")) return 'java-builder'
  if (fileExists("package.json")) return 'node-builder'
  if (fileExists("go.mod")) return 'go-builder'
  return 'default-agent'
}
