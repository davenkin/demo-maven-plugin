package me.davenkin;


import org.apache.commons.lang.StringUtils;
import org.apache.maven.model.Build;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

/**
 * @goal projectinfo
 * @phase package
 */
public class ProjectInfoMojo extends AbstractMojo {

    /**
     * @parameter expression="${project}"
     * @readonly
     */
    private MavenProject project;

    /**
     * @parameter expression="${projectinfo.separator}"
     * default-value=";"
     */
    private String separator;

    public void execute() throws MojoExecutionException {
        Build build = project.getBuild();
        String outputDirectory = build.getOutputDirectory();
        String sourceDirectory = build.getSourceDirectory();
        String testOutputDirectory = build.getTestOutputDirectory();
        String testSourceDirectory = build.getTestSourceDirectory();
        String output = StringUtils.join(new Object[]{outputDirectory, sourceDirectory, testOutputDirectory
                , testSourceDirectory}, separator);
        getLog().info(output);
    }
}
