# installs the lejos jars in the local maven repo

mvn install:install-file -DgroupId=org.lejos -DartifactId=classes -Dversion=0.85 -Dpackaging=jar -Dfile=classes.jar
mvn install:install-file -DgroupId=org.lejos -DartifactId=jtools -Dversion=0.85 -Dpackaging=jar -Dfile=jtools.jar
mvn install:install-file -DgroupId=org.lejos -DartifactId=pctools -Dversion=0.85 -Dpackaging=jar -Dfile=pctools.jar
mvn install:install-file -DgroupId=org.lejos -DartifactId=pccomms -Dversion=0,85 -Dpackaging=jar -Dfile=pccomm.jar