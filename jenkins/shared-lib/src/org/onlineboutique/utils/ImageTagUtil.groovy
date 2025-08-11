package org.onlineboutique.utils

class ImageTagUtil implements Serializable {
  static String generateTag() {
    def commit = System.getenv("GIT_COMMIT") ?: "dev"
    def timestamp = new Date().format("yyyyMMdd-HHmmss")
    return "${commit.take(7)}-${timestamp}"
  }
}
