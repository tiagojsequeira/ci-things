import java.net.URLEncoder

// Put env vars
class Dashing implements Serializable {

    def script;

    Dashing(def script){
      this.script = script
    }

    def notify(buildResult, branchName, commitAuthor ,time) {
      def String payload = URLEncoder.encode('{ "buildResult":"'+buildResult+'\","branchName":\"'+branchName+'\","commitAuthor":\"'+commitAuthor+'\","buildTime":\"'+time+'\"}','UTF-8')
      script.httpRequest "http://192.168.5.201:8080/webhook.php?name=LastBuildiOS&payload="+payload
    }

}
