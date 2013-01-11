package no.heim.maven.plugins.nxj;

import js.tinyvm.TinyVM;
import js.tinyvm.TinyVMException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.util.Map;

/**
 * Echos an object string to the output screen.
 * @goal link
 * @requiresProject true
 * @execute phase="compile"
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
     * @parameter expression="${filterUnused}" default-value=true;
     */
    private Object filterUnusedClasses;

    public void execute()
        throws MojoExecutionException, MojoFailureException
    {
    	
    	TinyVM tinyVM = new TinyVM();
    	
    	String classPath = TinyVM.joinCP(bootClassPath.toString(), "target/classes"); 
    	
    	boolean all = !Boolean.parseBoolean(filterUnusedClasses.toString());
    	String classes[] = { mainClass.toString() };
    	try {
			tinyVM.start(classPath, classes, all, "target/" + applicationName.toString(), 
					false, false, 0, true);
		} catch (TinyVMException e) {
			getLog().error("Could not perform linking", e);
			throw new MojoFailureException(e, "Error", "");
		}
    	
        getLog().info( message.toString() );
    }


    private void bajs() {
        Map ctx = getPluginContext();
        
    }


}
