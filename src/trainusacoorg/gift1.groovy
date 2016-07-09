def result = [:]
def line;
File file = new File('gift1.in')

file.withReader { reader ->
  def numberOfPeople = reader.readLine().toInteger()

  (1..numberOfPeople).each {
    result[reader.readLine()] = 0
  }

  (1..numberOfPeople).each {
    def name = reader.readLine()
    def giveInfo = reader.readLine().split(" ")
    int numOfReceiver = giveInfo[1].toInteger()

    if (numOfReceiver > 0){
      int money = giveInfo[0].toInteger()
      int moneyShard = money / numOfReceiver

      result[name] = (result[name] - money) + (money % numOfReceiver)

      (1..numOfReceiver).each {
        result[reader.readLine()] += moneyShard
      }
    }
  }

  println result
}
