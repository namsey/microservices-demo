import org.onlineboutique.utils.ImageTagUtil

def call(Map args = [:]) {
  def service = args.service
  def imageRepo = args.imageRepo
  def tag = ImageTagUtil.generateTag()

  dir(service) {
    sh """
      aws ecr get-login-password | docker login --username AWS --password-stdin ${imageRepo}
      docker build -t ${imageRepo}/${service}:${tag} .
      docker push ${imageRepo}/${service}:${tag}
    """
  }
}
