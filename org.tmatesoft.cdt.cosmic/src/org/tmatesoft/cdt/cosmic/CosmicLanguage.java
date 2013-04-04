package org.tmatesoft.cdt.cosmic;

import org.eclipse.cdt.core.dom.ast.gnu.c.GCCLanguage;
import org.eclipse.cdt.core.dom.parser.IScannerExtensionConfiguration;
import org.eclipse.cdt.core.dom.parser.ISourceCodeParser;
import org.eclipse.cdt.core.index.IIndex;
import org.eclipse.cdt.core.parser.IParserLogService;
import org.eclipse.cdt.core.parser.IScanner;
import org.eclipse.cdt.core.parser.IScannerInfo;

public class CosmicLanguage extends GCCLanguage {
    
    private static final CosmicLanguage instance = new CosmicLanguage();
    
    private static final String NAME = "Cosmic GNU C"; 
    private static final String LANGAUGE_ID = Activator.ID + ".cosmic-gnu-c"; 
    
    public static CosmicLanguage getDefault() {
        return instance;
    }

    @Override
    public String getName() {
        return NAME;
    }
    
    @Override
    public String getId() {
        return LANGAUGE_ID;
    }

    @Override
    protected ISourceCodeParser createParser(IScanner scanner,
            IParserLogService log, IIndex index, boolean forCompletion,
            int options) {
        if (!(scanner instanceof CosmicScanner)) {
            scanner = new CosmicScanner(scanner);
        }
        return super.createParser(scanner, log, index, forCompletion, options);
    }

    @Override
    protected IScannerExtensionConfiguration getScannerExtensionConfiguration() {
        return CosmicScannerExtensionConfiguration.getInstance();
    }

    @Override
    protected IScannerExtensionConfiguration getScannerExtensionConfiguration(IScannerInfo info) {
        return CosmicScannerExtensionConfiguration.getInstance();
    }
}
