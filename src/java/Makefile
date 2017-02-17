JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Instruction.java \
	Etiqueta.java \
	Mr.java \
	Ir.java \
	InputVector.java \
	OutputVector.java \
	Principal.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class