#!/usr/bin/env bash
jjtree CcalGrammar.jjt;
javacc CcalGrammar.jj;

# The script is reading the path to javac from my .bashrc
# Temporary fix is to put in full path to javac
/usr/local/java/jdk1.8.0_144/bin/javac *.java
