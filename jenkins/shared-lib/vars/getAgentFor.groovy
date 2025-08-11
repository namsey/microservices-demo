def call(Map args = [:]) {
  def service = args.service
  if (fileExists("${service}/build.gradle")) return 'java-builder'
  if (fileExists("${service}/package.json")) return 'node-builder'
  if (fileExists("${service}/go.mod")) return 'go-builder'
  return 'default-agent'
}
