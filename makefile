JFLAGS = -d bin -sourcepath src
JUNIT_JAR = junit-platform-console-standalone-1.2.0.jar
LAUNCHER = org.junit.platform.console.ConsoleLauncher --scan-class-path
TEST_CLASS = --scan-class-path

default:
	@echo "'make clean' removes *.class *~ files"
	@echo "'make compile' compiles all Java files"
	@echo "'make demo' runs simulator demo"

test: $(JUNIT_JAR) 
	java -cp .:bin:$(JUNIT_JAR):$(HEADSTONE_JAR) $(LAUNCHER) $(TEST_CLASS)

clean:
	rm -f bin/*.class
	rm -f src/*~
	rm -f *~

compile: $(JUNIT_JAR) 
	javac $(JFLAGS) -cp .:$(JUNIT_JAR) src/*.java

demo: bin/Demo.class
	java -cp .:bin Demo $(filter-out $@,$(MAKECMDGOALS))

# these are needed to allow "command line args" with make demo
# https://stackoverflow.com/questions/6273608/how-to-pass-argument-to-makefile-from-command-line/6273809
%:
	@:
