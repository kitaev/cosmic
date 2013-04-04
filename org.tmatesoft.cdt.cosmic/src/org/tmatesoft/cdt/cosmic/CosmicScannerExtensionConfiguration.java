package org.tmatesoft.cdt.cosmic;

import org.eclipse.cdt.core.dom.parser.c.GCCScannerExtensionConfiguration;

public class CosmicScannerExtensionConfiguration extends GCCScannerExtensionConfiguration {
    
    private static CosmicScannerExtensionConfiguration instance = new CosmicScannerExtensionConfiguration();
    
    public static CosmicScannerExtensionConfiguration getInstance() {
        return instance;
    }
    
    public CosmicScannerExtensionConfiguration() {
    }

    @Override
    public boolean supportAtSignInIdentifiers() {
        return true;
    }
    
    
}
