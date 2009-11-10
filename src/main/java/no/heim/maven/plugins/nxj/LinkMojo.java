package no.heim.maven.plugins.nxj;

import js.tinyvm.TinyVM;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Echos an object string to the output screen.
 * @goal link
 * @requiresProject true
 */
public class LinkMojo extends AbstractMojo
{
    /**
     * Any Object to print out.
     * @parameter expression="${echo.message}" default-value="Hello World..."
     */
    private Object message;
    
    /**
     * Location of lejos-classes.
     * @parameter expression="${bootClassPath}"
     */
    private Object bootClassPath;
    
    /**
     * Name of main class
     * @parameter expression="${mainClass}"
     */
    private Object mainClass;
    
    /**
     * Name of output application
     * @parameter expression="${applicationName}
     */
    private Object applicationName;
    
    
    /**
     * Filter unused classes?
     * @parameter expression="${filterUnused} default-value=true;
     */
    private Object filterUnusedClasses;

    public void execute()
        throws MojoExecutionException, MojoFailureException
    {
    	String myArgs[] = {"-bp", "/home/andreas/lejos_nxj/lib/classes.jar", "-cp", 
				"target/classes", "-wo", "LE" , "App" ,"-o", "target/Appers.nxj", "-v"};
    	
    	TinyVM tinyVM = new TinyVM();
    	
    	String classPath = TinyVM.joinCP(bootClassPath.toString(), "target/classes"); 
    	
    	boolean all = !Boolean.parseBoolean(filterUnusedClasses.toString());
    	String classes[] = { mainClass.toString() };
    	tinyVM.start(classPath, classes, all, "target/" + applicationName.toString(), 
    			false, false, 0, true);
    	
        getLog().info( message.toString() );
    }

}
