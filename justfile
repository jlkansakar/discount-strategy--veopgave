
cli:
  mvn exec:java

gui:
  mvn compile
  mvn exec:java -Dexec.args="--gui"
