package org.eluder.coveralls.maven.plugin.saga;

import java.io.File;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.eluder.coveralls.maven.plugin.AbstractCoverallsMojo;
import org.eluder.coveralls.maven.plugin.CoverageParser;
import org.eluder.coveralls.maven.plugin.domain.SourceLoader;

@Mojo(name = "saga", threadSafe = false)
public class SagaMojo extends AbstractCoverallsMojo {

    /**
     * File path to Saga coverage file.
     */
    @Parameter(property = "coverageFile", defaultValue = "${project.build.directory}/saga-coverage/total-coverage.xml")
    protected File coverageFile;

    /**
     * Sage <a href="http://timurstrekalov.github.io/saga/">Base dir</a>.
     */
    @Parameter(property = "baseDir", required = true, defaultValue = "")
    protected String baseDir;

    @Override
    protected CoverageParser createCoverageParser(final SourceLoader sourceLoader) {
        return new SagaParser(coverageFile, sourceLoader);
    }

    @Override
    protected SourceLoader createSourceLoader() {
        return new SourceLoader(sourceDirectories, sourceEncoding, baseDir);
    }
}
