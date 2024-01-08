runTests: AlgorithmEngineerTests.class HospitalPathPlaceHolderAE.class
	java -jar junit5.jar --class-path . --scan-classpath

AlgorithmEngineerTests.class: CS400GraphSorted.class
	javac -cp .:junit5.jar AlgorithmEngineerTests.java -Xlint

CS400GraphSorted.class: CS400Graph.class
	javac CS400GraphSorted.java

CS400Graph.class:
	javac CS400Graph.java

HospitalPathPlaceHolderAE.class: CS400Graph.class
	javac HospitalPathPlaceHolderAE.java
clean:
	rm *.class


