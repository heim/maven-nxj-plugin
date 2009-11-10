import js.tinyvm.TinyVM;
public class LinkSpike {

	/**
	 * @param args
	 *   <target name="link" depends="compile"
        description="link the binary" >
    <!-- Link the binary and create a signature file -->
    <java classname="js.tinyvm.TinyVM">
      <arg value="--bootclasspath"/>
      <arg path="${nxj.classes.jar}" /> 
      <arg value="--classpath"/>
      <arg path="." /> 
      <arg value="--writeorder" />
      <arg value="LE" />
      <arg value="${program}"/>
      <arg value="-o"/>
      <arg value="${binary}"/>
      <arg value="-v"/>
      <classpath>
        <pathelement location="${nxj.jtools.jar}"/>
  		<pathelement location="${nxj.commons.jar}"/>
  		<pathelement location="${nxj.bcel.jar}"/>
      </classpath>
    </java>
  </target>
	 */
	public static void main(String[] args) throws Exception {
		String myArgs[] = {"-bp", "/home/andreas/lejos_nxj/lib/classes.jar", "-cp", 
				"target/classes", "-wo", "LE" , "App" ,"-o", "target/Appers.nxj", "-v"};
		TinyVM tinyVM = new TinyVM();
		tinyVM.start(myArgs);
		
		
	}

}
