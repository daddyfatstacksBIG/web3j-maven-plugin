package org.web3j.mavenplugin.solidity;

import java.util.regex.Matcher;
import org.apache.maven.plugin.MojoExecutionException;

public class VersionMismatchException extends MojoExecutionException {

  private final String solidityContractVersion;
  private final String solCVersion;

  public VersionMismatchException(String version, String message) {
    super("Could not compile solidity source file. Version mismatch.");
    solCVersion = version;

    Matcher matcher = Constant.SOLIDITY_VERSION_EXTRACT.matcher(message);
    solidityContractVersion = (matcher.find()) ? matcher.group(1) : null;
  }

  public String getSolCVersion() { return solCVersion; }

  public String getSolidityContractVersion() { return solidityContractVersion; }
}
